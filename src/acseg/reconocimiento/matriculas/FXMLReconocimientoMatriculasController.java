/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acseg.reconocimiento.matriculas;

import acseg.DbConnection.DbException;
import acseg.utils.LogUtils;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import acseg.utils.Utils;
import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.text.ParseException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

/**
 * Controller class which handles all the views. 
 * Carnet Recognisition view and License Plate number recognisition view do pretty the same.
 * Because of that, makes sense to use just one controller for handling those views. 
 * Since Choose view and Login view logic are pretty simple, it is not necesary to add other controller.
 * @author <a href="mailto:migue.guev@gmail.com">Miguel Guevara</a>
 *@author <a href="mailto:joandv.gil@gmail.com">Joan Gil</a>
 */
public class FXMLReconocimientoMatriculasController implements Initializable {

    @FXML
    private Button startButton;
    @FXML
    private Button mButton;
    @FXML
    private Button loginButton;
    @FXML
    private PasswordField pass;
    @FXML
    private TextField user;
    @FXML
    private Label errmsj;
    @FXML
    private ImageView currentFrame;
    @FXML
    private ImageView imgWebCamCapturedImage;
    @FXML
    private AnchorPane cameraView;
    @FXML
    private Label plateNumber;
    @FXML
    private Label result;
    @FXML
    private Label readId;
    @FXML
    private Label noAccess;
    @FXML
    private Button cButton;

    // a timer for acquiring the video stream
    private ScheduledExecutorService timer;
    private ScheduledExecutorService timerR;
    // the OpenCV object that realizes the video capture
    private final VideoCapture capture = new VideoCapture();
    // a flag to change the startButton behavior
    private boolean cameraActive = false;
    // the id of the camera to be used
    private static int cameraId = 0;

    public static Mat fm = null;
    private BufferedImage grabbedImage;
    private final ObjectProperty<Image> imageProperty = new SimpleObjectProperty<>();

    /**
     * The action triggered by pushing the startButton on the GUI
     *
     * @param event the push startButton event
     */
    @FXML
    protected void startCamera(ActionEvent event) throws DbException {
        if (!this.cameraActive) {
            Utils.startConnection();
            //Iniciamos la camara para capturar video
            this.capture.open(cameraId);
            //Preguntamos si el video esta disponible
            if (this.capture.isOpened()) {
                this.cameraActive = true;
                //Hilo de video (30 frames/sec)
                Runnable frameGrabber = new Runnable() {
                    @Override
                    public void run() {
                        //Se recibe un frame
                        Mat frame = grabFrame();
                        //Se convierte a imagen
                        Image imageToShow = Utils.mat2Image(frame);

                        //Actualizamos la imagen en pantalla
                        updateImageView(currentFrame, imageToShow);
                    }
                };

                this.timer = Executors.newSingleThreadScheduledExecutor();
                this.timer.scheduleAtFixedRate(frameGrabber,
                        0, 33, TimeUnit.MILLISECONDS);

                //Hilo de reconocimiento de matriculas
                Runnable recogFrame = () -> {
                    try {
                        if ((fm != null) && (event.getSource() == startButton)) {
                            String strPlate = getStrPlate();
                            //Platform.runLater(() -> {
                                try {
                                    validatePlates(strPlate);
                                } catch (ParseException ex) {
                                    Logger.getLogger(FXMLReconocimientoMatriculasController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            //});
                        } else {
                            if ((fm != null)) {
                                //Platform.runLater(() -> {
                                    grabbedImage=getBufferedImage();
                                    Result decodedBar = getDecodedImage();
                                    try {
                                        validateBarcode(decodedBar);
                                    } catch (ParseException ex) {
                                        Logger.getLogger(FXMLReconocimientoMatriculasController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                //});
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(FXMLReconocimientoMatriculasController.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                };

                this.timerR = Executors.newSingleThreadScheduledExecutor();
                this.timerR.scheduleAtFixedRate(recogFrame, 0, 33, TimeUnit.MILLISECONDS);

               if (event.getSource()==startButton){
                   this.startButton.setText("Detener");
               }else{
                   this.cButton.setText("Detener");
                
               }
            } else {
                System.err.println("No se puede conectar a la camara...");
            }
        } else {
            this.cameraActive = false;
                if (event.getSource()==startButton){
                   this.startButton.setText("Comenzar");
               }else{
                   this.cButton.setText("Comenzar");
               }

            //Se detienen los procesos
            this.stopAcquisition();
            Utils.stopConnection();
        }
    }

    private void validatePlates(String strPlate) throws ParseException, InterruptedException {
        if (Utils.isRealPlate(strPlate)) {
            Platform.runLater(() -> {
                plateNumber.setText(strPlate);
            });
            try {
                if (Utils.isValidPlate(strPlate)) { 
                    if (Utils.isVehicleOnCampus(strPlate)){
                        Platform.runLater(() -> {
                         result.setTextFill(Color.LIMEGREEN);
                         result.setText("SALIDA");
                        });
                        Utils.setOnCampusVehicle(strPlate, false);
                        Utils.addLog(strPlate, "SALIDA");
                    }
                    else{
                        Platform.runLater(() -> {
                        result.setTextFill(Color.LIMEGREEN);
                        result.setText("ACCESO");
                        });
                        Utils.setOnCampusVehicle(strPlate, true);
                        Utils.addLog(strPlate, "ENTRADA");
                    }
                    Thread.sleep(8000);
                }else {
                    Platform.runLater(() -> {
                        result.setTextFill(Color.RED);
                        result.setText("NO ACCESO");
                    });

                }
            } catch (DbException ex) {
                Logger.getLogger(FXMLReconocimientoMatriculasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void validateBarcode(Result decodedBar) throws ParseException, InterruptedException {
        if (decodedBar != null) {
            Platform.runLater(() -> {
                readId.setText(decodedBar.getText());
            });
            try {
                String cedula = decodedBar.getText().replace("V","");
                if (Utils.isMember(cedula)) {
                    if (Utils.isOnCampus(cedula)){
                        Platform.runLater(() -> {
                            result.setTextFill(Color.LIMEGREEN);
                            result.setText("SALIDA");
                        });
                        Utils.setOnCampus(cedula, false);
                        Utils.addPersonLog(cedula, "SALIDA");
                    }else{
                        Platform.runLater(() -> {
                        result.setTextFill(Color.LIMEGREEN);
                        result.setText("ACCESO");
                        });
                        Utils.setOnCampus(cedula, true);
                        Utils.addPersonLog(cedula, "ENTRADA");
                    }
                    Thread.sleep(5000);
                } else {
                    Platform.runLater(() -> {
                    result.setTextFill(Color.RED);
                    result.setText("NO ACCESO");
                    });
                }
            } catch (DbException ex) {
                Logger.getLogger(FXMLReconocimientoMatriculasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Result getDecodedImage() {
        LuminanceSource source = new BufferedImageLuminanceSource(grabbedImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result decodedBar = null;
        try {
            decodedBar = new MultiFormatReader().decode(bitmap);
        } catch (NotFoundException e) {

            //No hay código en la imágen
        }
        return decodedBar;
    }
    
    
    BufferedImage getBufferedImage(){
        
        return 
                Utils.matToBufferedImage(FXMLReconocimientoMatriculasController.fm);
        
    }

    private String getStrPlate() throws Exception {
        javaanpr.imageanalysis.CarSnapshot car
                = new javaanpr.imageanalysis.CarSnapshot(getBufferedImage());
        String strPlate
                = javaanpr.Main.systemLogic.recognize(car);
        if (strPlate != null) {
            strPlate.toUpperCase();
        }
        return strPlate;
    }

    @FXML
    private void loginAction(ActionEvent event) throws IOException, DbException {
        Stage stage = null;
        Parent root;
        validateUser();
        if (LogUtils.loggedIn) {
            stage = (Stage) loginButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
            //create a new scene with root and set the stage
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        } else {
            errmsj.setVisible(true);
        }
    }

    @FXML
    private void matriculas(ActionEvent event) throws IOException, DbException {
        Stage stage = null;
        Parent root;
        if (event.getSource() == mButton && LogUtils.loggedIn) {
            //get reference to the button's stage         
            stage = (Stage) mButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("MatriculasFXML.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);

        }
    }

    @FXML
    private void carnets(ActionEvent event) throws IOException, DbException {
        Stage stage = null;
        Parent root;
        if (event.getSource() == cButton && LogUtils.loggedIn) {
            //get reference to the button's stage         
            stage = (Stage) cButton.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("CarnetsFXML.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);

        }
    }

    private void validateUser() throws DbException {
        if (Utils.isUser(user.getText(), pass.getText())) {
            LogUtils.loggedIn = true;
        }
    }

    /**
     * Get a frame from the opened video stream (if any)
     *
     * @return the {@link Mat} to show
     */
    private Mat grabFrame() {
        //Iniciamos el frme
        Mat frame = new Mat();

        //Verificamos si la camara esta activa para grabar
        if (this.capture.isOpened()) {
            try {
                //leemos el frame actual
                this.capture.read(frame);

                //si el frame no esta vacio lo procesa
                if (!frame.empty()) {
                    fm = frame;
                }

            } catch (Exception e) {
                System.err.println("Exception during the image elaboration: " + e);
            }
        }
        return frame;
    }

    /**
     * Stop the acquisition from the camera and release all the resources
     */
    private void stopAcquisition() {
        if (this.timer != null && !this.timer.isShutdown()) {
            try {
                //detenemos el hilo de grabacion
                this.timer.shutdown();
                this.timer.awaitTermination(33, TimeUnit.MILLISECONDS);

                //detenemos el hilo de reconocimiento
                this.timerR.shutdown();
                this.timerR.awaitTermination(33, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                System.err.println("problema al detener la captura de video,"
                        + " intentando cerrar la camara" + e);
            }
        }
        if (this.capture.isOpened()) {
            //liberamos la camara
            this.capture.release();
        }
    }

    private void updateImageView(ImageView view, Image image) {
        Utils.onFXThread(view.imageProperty(), image);
    }

    protected void setClosed() {
        this.stopAcquisition();
    }

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}

/**
 * Main class which loads the Login view, OPENCV and JavaANPR library. 
 * .  
 * @author <a href="mailto:migue.guev@gmail.com">Miguel Guevara</a>
 *@author <a href="mailto:joandv.gil@gmail.com">Joan Gil</a>
 */

package acseg.reconocimiento.matriculas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javaanpr.Main;
import org.opencv.core.Core;


public class ReconocimientoMatriculas extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().
                getResource("FXMLReconocimientoMatriculas.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.getIcons().add(new javafx.scene.image.
                            Image(getClass().getResourceAsStream("acseg.png")));
        stage.show();
        stage.setResizable(false);
        stage.setOnCloseRequest(e -> javafx.application.Platform.exit());
    }

    public static void main(String[] args) throws Exception {
        //Iniciamos OpenCV
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        //Iniciamos anpr
        Main.systemLogic = new javaanpr.intelligence.Intelligence(false);
        launch(args);
    }
    
}

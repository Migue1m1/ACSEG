package acseg.utils;

import acseg.DbConnection.DbException;
import acseg.reconocimiento.models.Log;
import acseg.reconocimiento.models.LogPersona;
import acseg.reconocimiento.models.Persona;
import acseg.reconocimiento.models.Usuario;
import acseg.reconocimiento.models.Vehiculo;
import com.google.gson.Gson;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.text.ParseException;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.bson.Document;
import org.opencv.core.Mat;

/**
 * Provide general purpose methods for handling OpenCV-JavaFX data conversion.
 * Moreover, expose some "low level" methods for matching few JavaFX behavior.
 * Plus, handles db connections for validating users and plate numbers.
 *
 * @author <a href="mailto:luigi.derussis@polito.it">Luigi De Russis</a>
 * @author <a href="http://max-z.de">Maximilian Zuleger</a>
 * @author <a href="mailto:joandv.gil@gmail.com">Joan Gil</a>
 * @version 1.0 (2016-09-17)
 * @since 1.0
 *
 */
public final class Utils {

    public static acseg.DbConnection.MongoDbConnection dbCon = new acseg.DbConnection.MongoDbConnection("acseg");

    public static Image mat2Image(Mat frame) {
        if (frame == null) {
            System.out.println("Frame nulo...");
            return null;
        }
        try {
            return SwingFXUtils.toFXImage(matToBufferedImage(frame), null);
        } catch (Exception e) {
            System.err.println("Cannot convert the Mat obejct: " + e);
            return null;
        }
    }

    public static <T> void onFXThread(final ObjectProperty<T> property, final T value) {
        Platform.runLater(() -> {
            property.set(value);
        });
    }

    public static BufferedImage matToBufferedImage(Mat original) {
        // init
        if (original == null) {
            System.out.println("Frame nulo...");
            return null;
        }
        BufferedImage image = null;
        int width = original.width(), height = original.height(),
                channels = original.channels();
        byte[] sourcePixels = new byte[width * height * channels];
        original.get(0, 0, sourcePixels);

        if (original.channels() > 1) {
            image = new BufferedImage(width, height,
                    BufferedImage.TYPE_3BYTE_BGR);
        } else {
            image = new BufferedImage(width, height,
                    BufferedImage.TYPE_BYTE_GRAY);
        }
        final byte[] targetPixels
                = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(sourcePixels, 0, targetPixels, 0, sourcePixels.length);

        return image;
    }

    public static Document objectToDoc(Object o) {
        if (o != null) {
            Gson gSon = new Gson();
            String jSon = gSon.toJson(o);
            return Document.parse(jSon);
        }
        System.out.println("Objecto vacio, no se puede convertir a doc JSON...");
        return null;
    }

    public static Persona docToPersona(Document doc) {
        if (doc != null) {
            Gson gSon = new Gson();
            return gSon.fromJson(doc.toJson(), Persona.class);
        }
        System.out.println("Documento JSON vacio,"
                + " no se puede convertir a Persona...");
        return null;
    }

    public static Usuario docToUsuario(Document doc) {
        if (doc != null) {
            Gson gSon = new Gson();
            return gSon.fromJson(doc.toJson(), Usuario.class);
        }
        System.out.println("Documento JSON vacio,"
                + " no se puede convertir a Persona...");
        return null;
    }

    public static Log docToLog(Document doc) {
        if (doc != null) {
            Gson gSon = new Gson();
            return gSon.fromJson(doc.toJson(), Log.class);
        }
        System.out.println("Documento JSON vacio,"
                + " no se puede convertir a Persona...");
        return null;
    }

    public static LogPersona docToLogPersona(Document doc) {
        if (doc != null) {
            Gson gSon = new Gson();
            return gSon.fromJson(doc.toJson(), LogPersona.class);
        }
        System.out.println("Documento JSON vacio,"
                + " no se puede convertir a Persona...");
        return null;
    }

    public static Vehiculo docToVehiculo(Document doc) {
        if (doc != null) {
            Gson gSon = new Gson();
            return gSon.fromJson(doc.toJson(), Vehiculo.class);
        }
        System.out.println("Documento JSON vacio,"
                + " no se puede convertir a Persona...");
        return null;
    }

    public static void imprimirLista(java.util.List<?> result) {
        if (result != null) {
            System.out.println("Numero de registros: " + result.size());
            result.forEach((o) -> {
                System.out.println(o + "\n");
            });
        } else {
            System.out.println("Lista vacia...");
        }
    }

    public static boolean isRealPlate(String plate) {
        return (plate != null) && ((plate.length() == 6) || (plate.length() == 7));
    }

    public static void startConnection() throws DbException {
        dbCon.open();
    }

    public static void stopConnection() throws DbException {
        dbCon.close();
    }

    public static boolean isValidPlate(String strPlate) throws DbException {
        acseg.reconocimiento.adapters.PersonaAdapter pAdapter = new acseg.reconocimiento.adapters.PersonaAdapter();
        return pAdapter.findRecord(dbCon, "mtrAuto", strPlate) != null;
    }

    public static boolean isUser(String username, String pass) throws DbException {
        acseg.DbConnection.MongoDbConnection db = new acseg.DbConnection.MongoDbConnection("acseg");
        db.open();
        acseg.reconocimiento.adapters.UsuarioAdapter uAdapter = new acseg.reconocimiento.adapters.UsuarioAdapter();
        if (uAdapter.findRecord(db, username, pass) != null) {
            db.close();
            return true;
        } else {
            db.close();
            return false;
        }

    }

    public static boolean isMember(String CI) throws DbException {
        acseg.reconocimiento.adapters.PersonaAdapter pAdapter = new acseg.reconocimiento.adapters.PersonaAdapter();
        return pAdapter.findRecord(dbCon, "CI", CI) != null;
    }

    public static boolean isOnCampus(String key) throws DbException {
        acseg.reconocimiento.adapters.PersonaAdapter pAdapter = new acseg.reconocimiento.adapters.PersonaAdapter();
        boolean onCampus = false;
        if ((pAdapter.findRecord(dbCon, "enCampusc", key) != null)) {
            onCampus = true;

        }
        return onCampus;
    }

    public static void setOnCampus(String key, boolean value) {
        acseg.reconocimiento.adapters.PersonaAdapter pAdapter = new acseg.reconocimiento.adapters.PersonaAdapter();

        pAdapter.updateRecord(dbCon, "CI", key, "enCampus", value);

    }
    
    
    public static void setOnCampusVehicle(String key, boolean value) {
        acseg.reconocimiento.adapters.VehiculoAdapter vAdapter = new acseg.reconocimiento.adapters.VehiculoAdapter();
        acseg.reconocimiento.adapters.PersonaAdapter pAdapter = new acseg.reconocimiento.adapters.PersonaAdapter();
        vAdapter.updateRecord(dbCon, "mtrAuto", key, "enCampus", value);
        pAdapter.updateRecord(dbCon, "mtrAutov", key, "enCampus", value);

    }
    
    public static boolean isVehicleOnCampus(String key) throws DbException {
        acseg.reconocimiento.adapters.VehiculoAdapter vAdapter = new acseg.reconocimiento.adapters.VehiculoAdapter();
        boolean onCampus = false;
        if ((vAdapter.findRecord(dbCon, "enCampus", key) != null)) {
            onCampus = true;
        }
        return onCampus;
    }
    
    

    public static void addPersonLog(String CI, String op) throws ParseException {
        acseg.reconocimiento.adapters.LogPersonaAdapter lpAdapter = new acseg.reconocimiento.adapters.LogPersonaAdapter();
        LogPersona logP = new LogPersona(CI, op);
        lpAdapter.insertRecord(dbCon, logP);
    }

    public static void addLog(String mtrAuto, String op) throws ParseException {
        acseg.reconocimiento.adapters.LogAdapter lAdapter = new acseg.reconocimiento.adapters.LogAdapter();
        Log log = new Log(mtrAuto, op);
        lAdapter.insertRecord(dbCon, log);
    }

}

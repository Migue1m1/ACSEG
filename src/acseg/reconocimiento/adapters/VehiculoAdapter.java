
/**
 * Adapter class for handling Personas. 
 * @author <a href="mailto:migue.guev@gmail.com">Miguel Guevara</a>
 *@author <a href="mailto:joandv.gil@gmail.com">Joan Gil</a>
 */

package acseg.reconocimiento.adapters;

import acseg.DbConnection.*;
import acseg.reconocimiento.models.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class VehiculoAdapter implements IDataAdapter<Vehiculo> {

    @Override
    public Vehiculo findRecord(IDbConnection db, String k, Object v) 
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            return acseg.utils.Utils.docToVehiculo(mDb.findOne("vehiculos", k, v));
        }
        else
        {
            System.out.println("Base de datos no iniciada");
            return null;
        }
    }

    @Override
    public List<Vehiculo> findAllRecords(IDbConnection db)
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            List<Vehiculo> vehiculos = null;
            List<Document> docs = mDb.findAll("vehiculo");
            if ((docs != null) && (!docs.isEmpty()))
            {
                vehiculos = new ArrayList<>();
                for (Document d : docs)
                {
                    vehiculos.add(acseg.utils.Utils.docToVehiculo(d));
                }
            }
            return vehiculos;
        }
        else
        {
            System.out.println("Base de datos no iniciada");
            return null;
        }
    }

    @Override
    public void insertRecord(IDbConnection db, Vehiculo vehiculo)
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            if (vehiculo != null)
                mDb.insert("personas", vehiculo);
        }
        else
            System.out.println("Base de datos no iniciada");
    }

    @Override
    public void updateRecord(IDbConnection db, String k1, Object v1,
            String k2, Object v2)
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            if (!k1.isEmpty() && !k2.isEmpty())
                mDb.update("vehiculos", k1, v1, k2, v2);
        }
        else
            System.out.println("Base de datos no iniciada");
    }
    
    @Override
    public void replaceRecord(IDbConnection db, String k, Object v, Object o)
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            if (!k.isEmpty())
                mDb.replace("vehiculos", k, v, o);
        }
        else
            System.out.println("Base de datos no iniciada");
    }

    @Override
    public void deleteRecord(IDbConnection db, String k, Object v)
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            if (!k.isEmpty())
                mDb.delete("vehiculos", k, v);
        }
        else
            System.out.println("Base de datos no iniciada");
    }
    
}

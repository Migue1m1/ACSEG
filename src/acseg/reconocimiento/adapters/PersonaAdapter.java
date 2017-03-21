
/**
 * Adapter class for handling Personas. 
 * @author <a href="mailto:migue.guev@gmail.com">Miguel Guevara</a>
 *@author <a href="mailto:joandv.gil@gmail.com">Joan Gil</a>
 */

package acseg.reconocimiento.adapters;

import acseg.DbConnection.*;
import acseg.reconocimiento.models.Persona;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class PersonaAdapter implements IDataAdapter<Persona> {

    @Override
    public Persona findRecord(IDbConnection db, String k, Object v) 
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            return acseg.utils.Utils.docToPersona(mDb.findOne("personas", k, v));
        }
        else
        {
            System.out.println("Base de datos no iniciada");
            return null;
        }
    }

    @Override
    public List<Persona> findAllRecords(IDbConnection db)
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            List<Persona> personas = null;
            List<Document> docs = mDb.findAll("personas");
            if ((docs != null) && (!docs.isEmpty()))
            {
                personas = new ArrayList<>();
                for (Document d : docs)
                {
                    personas.add(acseg.utils.Utils.docToPersona(d));
                }
            }
            return personas;
        }
        else
        {
            System.out.println("Base de datos no iniciada");
            return null;
        }
    }

    @Override
    public void insertRecord(IDbConnection db, Persona persona)
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            if (persona != null)
                mDb.insert("personas", persona);
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
                mDb.update("personas", k1, v1, k2, v2);
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
                mDb.replace("personas", k, v, o);
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
                mDb.delete("personas", k, v);
        }
        else
            System.out.println("Base de datos no iniciada");
    }
    
}

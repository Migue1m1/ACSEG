/**
 * Adapter class for handling Usuarios. 
 * @author <a href="mailto:migue.guev@gmail.com">Miguel Guevara</a>
 *@author <a href="mailto:joandv.gil@gmail.com">Joan Gil</a>
 */

package acseg.reconocimiento.adapters;

import acseg.DbConnection.*;
import acseg.reconocimiento.models.LogPersona;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class LogPersonaAdapter implements IDataAdapter<LogPersona> {

    @Override
    public LogPersona findRecord(IDbConnection db, String k, Object v) 
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            return acseg.utils.Utils.docToLogPersona(mDb.findOne("logsP", k, v));
        }
        else
        {
            System.out.println("Base de datos no iniciada");
            return null;
        }
    }

    @Override
    public List<LogPersona> findAllRecords(IDbConnection db)
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            List<LogPersona> logPersona = null;
            List<Document> docs = mDb.findAll("logsP");
            if ((docs != null) && (!docs.isEmpty()))
            {
                logPersona = new ArrayList<>();
                for (Document d : docs)
                {
                    logPersona.add(acseg.utils.Utils.docToLogPersona(d));
                }
            }
            return logPersona;
        }
        else
        {
            System.out.println("Base de datos no iniciada");
            return null;
        }
    }

    @Override
    public void insertRecord(IDbConnection db, LogPersona logP)
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            if (logP != null)
                mDb.insert("logsP", logP);
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
                mDb.update("logsP", k1, v1, k2, v2);
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
                mDb.replace("logsP", k, v, o);
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
                mDb.delete("logsP", k, v);
        }
        else
            System.out.println("Base de datos no iniciada");
    }
    
}

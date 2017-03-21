/**
 * Adapter class for handling Usuarios. 
 * @author <a href="mailto:migue.guev@gmail.com">Miguel Guevara</a>
 *@author <a href="mailto:joandv.gil@gmail.com">Joan Gil</a>
 */

package acseg.reconocimiento.adapters;

import acseg.DbConnection.*;
import acseg.reconocimiento.models.Log;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class LogAdapter implements IDataAdapter<Log> {

    @Override
    public Log findRecord(IDbConnection db, String k, Object v) 
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            return acseg.utils.Utils.docToLog(mDb.findOne("logs", k, v));
        }
        else
        {
            System.out.println("Base de datos no iniciada");
            return null;
        }
    }

    @Override
    public List<Log> findAllRecords(IDbConnection db)
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            List<Log> logs = null;
            List<Document> docs = mDb.findAll("logs");
            if ((docs != null) && (!docs.isEmpty()))
            {
                logs = new ArrayList<>();
                for (Document d : docs)
                {
                    logs.add(acseg.utils.Utils.docToLog(d));
                }
            }
            return logs;
        }
        else
        {
            System.out.println("Base de datos no iniciada");
            return null;
        }
    }

    @Override
    public void insertRecord(IDbConnection db, Log log)
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            if (log != null)
                mDb.insert("logs", log);
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
                mDb.update("logs", k1, v1, k2, v2);
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
                mDb.replace("logs", k, v, o);
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
                mDb.delete("logs", k, v);
        }
        else
            System.out.println("Base de datos no iniciada");
    }
    
}

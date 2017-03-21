/**
 * Adapter class for handling Usuarios. 
 * @author <a href="mailto:migue.guev@gmail.com">Miguel Guevara</a>
 *@author <a href="mailto:joandv.gil@gmail.com">Joan Gil</a>
 */

package acseg.reconocimiento.adapters;

import acseg.DbConnection.*;
import acseg.reconocimiento.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class UsuarioAdapter implements IDataAdapter<Usuario> {

    @Override
    public Usuario findRecord(IDbConnection db, String k, Object v) 
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            return acseg.utils.Utils.docToUsuario(mDb.findOne("users", k, v));
        }
        else
        {
            System.out.println("Base de datos no iniciada");
            return null;
        }
    }

    @Override
    public List<Usuario> findAllRecords(IDbConnection db)
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            List<Usuario> usuarios = null;
            List<Document> docs = mDb.findAll("usuarios");
            if ((docs != null) && (!docs.isEmpty()))
            {
                usuarios = new ArrayList<>();
                for (Document d : docs)
                {
                    usuarios.add(acseg.utils.Utils.docToUsuario(d));
                }
            }
            return usuarios;
        }
        else
        {
            System.out.println("Base de datos no iniciada");
            return null;
        }
    }

    @Override
    public void insertRecord(IDbConnection db, Usuario persona)
    {
        if (db != null)
        {
            MongoDbConnection mDb = (MongoDbConnection) db;
            if (persona != null)
                mDb.insert("usuarios", persona);
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
                mDb.update("usuarios", k1, v1, k2, v2);
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
                mDb.replace("usuarios", k, v, o);
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
                mDb.delete("usuarios", k, v);
        }
        else
            System.out.println("Base de datos no iniciada");
    }
    
}

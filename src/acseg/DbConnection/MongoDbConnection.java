/**
 * Mongo DB Connection
 * @author <a href="mailto:migue.guev@gmail.com">Miguel Guevara</a>
 *@author <a href="mailto:joandv.gil@gmail.com">Joan Gil</a>
 */

package acseg.DbConnection;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;

public class MongoDbConnection implements IDbConnection{
    static final String  TEXTURI = "mongodb://joandvgv:Jonixxla5@ds119370.mlab.com:19370/acseg";
    static final MongoClientURI URI = new MongoClientURI(TEXTURI);
    private MongoClient mClient;
    private MongoDatabase dbMongo;
    private String dbName;
    private boolean isOpened;

    
    public MongoDbConnection()
    {
        this.mClient = null;
        this.dbMongo = null;
        this.dbName  = "";
        this.isOpened = false;
    }
    
    public MongoDbConnection(String dbName)
    {
        this.mClient = null;
        this.dbMongo = null;
        this.dbName  = dbName;
        this.isOpened = false;
    }
    
    public void setDbName(String dbName)
    {
        this.dbName = dbName;
    }

    @Override
    public void open() throws DbException
    {
        if (!isOpened)
        {
                 
            mClient = new MongoClient(URI); //Conexión con mLab
            dbMongo = mClient.getDatabase(this.dbName);
            isOpened = true;
            System.out.println("BD conectada con éxito...");
        }
        else
            System.out.println
                   (new DbException("Conexion con BD ya iniciada...")
                           .getMessage());
    }

    @Override
    public void create(String nameColl)
    {
        if (isOpened)
            dbMongo.createCollection(nameColl);
        else
            System.out.println
                   (new DbException("Por favor, primero conectar con la BD...")
                           .getMessage());
    }

    @Override
    public void insert(String nameColl, Object obj)
    {
        if (isOpened)
        {
            MongoCollection collection = dbMongo.getCollection(nameColl);
            if (nameColl.equals("logs") ||nameColl.equals("logsP")){
            }
            collection.insertOne(acseg.utils.Utils.objectToDoc(obj));
        }
        else
            System.out.println
                   (new DbException("Por favor, primero conectar con la BD...")
                           .getMessage());
    }
    
    @Override
    public void update(String nameColl, String k1,
                                    Object v1, String k2, Object v2)
    {
        if (isOpened)
        {
            MongoCollection collection = dbMongo.getCollection(nameColl);
            if (k1.equals("mtrAutov")){
                  collection.updateOne(eq("vehiculo.mtrAuto", v1),
                new Document("$set", new Document("vehiculo.venCampus", v2)));
                
            }
            collection.updateOne(eq(k1, v1),
                new Document("$set", new Document(k2, v2)));
        }
        else
            System.out.println
                   (new DbException("Por favor, primero conectar con la BD...")
                           .getMessage());
    }
    
    @Override
    public void replace(String nameColl, String key, Object value, Object o)
    {
        if (isOpened)
        {
            MongoCollection collection = dbMongo.getCollection(nameColl);
            collection.replaceOne(eq(key, value),
                    acseg.utils.Utils.objectToDoc(o));
        }
        else
            System.out.println
                   (new DbException("Por favor, primero conectar con la BD...")
                           .getMessage());
    }
    
    @Override
    public void delete(String nameColl, String key, Object value)
    {
        if (isOpened)
        {
            MongoCollection collection = dbMongo.getCollection(nameColl);
            collection.deleteOne(eq(key, value));
        }
        else
            System.out.println
                   (new DbException("Por favor, primero conectar con la BD...")
                           .getMessage());
    }
    
   
    
    public Document findOne(String nameColl, String key, Object value)
            
    {
        if (isOpened)
        {
            try
            {
                MongoCursor<Document> cursor = null;
                MongoCollection collection = dbMongo.getCollection(nameColl);
                if (nameColl.equals("users")){
                        cursor=
                                collection.find(and(eq("username", key), eq("password", value))).iterator();
                }else if(key.equals("enCampusc")){
                     cursor=
                                collection.find(and(eq("CI", value), eq("enCampus", true))).iterator();
                }
                else if(key.equals("enCampus")){
                     cursor=
                                collection.find(and(eq("mtrAuto", value), eq("enCampus", true))).iterator();
                }
                else{
                          cursor=
                                collection.find(eq(key, value)).iterator();
                }
            
                if (cursor.hasNext())
                {
                    Document d = Document.parse(cursor.next().toJson());
                    cursor.close();
                    if (d!=null)
                        System.out.println(d);
                    return d;
                }
                cursor.close();
            }
            catch(com.mongodb.MongoException e)
            {
                System.out.println(e.getMessage());
            }
        }
        else
            System.out.println
                   (new DbException("Por favor, primero conectar con la BD...")
                           .getMessage());
        return null;
    }
    
    public List<Document> findAll(String nameColl)
    {
        if (isOpened)
        {
            List<Document> docs = null;
            try
            {
                MongoCollection collection = dbMongo.getCollection(nameColl);

                MongoCursor<Document> cursor = 
                                collection.find().iterator();
            
                if (cursor.hasNext())
                {
                    docs = new ArrayList<>();
                    while(cursor.hasNext())
                    {
                        docs.add(Document.parse(cursor.next().toJson()));
                    }
                    cursor.close();
                }
                else
                {
                    cursor.close();
                    return null;
                }
            }
            catch(com.mongodb.MongoException e)
            {
                System.out.println(e.getMessage());
            }
            return docs;
        }
        else
        {
            System.out.println
                   (new DbException("Por favor, primero conectar con la BD...")
                           .getMessage());
            return null;
        }
    }
       
    

    @Override
    public void close()
    {
        if (isOpened)
        {
            mClient.close();
            isOpened = false;
            System.out.println("Data base is closed...");
        }
        else
            System.out.println
                   (new DbException("Por favor, primero conectar con la BD...")
                           .getMessage());
    }
    
}

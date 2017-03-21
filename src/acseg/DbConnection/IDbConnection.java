
/**
 * Interface for handling all kind of db Connections. 
 * @author <a href="mailto:migue.guev@gmail.com">Miguel Guevara</a>
 *@author <a href="mailto:joandv.gil@gmail.com">Joan Gil</a>
 */
package acseg.DbConnection;

public interface IDbConnection {
    
    public void open() throws DbException;
    
    public void create(String nameColl);
    
    public void insert(String nameColl, Object person);
    
    public void update(String nameColl, String k1,
                                    Object v1, String k2, Object v2);
    
    public void replace(String nameColl, String key, Object value, Object o);
    
    public void delete(String nameColl, String key, Object value);
    
    public void close();
    

}
/**
 * Adapter class for handling any model required by the next iterations. 
 * @author <a href="mailto:migue.guev@gmail.com">Miguel Guevara</a>
 *@author <a href="mailto:joandv.gil@gmail.com">Joan Gil</a>
 */

package acseg.reconocimiento.adapters;

import java.util.List;
import acseg.DbConnection.IDbConnection;

public interface IDataAdapter<T> {
    
    public T findRecord(IDbConnection db, String k, Object v);

    public List<T> findAllRecords(IDbConnection db);
    
    public void insertRecord(IDbConnection db, T record);
    
    public void updateRecord(IDbConnection db, String k1, Object v1,
            String k2, Object v2);
    
    public void replaceRecord(IDbConnection db, String k, Object v, Object o);
    
    public void deleteRecord(IDbConnection db, String k, Object v);
}

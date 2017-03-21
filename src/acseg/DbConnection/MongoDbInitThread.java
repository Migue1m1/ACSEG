
package acseg.DbConnection;

import java.util.logging.Level;
import java.util.logging.Logger;
import acseg.reconocimiento.adapters.PersonaAdapter;
import acseg.reconocimiento.adapters.UsuarioAdapter;

public class MongoDbInitThread extends Thread {
        private static MongoDbConnection db;
        private static PersonaAdapter pAdapter;
        private static UsuarioAdapter uAdapter;
        public MongoDbInitThread (MongoDbConnection db, PersonaAdapter pAdapter, UsuarioAdapter uAdapter)
        {
            MongoDbInitThread.db = db;
            MongoDbInitThread.pAdapter = pAdapter;
            MongoDbInitThread.uAdapter = uAdapter;
        }
        @Override
        public void run() {
            try {
                db.open();
                pAdapter = new PersonaAdapter();
                uAdapter = new UsuarioAdapter();
            } catch (DbException ex) {
                Logger.getLogger(MongoDbInitThread.
                        class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

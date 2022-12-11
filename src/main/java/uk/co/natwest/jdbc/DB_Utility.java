package uk.co.natwest.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.util.Properties;

public class DB_Utility {
    //properties - legacy class - sub class of hash table --> map
        private static final Properties DB_PROPERTIES;
        static {
            DB_PROPERTIES = new Properties();
            try {
                DB_PROPERTIES.load(new FileReader("src/main/resources/mysql_db.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public static String getProperty(String key){
        return DB_PROPERTIES.getProperty(key);
        }
}

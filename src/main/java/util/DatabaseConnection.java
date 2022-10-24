package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
        // normalde final denmez örnek old. için yazıldı. Çünkü uygulama farklı databaselere bağlabnabilir
        private final String URL = "jdbc:postgresql://localhost:5432/calisma";
        private final String USER = "postgres";
        private final String PASSWORD = "Baskent@2005@";

        private Connection connection = null;

        public DatabaseConnection(){
            try {
                connection = DriverManager.getConnection(URL,USER,PASSWORD);
                System.out.println("Connected to database");
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        }

        public Connection getConnection() {
            return connection;
        }
}



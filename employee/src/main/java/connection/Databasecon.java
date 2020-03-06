package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Databasecon {
    public static Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/employeedb";
        String user = "root";
        String password = "Roja@123";
        Connection myConn = null;
        try {
            myConn = DriverManager.getConnection(url, user, password);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return myConn;
    }
}

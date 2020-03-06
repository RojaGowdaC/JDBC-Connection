package operations;
import connection.Databasecon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class delete implements Operation {
    @Override
    public void performOperation() throws SQLException {
        Connection myConn = Databasecon.createConnection();
        Statement myStmt = myConn.createStatement();
        String sql;
        PreparedStatement statement;
        sql = "DELETE FROM employeedb.employee WHERE id=?";
        statement = myConn.prepareStatement(sql);
        System.out.println("Enter the Employee id to delete");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        statement.setString(1, Integer.toString(id));
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
    }
}

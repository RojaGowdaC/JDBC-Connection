package operations;

import connection.Databasecon;

import java.sql.*;

public class select implements Operation {
    @Override
    public void performOperation() throws SQLException {
        Connection myConn = Databasecon.createConnection();
        Statement myStmt = myConn.createStatement();
        String sql;
        PreparedStatement statement;
        sql = "select * from employeedb.employee";
        ResultSet rs = myStmt.executeQuery(sql);

        while (rs.next()){
            String id = rs.getString("id");
            String name = rs.getString("name");
            String city = rs.getString("city");
            String age = rs.getString("age");
            String deptName = rs.getString("deptName");
            System.out.println("Record " + id + " is " + name + " " + city + " " + age + " " + deptName);
        }
    }
}

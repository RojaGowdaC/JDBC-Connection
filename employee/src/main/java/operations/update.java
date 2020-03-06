package operations;

import connection.Databasecon;
import model.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class update implements Operation {
    private int id;
    private String name;
    private String city;
    private int age;
    private String deptName;
    private void takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter  Employee id : ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Employee Name : ");
        name = sc.nextLine();
        System.out.println("Enter the City : ");
        city = sc.nextLine();
        System.out.println("Enter the Age : ");
        age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the DeptName: ");
        deptName = sc.nextLine();
    }
    @Override
    public void performOperation() throws SQLException {
        Connection myConn = Databasecon.createConnection();
        Statement myStmt = myConn.createStatement();
        String sql;
        PreparedStatement statement;
        sql = "UPDATE employeedb.employee SET name=?, city=?, age=?, deptName=? WHERE id=?";
        System.out.println("Enter the ID to update");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println("Enter the new values\n");
        takeInput();
        emp employee = new emp(id, name, city, age, deptName);
        statement = myConn.prepareStatement(sql);
        statement.setString(1, employee.name);
        statement.setString(2, employee.city);
        statement.setString(3, Integer.toString(employee.age));
        statement.setString(4, employee.deptName);
        statement.setString(5, Integer.toString(employee.id));

       int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
    }
}

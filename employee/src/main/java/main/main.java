package main;

import operations.delete;
import operations.insert;
import operations.select;
import operations.update;

import java.sql.SQLException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws SQLException {
        int choice;
        while(true) {
            System.out.println(" 1.Insert\n 2.Select\n 3.Update\n 4.Delete\n 5.Stop\n");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insert i = new insert();
                    i.performOperation();
                    break;
                case 2:
                    select s = new select();
                    s.performOperation();
                    break;
                case 3:
                    update u = new update();
                    u.performOperation();
                    break;
                case 4:
                    delete d = new delete();
                    d.performOperation();
                    break;
                case 5:
                    return;

            }

        }

    }
}

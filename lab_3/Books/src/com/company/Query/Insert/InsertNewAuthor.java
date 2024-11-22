package com.company.Query.Insert;

import com.company.Connection.JDBC;
import java.sql.*;
import java.util.Scanner;

public class InsertNewAuthor {

    public static void main(String[] args) {
        PreparedStatement pstmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            JDBC.connect();

            String insertQuery = "INSERT INTO Authors (firstName, lastName) VALUES (?, ?)";

            pstmt = JDBC.connection.prepareStatement(insertQuery);

            System.out.print("Введите имя автора: ");
            String firstName = scanner.nextLine();

            System.out.print("Введите фамилию автора: ");
            String lastName = scanner.nextLine();

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Новый автор успешно добавлен в базу данных!");
            } else {
                System.out.println("Ошибка при добавлении автора.");
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                JDBC.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

package com.company.Query.Insert;

import com.company.Connection.JDBC;
import java.sql.*;
import java.util.Scanner;

public class InsertAuthorISBN {

    public static void main(String[] args) {
        PreparedStatement pstmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            JDBC.connect();

            System.out.print("Введите ISBN книги: ");
            String isbn = scanner.nextLine();

            System.out.print("Введите имя автора: ");
            String authorFirstName = scanner.nextLine();

            System.out.print("Введите фамилию автора: ");
            String authorLastName = scanner.nextLine();

            String insertQuery = "INSERT INTO authorISBN (isbn, authorID) " +
                    "VALUES (?, (SELECT authorID FROM Authors WHERE firstName = ? AND lastName = ?))";

            pstmt = JDBC.connection.prepareStatement(insertQuery);

            pstmt.setString(1, isbn);
            pstmt.setString(2, authorFirstName);
            pstmt.setString(3, authorLastName);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Запись authorISBN успешно добавлена в базу данных!");
            } else {
                System.out.println("Ошибка при добавлении записи authorISBN. Проверьте корректность данных автора.");
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

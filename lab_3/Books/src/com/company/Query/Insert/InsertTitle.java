package com.company.Query.Insert;

import com.company.Connection.JDBC;
import java.sql.*;
import java.util.Scanner;

public class InsertTitle {

    public static void main(String[] args) {
        PreparedStatement pstmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            JDBC.connect();

            System.out.print("Введите ISBN книги: ");
            String isbn = scanner.nextLine();

            System.out.print("Введите название книги: ");
            String title = scanner.nextLine();

            System.out.print("Введите номер издания: ");
            int editionNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Введите год издания книги: ");
            String copyright = scanner.nextLine();

            System.out.print("Введите имя издателя: ");
            String publisherName = scanner.nextLine();

            String insertQuery = "INSERT INTO Titles (isbn, title, editionNumber, copyright, publisherID) " +
                    "VALUES (?, ?, ?, ?, " +
                    "(SELECT publisherID FROM Publishers WHERE publisherName = ?))";

            pstmt = JDBC.connection.prepareStatement(insertQuery);

            pstmt.setString(1, isbn);
            pstmt.setString(2, title);
            pstmt.setInt(3, editionNumber);
            pstmt.setString(4, copyright);
            pstmt.setString(5, publisherName);

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Новая книга успешно добавлена в базу данных!");
            } else {
                System.out.println("Ошибка при добавлении книги. Проверьте корректность данных издателя.");
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

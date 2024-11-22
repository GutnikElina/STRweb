package com.company.Query.Insert;

import com.company.Connection.JDBC;
import java.sql.*;
import java.util.Scanner;

public class InsertNewPublisher {

    public static void main(String[] args) {
        PreparedStatement pstmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            JDBC.connect();

            String insertQuery = "INSERT INTO Publishers (publisherName) VALUES (?)";
            pstmt = JDBC.connection.prepareStatement(insertQuery);

            System.out.print("Введите название издательства: ");
            String publisherName = scanner.nextLine();
            pstmt.setString(1, publisherName);
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Новый издатель успешно добавлен!");
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


package com.company.Query.Update;

import com.company.Connection.JDBC;
import java.sql.*;
import java.util.Scanner;

public class UpdatePublisher {

    public static void main(String[] args) {
        Statement stmt = null;
        PreparedStatement pstmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            JDBC.connect();

            stmt = JDBC.connection.createStatement();
            String selectQuery = "SELECT * FROM Publishers";
            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("Publishers:");
            while (rs.next()) {
                int publisherID = rs.getInt("publisherID");
                String publisherName = rs.getString("publisherName");
                System.out.println(publisherID + ": " + publisherName);
            }

            System.out.print("\nВведите ID издателя, которого хотите изменить: ");
            int publisherIDToUpdate = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Введите новое имя для издателя: ");
            String newPublisherName = scanner.nextLine();

            String updateQuery = "UPDATE Publishers SET publisherName = ? WHERE publisherID = ?";
            pstmt = JDBC.connection.prepareStatement(updateQuery);

            pstmt.setString(1, newPublisherName);
            pstmt.setInt(2, publisherIDToUpdate);

            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Имя издателя успешно обновлено!");
            } else {
                System.out.println("Издатель с таким ID не найден.");
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (pstmt != null) pstmt.close();
                JDBC.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

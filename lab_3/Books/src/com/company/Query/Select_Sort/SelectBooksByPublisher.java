package com.company.Query.Select_Sort;

import com.company.Connection.JDBC;
import java.sql.*;
import java.util.Scanner;

import static com.company.TestOfTables.GetAllRows.printPublishers;

public class SelectBooksByPublisher {

    public static void main(String[] args) {
        Statement stmt = null;
        Scanner scanner = new Scanner(System.in);

        try {
            JDBC.connect();

            printPublishers();

            System.out.print("\nВведите ID издателя для поиска его книг: ");
            int publisherID = scanner.nextInt();
            scanner.nextLine();

            String query = "SELECT Titles.isbn, Titles.title, Titles.editionNumber, Titles.year " +
                    "FROM Titles " +
                    "WHERE Titles.publisherID = ? " +
                    "ORDER BY Titles.title ASC";

            PreparedStatement pstmt = JDBC.connection.prepareStatement(query);
            pstmt.setInt(1, publisherID);

            ResultSet rs = pstmt.executeQuery();

            System.out.println("Книги издателя с ID " + publisherID + ":");

            while (rs.next()) {
                String isbn = rs.getString("isbn");
                String title = rs.getString("title");
                int editionNumber = rs.getInt("editionNumber");
                String year = rs.getString("year");

                System.out.println(isbn + "\t" + title + "\t" + editionNumber + "\t" + year);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                JDBC.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}


package com.company.TestOfTables;

import com.company.Connection.JDBC;
import java.sql.*;

public class GetAllRows {

    public static void main(String[] args) {
        try {
            JDBC.connect();

            printAuthors();
            printTitles();
            printPublishers();
            printAuthorISBN();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
    }

    public static void printAuthors() throws SQLException {
        Statement stmt = JDBC.connection.createStatement();
        String query = "SELECT * FROM Authors";
        System.out.println("\nAuthors:");
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("authorID");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            System.out.println(id + "\t" + firstName + "\t" + lastName);
        }
    }

    public static void printTitles() throws SQLException {
        Statement stmt = JDBC.connection.createStatement();
        String query = "SELECT * FROM Titles";
        System.out.println("\nTitles:");
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String isbn = rs.getString("isbn");
            String title = rs.getString("title");
            int editionNumber = rs.getInt("editionNumber");
            String year = rs.getString("year");
            int publisherID = rs.getInt("publisherID");
            double price = rs.getDouble("price");
            System.out.println(isbn + "\t" + title + "\t" + editionNumber + "\t" + year + "\t" + publisherID + "\t" + price);
        }
    }

    public static void printPublishers() throws SQLException {
        Statement stmt = JDBC.connection.createStatement();
        String query = "SELECT * FROM Publishers";
        System.out.println("\nPublishers:");
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int publisherID = rs.getInt("publisherID");
            String publisherName = rs.getString("publisherName");
            System.out.println(publisherID + "\t" + publisherName);
        }
    }

    public static void printAuthorISBN() throws SQLException {
        Statement stmt = JDBC.connection.createStatement();
        String query = "SELECT * FROM AuthorISBN";
        System.out.println("\nAuthorISBN:");
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int authorID = rs.getInt("authorID");
            String isbn = rs.getString("isbn");
            System.out.println(authorID + "\t" + isbn);
        }
    }
}
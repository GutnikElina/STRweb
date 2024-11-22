package com.company.Query.Select_Sort;

import com.company.Connection.JDBC;
import java.sql.*;

public class SelectAndSortAuthors {

    public static void main(String[] args) {
        Statement stmt = null;
        try {
            JDBC.connect();

            stmt = JDBC.connection.createStatement();

            String query = "SELECT * FROM Authors ORDER BY firstName";
            System.out.println("\nAuthors (sorted by firstName):");
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("authorID");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }

            String query2 = "SELECT * FROM Authors ORDER BY lastName";
            System.out.println("\nAuthors (sorted by lastName):");
            ResultSet rs2 = stmt.executeQuery(query2);
            while (rs2.next()) {
                int id = rs2.getInt("authorID");
                String firstName = rs2.getString("firstName");
                String lastName = rs2.getString("lastName");
                System.out.println(id + "\t" + firstName + "\t" + lastName);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
    }
}

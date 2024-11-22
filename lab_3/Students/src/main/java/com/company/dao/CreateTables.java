package com.company.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateTables {
    public static void createStudentTable() {
        String studentTableSQL = "CREATE TABLE IF NOT EXISTS student (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                "firstName VARCHAR(100), " +
                "lastName VARCHAR(100), " +
                "address TEXT, " +
                "mobile_no VARCHAR(20), " +
                "email_id VARCHAR(100), " +
                "city VARCHAR(100), " +
                "designation VARCHAR(100), " +
                "dob DATE, " +
                "doj DATE, " +
                "salary DECIMAL(15, 2), " +
                "add_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        try (Connection connection = ConnectionFactory.getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.execute(studentTableSQL);
            System.out.println("Table 'student' created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating 'student' table: " + e.getMessage());
        }
    }

    public static void createGroupTable() {
        String groupTableSQL = "CREATE TABLE IF NOT EXISTS `groups` (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "`number` BIGINT, " +  // Если 'number' тоже зарезервированное слово, оборачиваем его в обратные кавычки
                "fakultet VARCHAR(100), " +
                "amountOfStudents INT" +
                ");";

        try (Connection connection = ConnectionFactory.getConnectionForGroup();
             Statement stmt = connection.createStatement()) {
            stmt.execute(groupTableSQL);
            System.out.println("Table 'groups' created successfully.");
        } catch (SQLException e) {
            System.out.println("Error creating 'groups' table: " + e.getMessage());
        }
    }

    public static void createTables() {
        createStudentTable();
        createGroupTable();
    }

    public static void main(String[] args) {
        createTables();
    }
}

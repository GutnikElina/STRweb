package com.company.dao;

import com.company.model.Group;
import com.company.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDao {
    int st;

    public int insert(Group group) {
        String sql = "INSERT INTO `groups` (number, fakultet, amountOfStudents) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionFactory.getConnectionForGroup();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, group.getNumber());
            stmt.setString(2, group.getFakultet());
            stmt.setInt(3, group.getAmountOfStudents());
            st = stmt.executeUpdate();
            System.out.println("\nInserted group: " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        }
        return st;
    }

    public int update(Group group) {
        String sql = "UPDATE `groups` SET number=?, fakultet=?, amountOfStudents=? WHERE id=?";
        try (Connection connection = ConnectionFactory.getConnectionForGroup();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, group.getNumber());
            stmt.setString(2, group.getFakultet());
            stmt.setInt(3, group.getAmountOfStudents());
            stmt.setInt(4, group.getId());
            st = stmt.executeUpdate();
            System.out.println("\nUpdated group: " + st);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public List<Group> getAllGroups() {
        List<Group> groups = new ArrayList<Group>();
        String sql = "SELECT * FROM `groups`";
        try (Connection connection = ConnectionFactory.getConnectionForGroup();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                long number = rs.getLong("number");
                String fakultet = rs.getString("fakultet");
                int amountOfStudents = rs.getInt("amountOfStudents");
                groups.add(new Group(id, number, fakultet, amountOfStudents));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groups;
    }
}

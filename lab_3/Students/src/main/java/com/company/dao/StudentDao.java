package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.company.model.Student;
import java.math.BigDecimal;
import java.sql.Date;

public class StudentDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;

    public int insert(Student student) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "insert into student(firstName,lastName,address,mobile_no,email_id,city,designation,dob,doj,salary) "
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getAddress());
            ps.setString(4, student.getMobileNo());
            ps.setString(5, student.getMailId());
            ps.setString(6, student.getCity());
            ps.setString(7, student.getDesignation());
            ps.setDate(8, student.getDob());
            ps.setDate(9, student.getDoj());
            ps.setBigDecimal(10, student.getSalary());
            st = ps.executeUpdate();
            System.out.println("\nInserted student: " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public int update(Student student) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "update student set firstName=?,lastName=?,address=?,mobile_no=?,email_id=?,city=?, "
                    + "designation=?,dob=?,doj=?,salary=? "
                    + "where id=? ";
            ps = con.prepareStatement(query);
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getAddress());
            ps.setString(4, student.getMobileNo());
            ps.setString(5, student.getMailId());
            ps.setString(6, student.getCity());
            ps.setString(7, student.getDesignation());
            ps.setDate(8, student.getDob());
            ps.setDate(9, student.getDoj());
            ps.setBigDecimal(10, student.getSalary());
            ps.setLong(11, student.getId());
            st = ps.executeUpdate();
            System.out.println("\nUpdated student: " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public int delete(long id) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "delete from student where id=? ";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            st = ps.executeUpdate();
            System.out.println("\nDeleted student: " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public Student fetchById(long id) {
        Student student = new Student();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where id=?";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                student.setId(rs.getLong("id"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return student;
    }

    public Student fetchByEmailId(String emailId) {
        Student student = new Student();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where email_id=?";
            ps = con.prepareStatement(query);
            ps.setString(1, emailId);
            rs = ps.executeQuery();
            while (rs.next()) {
                student.setId(rs.getLong("id"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return student;
    }

    public Student fetchByMobileNo(String mobileNo) {
        Student student = new Student();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where mobile_no=?";
            ps = con.prepareStatement(query);
            ps.setString(1, mobileNo);
            rs = ps.executeQuery();
            while (rs.next()) {
                student.setId(rs.getLong("id"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return student;
    }

    public List<Student> searchByName(String name) {
        List<Student> studentList = new ArrayList<Student>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "SELECT * FROM student WHERE firstName LIKE ? OR lastName LIKE ?";
            ps = con.prepareStatement(query);

            String searchPattern = "%" + name + "%";
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);

            rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student(); student.setId(rs.getLong("id"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));

                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
      return studentList;
    }

    public List<Student> fetchByCity(String city) {
        List<Student> studentList = new ArrayList<Student>();

        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where city=?";
            ps = con.prepareStatement(query);
            ps.setString(1, city);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    public List<Student> fetchBySalaryRange(BigDecimal lowerSalary, BigDecimal higherSalary) {
        List<Student> studentList = new ArrayList<Student>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "SELECT * FROM student WHERE salary BETWEEN ? AND ?";
            ps = con.prepareStatement(query);

            ps.setBigDecimal(1, lowerSalary);
            ps.setBigDecimal(2, higherSalary);

            rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    public List<Student> fetchByDob(Date dob) {
        List<Student> studentList = new ArrayList<Student>();

        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where dob=?";
            ps = con.prepareStatement(query);
            ps.setDate(1, dob);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    public List<Student> fetchByRangeDoj(Date startDate, Date endDate) {
        List<Student> studentList = new ArrayList<Student>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "SELECT * FROM student WHERE doj BETWEEN ? AND ?";
            ps = con.prepareStatement(query);

            ps.setDate(1, startDate);
            ps.setDate(2, endDate);

            rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    public List<Student> fetchAll() throws SQLException {
        List<Student> studentList = new ArrayList<Student>();

        con = ConnectionFactory.getConnection();
        if (con == null) {
            throw new SQLException("Failed to establish connection.");
        }
        try {
            String query = "select * from student ORDER BY id DESC";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }
}

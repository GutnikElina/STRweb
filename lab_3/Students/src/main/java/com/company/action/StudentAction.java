package com.company.action;

import com.company.dao.StudentDao;
import com.company.model.Student;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;


public class StudentAction {

    StudentDao dao = new StudentDao();
    int st;

    public void insert(Student student) {
        st = dao.insert(student);
        if (st == 1) {
            System.out.println("\nStudent inserted successfully!");
        } else if (st == -1) {
            System.out.println("\n-!!!- Student already exists -!!!-");
        } else {
            System.out.println("\n-!!!- Unable to insert student -!!!-");
        }
    }

    public void update(Student student) {
        st = dao.update(student);
        if (st == 1) {
            System.out.println("\nStudent updated successfully");
        } else {
            System.out.println("\n-!!!- Unable to update student -!!!-");
        }
    }

    public void delete(Long id) {
        st = dao.delete(id);
        if (st == 1) {
            System.out.println("\nStudent Deleted Successfully!");
        } else {
            System.out.println("\n-!!!- No Record Found -!!!-");
        }
    }

    public void fetchById(Long id) {
        Student student = dao.fetchById(id);
        if (student.getId() == 0) {
            System.out.println("\n-!!!- No Record Found -!!!-");
        } else {
            System.out.println("\nStudent details are :");
            System.out.println(student);
        }
    }

    public void fetchByEmailId(String emailId) {
        Student student = dao.fetchByEmailId(emailId);
        if (student.getId() == 0) {
            System.out.println("\n-!!!- No Record Found -!!!-");
        } else {
            System.out.println("\nStudent details are :");
            System.out.println(student);
        }
    }

    public void fetchByMobileNo(String mobileNo) {
        Student student = dao.fetchByMobileNo(mobileNo);
        if (student.getId() == 0) {
            System.out.println("\n-!!!- No Record Found -!!!-");
        } else {
            System.out.println("\nStudent Details are :");
            System.out.println(student);
        }
    }

    public void searchByName(String name) {
        List<Student> studentList = dao.searchByName(name);
        if (studentList.isEmpty()) {
            System.out.println("\n-!!!- No Record Found -!!!-");
        } else {
            System.out.println("\nStudent Details are :");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }

    }

    public void fetchByCity(String city) {
        List<Student> studentList = dao.fetchByCity(city);
        if (studentList.isEmpty()) {
            System.out.println("\n-!!!- No Record Found -!!!-");
        } else {
            System.out.println("\nStudent Details are :");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public void fetchBySalaryRange(BigDecimal lowerSalary, BigDecimal higherSalary) {
        List<Student> studentList = dao.fetchBySalaryRange(lowerSalary, higherSalary);
        if (studentList.isEmpty()) {
            System.out.println("\n-!!!- No Record Found -!!!-");
        } else {
            System.out.println("\nStudent Details are :");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public void fetchByDob(Date dob) {
        List<Student> studentList = dao.fetchByDob(dob);
        if (studentList.isEmpty()) {
            System.out.println("\n-!!!- No Record Found -!!!-");
        } else {
            System.out.println("\nStudent Details are :");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public void fetchByRangeDoj(Date startDate, Date endDate) {
        List<Student> studentList = dao.fetchByRangeDoj(startDate, endDate);
        if (studentList.isEmpty()) {
            System.out.println("\n-!!!- No Record Found -!!!-");
        } else {
            System.out.println("\nStudent Details are :");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public void fetchAll() throws SQLException {
        List<Student> studentList = dao.fetchAll();
        if (studentList.isEmpty()) {
            System.out.println("\n-!!!- No Record Found -!!!-");
        } else {
            System.out.println("\n-----STUDENTS------");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

}

package com.company.start;

import com.company.action.GroupAction;
import com.company.action.StudentAction;
import com.company.model.Group;
import com.company.model.Student;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;


public class MainClass {

    StudentAction actionStudent = new StudentAction();
    GroupAction actionGroup = new GroupAction();
    static MainClass mainclass = new MainClass();

    public static void main(String[] args) throws SQLException {
        String DbOperation = "0) EXIT \n1) WORK WITH STUDENTS \n2) WORK WITH GROUPS";

        int value = 0;
        do {
            System.out.println("\n+----------MENU----------+");
            System.out.println(DbOperation);
            System.out.println("+------------------------+");
            System.out.println("Enter valid operation number:");
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();

            switch (value) {
                case 1:
                    mainclass.studentMenu();
                    break;
                case 2:
                    mainclass.groupMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\n-!!!- Not a valid entry -!!!-");
            }
        } while (value != 0);
    }

    public void groupMenu() {
        String DbOperation = "0) EXIT \n1) ADD GROUP \n2) UPDATE GROUP\n3) GET ALL GROUPS";

        int value = 0;
        do {
            System.out.println("\n+----------MENU----------+");
            System.out.println(DbOperation);
            System.out.println("+------------------------+");
            System.out.println("Enter valid operation number:");
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();

            switch (value) {
                case 1:
                    mainclass.addGroup();
                    break;
                case 2:
                    mainclass.updateGroup();
                    break;
                case 3:
                    mainclass.fetchAllGroups();
                case 0:
                    break;
                default:
                    System.out.println("\n-!!!- Not a valid entry -!!!-");
            }
        } while (value != 0);
    }

    public void studentMenu() throws SQLException {
        String DbOperation = "0) EXIT \n1) ADD \n2) UPDATE \n3) DELETE \n4) FETCHBYID \n5) FETCHBYEMAIL \n6) FETCHBYMOBNO \n7) FETCHBYNAME"
                + "\n8) FETCHBYCITY \n9) FETCHBYSALRANGE \n10) FETCHBYDOB \n11) FETCHBYDOJRANGE \n12) FETCHALL";

        int value = 0;
        do {
            System.out.println("\n+----------MENU----------+");
            System.out.println(DbOperation);
            System.out.println("+------------------------+");
            System.out.println("Enter valid operation number 0-12:");
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();

            switch (value) {
                case 1:
                    mainclass.addStudent();
                    break;
                case 2:
                    mainclass.updateStudent();
                    mainclass.fetchAllStudent();
                    break;
                case 3:
                    mainclass.deleteStudent();
                    break;
                case 4:
                    mainclass.fetchStudentById();
                    break;
                case 5:
                    mainclass.fetchStudentByEmail();
                    break;
                case 6:
                    mainclass.fetchStudentByMobileNo();
                    break;
                case 7:
                    mainclass.searchStudentByName();
                    break;
                case 8:
                    mainclass.fetchStudentByCity();
                    break;
                case 9:
                    mainclass.fetchStudentBySalaryRange();
                    break;
                case 10:
                    mainclass.fetchStudentByDob();
                    break;
                case 11:
                    mainclass.fetchStudentByDOjRange();
                    break;
                case 12:
                    mainclass.fetchAllStudent();
                    break;
                case 0:
                    System.out.println("\n----Exiting code----");
                    break;
                default:
                    System.out.println("\n-!!!- Not a valid entry -!!!-");
            }
        } while (value != 0);
    }

    public void addGroup() {
        Group group = new Group();
        Scanner insert = new Scanner(System.in);
        System.out.println("\nEnter number:");
        group.setNumber(insert.nextInt());
        System.out.println("\nEnter facultet:");
        group.setFakultet(insert.next());
        System.out.println("\nEnter amount of students in group: ");
        group.setAmountOfStudents(insert.nextInt());

        actionGroup.insert(group);
    }

    public void updateGroup() {
        Group group = new Group();
        Scanner insert = new Scanner(System.in);
        System.out.println("\nEnter Group Id");
        group.setId(insert.nextInt());
        System.out.println("\nEnter number:");
        group.setNumber(insert.nextInt());
        System.out.println("\nEnter facultet:");
        group.setFakultet(insert.next());
        System.out.println("\nEnter amount of students in group: ");
        group.setAmountOfStudents(insert.nextInt());

        actionGroup.update(group);
    }

    public void fetchAllGroups() {
        actionGroup.fetchAll();
    }

    public void addStudent() {
        Student student = new Student();
        Scanner insert = new Scanner(System.in);
        System.out.println("\nEnter First Name");
        student.setFirstName(insert.next());
        System.out.println("\nEnter Last Name");
        student.setLastName(insert.next());
        System.out.println("\nEnter Address");
        student.setAddress(insert.next());
        System.out.println("\nEnter Mobile Number");
        student.setMobileNo(insert.next());
        System.out.println("\nEnter Mail Id");
        student.setMailId(insert.next());
        System.out.println("\nEnter City");
        student.setCity(insert.next());
        System.out.println("\nEnter Designation");
        student.setDesignation(insert.next());
        System.out.println("\nEnter Dob (yyyy-mm-dd)");
        student.setDob(Date.valueOf(insert.next()));
        System.out.println("\nEnter Doj  (yyyy-mm-dd)");
        student.setDoj(Date.valueOf(insert.next()));
        System.out.println("\nEnter Salary");
        student.setSalary(insert.nextBigDecimal());
        actionStudent.insert(student);
    }

    public void updateStudent() {
        Student student = new Student();
        Scanner insert = new Scanner(System.in);
        System.out.println("\nEnter Student Id");
        student.setId(insert.nextLong());
        System.out.println("\nEnter First Name");
        student.setFirstName(insert.next());
        System.out.println("\nEnter Last Name");
        student.setLastName(insert.next());
        System.out.println("\nEnter Address");
        student.setAddress(insert.next());
        System.out.println("\nEnter Mobile Number");
        student.setMobileNo(insert.next());
        System.out.println("\nEnter Mail Id");
        student.setMailId(insert.next());
        System.out.println("\nEnter City");
        student.setCity(insert.next());
        System.out.println("\nEnter Designation");
        student.setDesignation(insert.next());
        System.out.println("\nEnter Dob (yyyy-mm-dd)");
        student.setDob(Date.valueOf(insert.next()));
        System.out.println("\nEnter Doj  (yyyy-mm-dd)");
        student.setDoj(Date.valueOf(insert.next()));
        System.out.println("\nEnter Salary");
        student.setSalary(insert.nextBigDecimal());
        actionStudent.update(student);
    }

    public void deleteStudent() {
        Scanner insert = new Scanner(System.in);
        System.out.println("\nEnter Student Id");
        long id = insert.nextLong();
        actionStudent.delete(id);
    }

    public void fetchStudentById() {
        Scanner insert = new Scanner(System.in);
        System.out.println("\nEnter Student Id");
        long id = insert.nextLong();
        actionStudent.fetchById(id);
    }

    public void fetchStudentByEmail() {
        Scanner insert = new Scanner(System.in);
        System.out.println("\nEnter Student Mail Id");
        String mailId = insert.next();
        actionStudent.fetchByEmailId(mailId);
    }

    public void fetchStudentByMobileNo() {
        Scanner insert = new Scanner(System.in);
        System.out.println("\nEnter Student Mobile Number");
        String mobileNo = insert.next();
        actionStudent.fetchByMobileNo(mobileNo);
    }

    public void searchStudentByName() {
        Scanner insert = new Scanner(System.in);
        System.out.println("\nEnter Student Name");
        String name = insert.next();
        actionStudent.searchByName(name);
    }

    public void fetchStudentByCity() {
        Scanner insert = new Scanner(System.in);
        System.out.println("\nEnter Student City");
        String city = insert.next();
        actionStudent.fetchByCity(city);
    }

    public void fetchStudentBySalaryRange() {
        Scanner insert = new Scanner(System.in);
        System.out.println("\nEnter Salary Start Range");
        BigDecimal salaryRange1 = insert.nextBigDecimal();
        System.out.println("\nEnter Salary End Range");
        BigDecimal salaryRange2 = insert.nextBigDecimal();

        actionStudent.fetchBySalaryRange(salaryRange1, salaryRange2);
    }

    public void fetchStudentByDob() {
        Scanner insert = new Scanner(System.in);
        System.out.println("\nEnter Date of Birth (yyyy-mm-dd)");
        String dob = insert.next();
        actionStudent.fetchByDob(Date.valueOf(dob));
    }

    public void fetchStudentByDOjRange() {
        Scanner insert = new Scanner(System.in);
        System.out.println("\nEnter Start Date of Joining (yyyy-mm-dd)");
        String dob1 = insert.next();
        System.out.println("\nEnter End Date of Joining (yyyy-mm-dd)");
        String dob2 = insert.next();
        actionStudent.fetchByRangeDoj(Date.valueOf(dob1), Date.valueOf(dob2));
    }

    public void fetchAllStudent() throws SQLException {
        actionStudent.fetchAll();
    }
}
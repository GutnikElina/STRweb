package jaxb.test;

import jaxb.model.Department;
import jaxb.model.Employee;
import jaxb.model.Organization;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class TestExample {
    private static final String XML_FILE = "organization-info.xml";
    public static void main(String[] args) {
        Employee emp1 = new Employee("E01", "Tom", null);
        Employee emp2 = new Employee("E02", "Mary", "E01");
        Employee emp3 = new Employee("E03", "John", null);

        List<Employee> empList1 = new ArrayList<>();
        empList1.add(emp1);
        empList1.add(emp2);
        empList1.add(emp3);

        Employee emp4 = new Employee("E04", "Elina", null);
        Employee emp5 = new Employee("E05", "Anastasia", "E04");

        List<Employee> empList2 = new ArrayList<>();
        empList2.add(emp4);
        empList2.add(emp5);

        Employee emp7 = new Employee("E07", "Polina", null);
        Employee emp8 = new Employee("E08", "Nadya", "E09");
        Employee emp9 = new Employee("E09", "Karolina", null);

        List<Employee> empList3 = new ArrayList<>();
        empList3.add(emp7);
        empList3.add(emp8);
        empList3.add(emp9);

        Department dept1 = new Department("D01", "ACCOUNTING", "NEW YORK");
        dept1.setEmployees(empList1);
        Department dept2 = new Department("D02", "SALES", "CHICAGO");
        dept2.setEmployees(empList2);
        Department dept3 = new Department("D03", "IT", "SAN FRANCISCO");
        dept3.setEmployees(empList3);

        List<Department> deptList = new ArrayList<>();
        deptList.add(dept1);
        deptList.add(dept2);
        deptList.add(dept3);

        Organization org = new Organization(deptList);

        try {
            // Create JAXB context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(Organization.class);
            // (1) Marshaller : Java Object to XML content.
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(org, System.out);

            // Write to File
            File outFile = new File(XML_FILE);
            m.marshal(org, outFile);

            System.err.println("Write to file: " + outFile.getAbsolutePath());

            // (2) Unmarshaller : Read XML content to Java Object.
            Unmarshaller um = context.createUnmarshaller();

            Organization orgFromFile = (Organization) um.unmarshal(new FileReader(XML_FILE));
            List<Department> departments = orgFromFile.getDepartments();
            for (Department dept : departments) {
                System.out.println("----- Department: " + dept.getDeptName());
                for (Employee emp : dept.getEmployees()) {
                    System.out.println("Employee: " + emp.getEmpName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
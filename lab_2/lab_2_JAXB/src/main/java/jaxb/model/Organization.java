package jaxb.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "organization") //указывает на корневой узел структуры
@XmlAccessorType(XmlAccessType.FIELD)  //используется для указания метода доступа к атрибутам объектов Java при создании файлов XML из объектов Java
//XmlAccessType.FIELD - все переменные-члены в объекте java
public class Organization {
    @XmlElementWrapper(name = "departments")  //указывает на оболочку, которая будет оборачивать данное содержимое
    @XmlElement(name = "department")
    private List<Department> departments;
    public Organization() {
    }
    public Organization(List<Department> departments) {
        this.departments = departments;
    }
    public List<Department> getDepartments() { return departments;}
    public void setDepartments(List<Department> departments) { this.departments = departments; }
}

package lesson_5_dz_test;

import org.junit.Assert;
import ru.innopolis.lesson_5_dz.Employee;
import ru.innopolis.lesson_5_dz.EmployeeFile;

import java.util.List;

public class EmployeeFileTest {

    EmployeeFile employeeFile = new EmployeeFile();

    @org.junit.Test
    public void save() {
        System.out.println("Test save");
        Employee employee = new Employee("Tom",32,32000,"Architect");
        Assert.assertTrue(employeeFile.save(employee));
        Employee employee1 = new Employee("Tom1",32,32000,"Architect");
        Assert.assertTrue(employeeFile.save(employee1));
    }

    @org.junit.Test
    public void delete() {
        System.out.println("Test delete");
        Employee employee1 = new Employee("Tom1",32,32000,"Architect");
        Assert.assertTrue(employeeFile.delete(employee1));
    }

    @org.junit.Test
    public void getByName() {
        Employee employee = new Employee("Tom",32,32000,"Architect");
        Assert.assertEquals(employee, employeeFile.getByName("Tom"));
    }

    @org.junit.Test
    public void getByJob() {
        List<Employee> employeeFile1 = employeeFile.getByJob("Architect");
        for (Employee employee : employeeFile1){
            Assert.assertEquals("Architect",employee.getJob());
        }
    }

    @org.junit.Test
    public void saveOrUpdate() {
    }

    @org.junit.Test
    public void changeAllWork() {
        employeeFile.changeAllWork("Architect","Student");
        List<Employee> employeeFile1 = employeeFile.getByJob("Student");
        Assert.assertNotEquals(0,employeeFile1.size());

    }
}

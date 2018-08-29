package ru.innopolis.lesson_5_dz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFile {

    private String fileName = "Employee.dat";

    public EmployeeFile() {
        super();
        File file = new File(fileName);
        try {
            file.createNewFile();
            file.exists();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean save (Employee employee){
        System.out.println("Вызов save");
        List<Employee>employeeList = readEmployee();
        if(employeeList == null){
            employeeList = new ArrayList<>();
        }
        employeeList.add(employee);
        for (Employee employee1 : employeeList){
            System.out.println(employee1 + "*********");
        }
        return writeEmployee(employeeList);
    }

    public boolean delete(Employee employee){
        System.out.println("Вызов delete");
        List<Employee>employeeList = readEmployee();
        if (employeeList == null) return false;
        employeeList.remove(employee);
        for (Employee employee1 : employeeList){
            System.out.println(employee1);
        }
        return writeEmployee(employeeList);
    }

    public Employee getByName(String name){
        System.out.println("Вызов getByName");
        List<Employee>employeeList = readEmployee();
        for (Employee employee: employeeList){
            if (name.equals(employee.getName())){
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getByJob(String job){
        List<Employee>employeeList = readEmployee();
        List<Employee>employeeListJob = new ArrayList<>();
        for (Employee employee: employeeList){
            if (job.equals(employee.getJob())){
                employeeListJob.add(employee);
            }
        }
        return employeeListJob;
    }

    public boolean saveOrUpdate(Employee employee){
        if(getByName(employee.getName()) != null){
            delete(getByName(employee.getName()));
        }
        return save(employee);
    }

    public boolean changeAllWork(String job, String job1){
        List<Employee>employeeList = readEmployee();
        if (employeeList == null) return false;
        List<Employee>employeeListNewJob = new ArrayList<>();
        for(Employee employee : employeeList){
            if (employee.getJob() != job){
                employee.setJob(job1);
                employeeListNewJob.add(employee);
            } else {
                employeeListNewJob.add(employee);
            }
        }
        return writeEmployee(employeeListNewJob);

    }

    private ArrayList<Employee> readEmployee(){
        if (new File(fileName).length() == 0) return null;
        ArrayList<Employee> employeeArrayList = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            employeeArrayList = (ArrayList<Employee>)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employeeArrayList;
    }

    private boolean writeEmployee(List<Employee> employeeList){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(employeeList);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}

package ru.innopolis.lesson_5_dz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFile {

    private String fileName = "Employee.dat";

    public boolean save (Employee employee){
        List<Employee>employeeList = readEmployee();
        if (employeeList == null) return false;
        employeeList.add(employee);
        return writeEmployee(employeeList);
    }

    public boolean delete(Employee employee){
        List<Employee>employeeList = readEmployee();
        if (employeeList == null) return false;
        employeeList.remove(employee);
        return writeEmployee(employeeList);
    }

    public Employee getByName(String name){
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
            if (employee.getJob() == job){
                employee.setJob(job1);
                employeeListNewJob.add(employee);
            } else {
                employeeListNewJob.add(employee);
            }
        }
        return writeEmployee(employeeListNewJob);

    }

    private List<Employee> readEmployee(){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            ArrayList<Employee> employeeArrayList = (ArrayList<Employee>)objectInputStream.readObject();
            return employeeArrayList;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean writeEmployee(List<Employee> employeeList){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new ObjectOutputStream(new FileOutputStream(fileName)))){
            objectOutputStream.writeObject(employeeList);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}

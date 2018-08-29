/*Существует класс Employee с полями name, age, salary, job. Типы необходимо выбрать самостоятельно. Задание:

        1.      Реализовать следующие методы:

        a.      boolean save (Employee), дописывающий сотрудника в конец файла
        b.      boolean delete (Employee), удаляющий сотрудника из файла
        c.      Employee getByName (тип name), возвращающий сотрудника по полному совпадению имени
        d.      List<Employee> getByJob(тип job), возвращающий список сотрудников по должности
        e.      boolean saveOrUpdate (Employee), выполняющий обновление, либо сохранение сотрудника в зависимости от того, есть ли он уже в файле
        f.       boolean changeAllWork (какую должноcть, на какую должность), выполняющий замену заданной должности на заданную для всех сотрудников
        g.      Используем сериализацию/десериализацию «Из коробки»
        2.      Доп. Задание (+10%) в конец файла дописывать сумму зарплат всех сотрудников (с помощью Externalizable)

        3.      Доп. Задание (+10%) сделать все на кастомной сериализции/десериализации (BufferedReader/BufferedWriter)
  */

package ru.innopolis.lesson_5_dz;

import java.io.*;
import java.util.Objects;

public class Employee implements Serializable, Externalizable {

    private String name;
    private int age;
    private long salary;
    private String job;

    public Employee() {
    }

    public Employee(String name, int age, int salary, String job) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.write(age);
        out.writeLong(salary);
        out.writeUTF(job);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        age = in.read();
        salary = in.readLong();
        job = in.readUTF();
    }

    @Override
    public String toString() {
        return new String("Employee name " + name + " age " +
                age + " salary " + salary + " job " + job);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                salary == employee.salary &&
                Objects.equals(name, employee.name) &&
                Objects.equals(job, employee.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, job);
    }
}

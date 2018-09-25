package ru.innopolis.lesson_15_dz;

import ru.innopolis.lesson_15_dz.dao.StudentDaoImpl;
import ru.innopolis.lesson_15_dz.pojo.Group;
import ru.innopolis.lesson_15_dz.pojo.Student;

public class Main {
    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        Group group = new Group(1, "Java", 12);
        Student student = new Student(1, "Sergej", "Kashenkov", 32, "jgdgjs","Sankt_Peterburg", group);
        studentDao.addStudent(student);
    }
}

package ru.innopolis.lesson_15_dz.dao;

import ru.innopolis.lesson_15_dz.pojo.Student;

public interface StudentDao {
    boolean addStudent(Student student);

    Student getStudentById(int id);

    boolean updateStudent(Student student);

    boolean deleteStudentById(int id);
}

package edu.cs.crud.crudsystem.service;

import edu.cs.crud.crudsystem.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    void create_student(Student student);

    Student getStudentById(int id);

    void updateStudent(Student student);

    void delete_student(int id);
}

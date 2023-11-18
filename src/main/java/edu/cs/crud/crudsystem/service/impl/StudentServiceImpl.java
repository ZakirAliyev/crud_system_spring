package edu.cs.crud.crudsystem.service.impl;

import edu.cs.crud.crudsystem.model.Student;
import edu.cs.crud.crudsystem.repository.StudentRepository;
import edu.cs.crud.crudsystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public void create_student(Student student) {

        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete_student(int id) {
        studentRepository.deleteById(id);
    }

}

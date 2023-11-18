package edu.cs.crud.crudsystem.controller;

import edu.cs.crud.crudsystem.model.Student;
import edu.cs.crud.crudsystem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/error")
    public String error() {
        return "redirect:/error";
    }

    @GetMapping("/students")
    public String getAllUsersHtml(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/create_student")
    public String createStudentHtml(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentHtml(@PathVariable int id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String edit_student(@PathVariable int id, @ModelAttribute("student") Student student) {
        Student excitingStudent = studentService.getStudentById(id);

        excitingStudent.setId(student.getId());
        excitingStudent.setEmail(student.getEmail());
        excitingStudent.setFinCode(student.getFinCode());
        excitingStudent.setFirstName(student.getFirstName());
        excitingStudent.setLastName(student.getLastName());

        studentService.updateStudent(excitingStudent);

        return "redirect:/students";
    }

    @PostMapping("/students")
    public String createStudent(@ModelAttribute("student") Student student) {
        studentService.create_student(student);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.delete_student(id);
        return "redirect:/students";
    }
}

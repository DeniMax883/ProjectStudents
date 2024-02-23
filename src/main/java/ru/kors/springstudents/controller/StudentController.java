package ru.kors.springstudents.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kors.springstudents.model.Student;
import ru.kors.springstudents.service.impl.StudentServiceImpl2;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentServiceImpl2 studentService;

    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @PostMapping("save_student")
    public String saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Student was successfully added";
    }

    @GetMapping ("{email}")
    public Student findByEmail(@PathVariable("email") String email){
        return studentService.findByEmail(email);
    }

    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email) {
        studentService.deleteStudent(email);
    }



}

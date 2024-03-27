package org.seyharouge.springboot.homework.controller;

import org.seyharouge.springboot.homework.model.RequestBody.StudentRequest;
import org.seyharouge.springboot.homework.model.Student;
import org.seyharouge.springboot.homework.model.responseBody.ResponseBody;
import org.seyharouge.springboot.homework.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<ResponseBody<List<Student>>> getAllStudents(@RequestParam(defaultValue = "1") int page,
                                                                      @RequestParam(defaultValue = "4") int size) {
        int offset = (page - 1) * size;

        List<Student> students = studentService.getALlStudents( offset , size);
        ResponseBody<List<Student>> responseBody = new ResponseBody<>("Success", students, "200");
        return ResponseEntity.ok(responseBody);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseBody<?>> getStudentById(@PathVariable Integer id) {
        Optional<Student> optionalStudent = Optional.ofNullable(studentService.getStudentById(id));
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            ResponseBody<Student> studentResponseBody = new ResponseBody<>("Success", student, "200");
            return ResponseEntity.ok(studentResponseBody);
        } else {
            ResponseBody<String> errorResponseBody = new ResponseBody<>("Student not found", "404");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseBody);
        }
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentRequest request) {
        this.studentService.addStudent(request);
        return ResponseEntity.ok(request);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        Optional<Student> optionalStudent = Optional.ofNullable(studentService.getStudentById(id));
        if (optionalStudent.isPresent()) {
            studentService.deleteStudent(id);
            ResponseBody<Student> studentResponseBody = new ResponseBody<>("Success", "200");
            return ResponseEntity.ok(studentResponseBody);
        } else {
            ResponseBody<String> stringResponseBody = new ResponseBody<>("Student Not Found", "404");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(stringResponseBody);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, StudentRequest studentRequest) {
        Optional<Student> optionalStudent = Optional.ofNullable(studentService.getStudentById(id));
        return ResponseEntity.ok("Hello");
    }
}

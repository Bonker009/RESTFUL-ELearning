package org.seyharouge.springboot.homework.service;

import org.seyharouge.springboot.homework.model.RequestBody.StudentRequest;
import org.seyharouge.springboot.homework.model.Student;

import java.util.List;

public interface StudentService     {
    List<Student> getALlStudents(int offset,int size);
    Student getStudentById(Integer id);
    void addStudent(StudentRequest studentRequest);
    void updateStudent(Student student ,Integer id);
    void deleteStudent(Integer id);

}

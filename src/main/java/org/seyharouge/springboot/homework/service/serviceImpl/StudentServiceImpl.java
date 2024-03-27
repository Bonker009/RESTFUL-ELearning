package org.seyharouge.springboot.homework.service.serviceImpl;

import org.seyharouge.springboot.homework.model.RequestBody.StudentRequest;
import org.seyharouge.springboot.homework.model.Student;
import org.seyharouge.springboot.homework.repository.StudentRepository;
import org.seyharouge.springboot.homework.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getALlStudents(int offset,int size) {
        return studentRepository.findAllStudents(offset,size);
    }

    @Override
    public Student getStudentById(Integer id) {
        System.out.println(id);
        return studentRepository.findById(id);
    }

    @Override
    public void addStudent(StudentRequest studentRequest) {
//        System.out.println(studentRequest.getCourseId());
      Integer studentId =   studentRepository.addStudent(studentRequest);

      List<Integer> courseId = studentRequest.getCourseId();
        System.out.println(studentId);
      for (Integer id : courseId){
          System.out.println(id);
          this.studentRepository.InsertCourse(id,studentId);
      }

    }

    @Override
    public void updateStudent(Student student,Integer id) {
        System.out.println("Student : "+ student + " id : "+ id);
        studentRepository.updateStudent(student,id);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteStudent(id);
    }



}

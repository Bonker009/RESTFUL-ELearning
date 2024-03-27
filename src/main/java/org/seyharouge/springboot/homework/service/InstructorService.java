package org.seyharouge.springboot.homework.service;

import org.seyharouge.springboot.homework.model.Instructor;
import org.seyharouge.springboot.homework.model.RequestBody.InstructorRequest;
import org.seyharouge.springboot.homework.model.Student;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors(int offset,int size);
    Instructor getInstructorById(Integer id);
    void addInstructor(InstructorRequest request);
    void updateInstructor(InstructorRequest instructorRequest,Integer id);
    void deleteInstructor(Integer id);
}

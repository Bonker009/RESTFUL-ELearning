package org.seyharouge.springboot.homework.service.serviceImpl;

import org.seyharouge.springboot.homework.model.Instructor;
import org.seyharouge.springboot.homework.model.RequestBody.InstructorRequest;
import org.seyharouge.springboot.homework.model.Student;
import org.seyharouge.springboot.homework.repository.InstructorRepository;
import org.seyharouge.springboot.homework.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructors(int offset,int size) {
        return instructorRepository.findAllInstructors(offset,size);
    }

    @Override
    public Instructor getInstructorById(Integer id) {
        return instructorRepository.findById(id);
    }

    @Override
    public void addInstructor(InstructorRequest request) {
        instructorRepository.addInstructor(request);
    }

    @Override
    public void updateInstructor(InstructorRequest instructorRequest, Integer id) {
        instructorRepository.updateInstructor(instructorRequest,id);
    }

    @Override
    public void deleteInstructor(Integer id) {
        instructorRepository.deleteInstructor(id);
    }
}

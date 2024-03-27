package org.seyharouge.springboot.homework.service.serviceImpl;

import org.seyharouge.springboot.homework.model.Course;
import org.seyharouge.springboot.homework.model.Instructor;
import org.seyharouge.springboot.homework.model.RequestBody.CourseRequest;
import org.seyharouge.springboot.homework.repository.CourseRepository;
import org.seyharouge.springboot.homework.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses(int offset,int size) {
        return courseRepository.findAllCourses(offset, size);
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseRepository.findById(id);
    }

    @Override
    public void addCourse(CourseRequest request) {
        this.courseRepository.addCourse(request.getCourseName(),request.getInstructorId(),request.getDescription() );
    }

    @Override
    public void updateCourse(CourseRequest request, Integer id) {
        this.courseRepository.updateCourse(request, id);
    }

    @Override
    public void deleteCourse(Integer id) {
        this.courseRepository.deleteCourse(id);
    }
}

package org.seyharouge.springboot.homework.service;

import org.seyharouge.springboot.homework.model.Course;
import org.seyharouge.springboot.homework.model.Instructor;
import org.seyharouge.springboot.homework.model.RequestBody.CourseRequest;
import org.seyharouge.springboot.homework.model.RequestBody.InstructorRequest;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses(int offset,int size);
    Course getCourseById(Integer id);
    void addCourse(CourseRequest request);
    void updateCourse(CourseRequest request,Integer id);
    void deleteCourse(Integer id);
}

package org.seyharouge.springboot.homework.controller;

import org.seyharouge.springboot.homework.model.Course;
import org.seyharouge.springboot.homework.model.RequestBody.CourseRequest;
import org.seyharouge.springboot.homework.model.responseBody.APIResponse;
import org.seyharouge.springboot.homework.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCourses(@RequestParam(defaultValue = "1") int page,
                                           @RequestParam(defaultValue = "4") int size) {
        int offset = (page - 1) * size;
        List<Course> courseList = this.courseService.getAllCourses(offset, size);
        APIResponse<List<Course>> listAPIResponse = new APIResponse<>("Hello", courseList, HttpStatus.OK, new Date());
        return ResponseEntity.ok(listAPIResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer id) {
        Course course = this.courseService.getCourseById(id);
        APIResponse<Course> apiResponse = new APIResponse<>("Hello World", course, HttpStatus.OK, new Date());
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody CourseRequest request) {
        this.courseService.addCourse(request);
        APIResponse<Course> apiResponse = new APIResponse<>("Success", null, HttpStatus.OK, new Date());
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, CourseRequest request) {
        Course course = this.courseService.getCourseById(id);
        this.courseService.updateCourse(request, id);
        APIResponse<Course> apiResponse = new APIResponse<>("Success", course, HttpStatus.OK, new Date());
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        this.courseService.deleteCourse(id);
        APIResponse<Course> apiResponse = new APIResponse<>("Deleted", null, HttpStatus.OK, new Date());
        return ResponseEntity.ok(apiResponse);
    }
}

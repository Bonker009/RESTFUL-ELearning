package org.seyharouge.springboot.homework.controller;

import org.seyharouge.springboot.homework.model.Instructor;
import org.seyharouge.springboot.homework.model.RequestBody.InstructorRequest;
import org.seyharouge.springboot.homework.model.Student;
import org.seyharouge.springboot.homework.model.responseBody.APIResponse;
import org.seyharouge.springboot.homework.model.responseBody.ResponseBody;
import org.seyharouge.springboot.homework.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents(@RequestParam(defaultValue = "1") int page,
                                            @RequestParam(defaultValue = "4") int size){
        int offset = (page - 1) * size;
        List<Instructor> instructors = instructorService.getAllInstructors(offset,size);
        APIResponse<List<Instructor>> listAPIResponse = new APIResponse<>("Hello",instructors,HttpStatus.CONTINUE,new Date());
        return ResponseEntity.ok(listAPIResponse);
    }
    @PostMapping
    public ResponseEntity<?> addInstructor(@RequestBody InstructorRequest request){
        instructorService.addInstructor(request);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse<>("Success",request,HttpStatus.CONTINUE,new Date()));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateInstructor(@PathVariable Integer id,InstructorRequest instructorRequest){
        Instructor instructor = instructorService.getInstructorById(id);
        instructorService.updateInstructor(instructorRequest,id);
        APIResponse<Instructor> apiResponse = new APIResponse<>("Found",instructor,HttpStatus.OK,new Date());
        return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findInstructorById(@PathVariable Integer id){
        Instructor instructor = instructorService.getInstructorById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse<>("Success", instructor, HttpStatus.OK, new Date()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable Integer id){
        instructorService.deleteInstructor(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse<Instructor>("Deleted",null,HttpStatus.OK,new Date()));
    }
}

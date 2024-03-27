package org.seyharouge.springboot.homework.repository;

import org.apache.ibatis.annotations.*;
import org.seyharouge.springboot.homework.model.Course;
import org.seyharouge.springboot.homework.model.RequestBody.StudentRequest;
import org.seyharouge.springboot.homework.model.Student;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("""
SELECT * FROM students LIMIT #{size} OFFSET #{offset}
""")
    @Results({
            @Result(property = "id", column = "student_id"),
            @Result(property = "student_name", column = "student_name"),
            @Result(property = "phone_number", column = "phone_number"),
            @Result(property = "courseList", column = "student_id", javaType = List.class, many = @Many(select = "org.seyharouge.springboot.homework.repository.CourseRepository.findCoursesByStudentIdWithInstructors"))
    })
    List<Student> findAllStudents(@Param("offset") int offset, @Param("size") int size);

    @Select("SELECT * FROM students WHERE student_id = #{id}")
    @Results({
            @Result(property = "id", column = "student_id"),
            @Result(property = "student_name", column = "student_name"),
            @Result(property = "phone_number", column = "phone_number"),
            @Result(property = "courseList", column = "student_id", javaType = List.class, many = @Many(select = "org.seyharouge.springboot.homework.repository.CourseRepository.findCoursesByStudentIdWithInstructors"))
    })
    Student findById(Integer id);

    @Select("INSERT INTO students (student_id,student_name, email, phone_number) VALUES (DEFAULT,#{student.student_name}, #{student.email}, #{student.phone_number}) RETURNING student_id")
    Integer addStudent(@Param("student") StudentRequest student);

    @Insert("INSERT INTO student_course (id,student_id, course_id) VALUES (DEFAULT,#{studentId} , #{courseId})")
    void InsertCourse(Integer courseId, Integer studentId);

    @Delete("DELETE FROM students WHERE student_id = #{id}")
    void deleteStudent(Integer id);


    @Update("UPDATE students SET student_name = #{student.studentName}, email = #{student.email}, phone_number = #{student.phoneNumber} WHERE student_id = #{id}")
    void updateStudent(@Param("student") Student student, @Param("id") Integer id);
}

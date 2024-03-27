package org.seyharouge.springboot.homework.repository;

import org.apache.ibatis.annotations.*;
import org.seyharouge.springboot.homework.model.Course;
import org.seyharouge.springboot.homework.model.Instructor;
import org.seyharouge.springboot.homework.model.RequestBody.CourseRequest;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("SELECT * FROM courses LIMIT #{size} OFFSET #{offset}")
    @Results({
            @Result(property = "instructor", column = "instructor_id", javaType = Instructor.class, one = @One(select = "org.seyharouge.springboot.homework.repository.InstructorRepository.findById"))
    })
    List<Course> findAllCourses(@Param("offset") int offset, @Param("size") int size);

    @Select("SELECT * FROM courses WHERE course_id = #{id}")
    @Results({

            @Result(property = "instructor", column = "instructor_id", javaType = Instructor.class, one = @One(select = "org.seyharouge.springboot.homework.repository.InstructorRepository.findById"))
    })
    Course findById(Integer id);

    @Insert("INSERT INTO courses (course_name, instructor_id, description) VALUES (#{courseName}, #{instructorId}, #{description})")
    void addCourse(@Param("courseName") String courseName, @Param("instructorId") Integer instructorId, @Param("description") String description);

    @Delete("DELETE FROM courses WHERE course_id = #{id}")
    void deleteCourse(Integer id);

    @Select("SELECT c.*, i.* FROM courses c " +
            "JOIN student_course sc ON c.course_id = sc.course_id " +
            "JOIN instructors i ON c.instructor_id = i.instructor_id " +
            "WHERE sc.student_id = #{studentId}")
    @Results(id = "courseMapping", value = {
            @Result(property = "course_id", column = "course_id"),
            @Result(property = "course_name", column = "course_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "instructor.id", column = "instructor_id"),
            @Result(property = "instructor.instructor_name", column = "instructor_name"),
            @Result(property = "instructor.email", column = "email")
    })
    List<Course> findCoursesByStudentIdWithInstructors(Integer studentId);
    @Update("UPDATE courses SET course_name = #{course.courseName}, instructor_id = #{course.instructorId}, description = #{course.description} WHERE course_id = #{id}")
    void updateCourse(@Param("course") CourseRequest request, @Param("id") Integer id);
}

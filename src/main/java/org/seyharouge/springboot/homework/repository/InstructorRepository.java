package org.seyharouge.springboot.homework.repository;

import org.apache.ibatis.annotations.*;
import org.seyharouge.springboot.homework.model.Instructor;
import org.seyharouge.springboot.homework.model.RequestBody.InstructorRequest;
import org.seyharouge.springboot.homework.model.Student;

import java.util.List;

@Mapper
public interface InstructorRepository {
    @Select("SELECT * FROM instructors ORDER BY instructor_id LIMIT #{size} OFFSET #{offset}")
    @Result(property = "id", column = "instructor_id")
    List<Instructor> findAllInstructors(@Param("offset") int offset, @Param("size") int size);

    @Select("SELECT * FROM instructors WHERE instructor_id = #{id}")
    @Result(property = "id", column = "instructor_id")
    Instructor findById(Integer id);

    @Insert("""
            INSERT INTO instructors VALUES (DEFAULT,#{request.instructorName},#{request.email})""")
    @Result(property = "instructorName", column = "instructor_name")
    void addInstructor(@Param("request") InstructorRequest request);

    @Delete("""
            DELETE FROM instructors WHERE instructor_id = #{id}
            """)
    @Result(property = "id", column = "instructor_id")
    void deleteInstructor(Integer id);

    @Update("""
                UPDATE instructors SET email = #{instructorRequest.email} ,instructor_name = #{instructorRequest.instructorName } WHERE instructor_id = #{id}
            """)
    @Result(property = "instructorName", column = "instructor_name")
    void updateInstructor(@Param("instructorRequest") InstructorRequest instructorRequest, Integer id);
}

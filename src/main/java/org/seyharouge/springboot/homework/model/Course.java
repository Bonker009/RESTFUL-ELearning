package org.seyharouge.springboot.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Integer course_id;
    private String course_name;
    private String description;
    private Instructor instructor;
}

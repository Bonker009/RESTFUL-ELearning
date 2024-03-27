package org.seyharouge.springboot.homework.model.RequestBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {
    private String courseName;
    private String description;
    private Integer instructorId;
}

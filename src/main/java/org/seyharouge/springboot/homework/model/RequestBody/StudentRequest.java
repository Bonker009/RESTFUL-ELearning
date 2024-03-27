package org.seyharouge.springboot.homework.model.RequestBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public  class StudentRequest {
    private String student_name;
    private String email;
    private String phone_number;
    private List<Integer> courseId;


}
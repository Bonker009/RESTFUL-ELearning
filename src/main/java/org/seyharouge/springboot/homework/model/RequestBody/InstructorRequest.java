package org.seyharouge.springboot.homework.model.RequestBody;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstructorRequest {
    private String instructorName;
    private String email;
}

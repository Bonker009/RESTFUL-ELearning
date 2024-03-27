package org.seyharouge.springboot.homework.model.responseBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.seyharouge.springboot.homework.model.Instructor;
import org.springframework.http.HttpStatus;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T> {
    private String message;
    private T payload;
    private HttpStatus status;
    private Date time;
}

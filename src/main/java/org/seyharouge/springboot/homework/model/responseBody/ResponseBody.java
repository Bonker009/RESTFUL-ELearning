package org.seyharouge.springboot.homework.model.responseBody;

import java.time.LocalDate;
import java.util.Date;

public class ResponseBody<T> {
    private String message;
    private T payload;
    private String status;
    private Date time;

    public ResponseBody() {
    }

    public ResponseBody(String message, T payload, String status ) {
        this.message = message;
        this.payload = payload;
        this.status = status;
        this.time = new Date();
    }

    public ResponseBody(String message, String status ) {
        this.message = message;
        this.status = status;
        this.time = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ResponseBody{" +
                "message='" + message + '\'' +
                ", payload=" + payload +
                ", status='" + status + '\'' +
                ", time=" + time +
                '}';
    }
}

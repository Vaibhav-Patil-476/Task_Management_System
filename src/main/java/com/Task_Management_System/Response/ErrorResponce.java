package com.Task_Management_System.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
public class ErrorResponce {

    private int status;
    private String message;
    private LocalDateTime localdatetime;

    public ErrorResponce(int status, String message) {
        this.status = status;
        this.message = message;
        this.localdatetime = LocalDateTime.now();
    }
}
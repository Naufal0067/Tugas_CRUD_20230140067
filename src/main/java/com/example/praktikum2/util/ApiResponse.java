package com.example.praktikum2.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {

    private Boolean success;
    private String message;
    private T data;

}
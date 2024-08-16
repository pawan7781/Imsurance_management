package com.project.insurance.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter

public class ApiResponse<T> {
    private int statusCode;
    private T data;
    private String msg;
}

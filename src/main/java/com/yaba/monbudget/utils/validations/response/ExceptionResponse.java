package com.yaba.monbudget.utils.validations.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data @AllArgsConstructor @NoArgsConstructor
public class ExceptionResponse {
    private HttpStatus status;

    private String message;
}

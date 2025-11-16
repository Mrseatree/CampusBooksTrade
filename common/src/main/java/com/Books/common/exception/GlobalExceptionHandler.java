package com.Books.common.exception;

import com.Books.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e) {
        e.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(value = BookException.class)
    @ResponseBody
    public Result exceptionHandler (BookException e) {
        e.printStackTrace();
        return Result.fail(e.getCode(),e.getMessage());
    }
}

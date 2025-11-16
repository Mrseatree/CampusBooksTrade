package com.Books.common.exception;

import com.Books.common.result.ResultCodeEnum;
import lombok.Data;

@Data
public class BookException extends RuntimeException {
    private  Integer code;

    public BookException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public BookException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
}

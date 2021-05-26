package com.young.generator.exception;


import com.young.common.exception.BaseException;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException() {
        super(MallErrorType.USER_NOT_FOUND);
    }

    public UserNotFoundException(String message) {
        super(MallErrorType.USER_NOT_FOUND, message);
    }
}

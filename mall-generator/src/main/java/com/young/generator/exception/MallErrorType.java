package com.young.generator.exception;

import com.young.common.exception.ErrorType;
import lombok.Getter;

@Getter
public enum MallErrorType implements ErrorType {

    USER_NOT_FOUND("030100", "用户未找到！");

    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String msg;

    MallErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

package com.neusoft.elm.exception;

import com.neusoft.elm.enums.ResultEnum;

/**
 * @author QiutianDog
 * @Date 2020/11/27
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}

package com.tistory.amyyzzin.dividend.exception.impl;

import com.tistory.amyyzzin.dividend.exception.AbstractException;
import org.springframework.http.HttpStatus;

public class AlreadyExistTickerException extends AbstractException {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "이미 보유하고 있는 회사입니다.";
    }
}

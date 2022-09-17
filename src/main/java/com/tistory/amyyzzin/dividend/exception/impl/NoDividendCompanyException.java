package com.tistory.amyyzzin.dividend.exception.impl;

import com.tistory.amyyzzin.dividend.exception.AbstractException;
import org.springframework.http.HttpStatus;

public class NoDividendCompanyException extends AbstractException {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "배당금 내역이 존재하지 않는 회사입니다.";
    }
}

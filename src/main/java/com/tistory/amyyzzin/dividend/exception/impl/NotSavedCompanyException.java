package com.tistory.amyyzzin.dividend.exception.impl;

import com.tistory.amyyzzin.dividend.exception.AbstractException;
import org.springframework.http.HttpStatus;

public class NotSavedCompanyException extends AbstractException {

    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "추가되어 있지 않은 회사이기 때문에 삭제할 수 없습니다.";
    }
}

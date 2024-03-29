package com.sendi.v1.exception.custom;

import com.sendi.v1.util.ErrorMessages;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionCountException extends RuntimeException {
    private static final long serialVersionUID = 1030848032571748919L;

    public QuestionCountException(String message) {
        super(message);
    }

    public QuestionCountException(Integer questionCount) {
        super(ErrorMessages.QUESTION_COUNT_LESS.getMessage() + questionCount);
    }

}

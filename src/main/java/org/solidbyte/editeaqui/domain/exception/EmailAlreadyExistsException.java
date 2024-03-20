package org.solidbyte.editeaqui.domain.exception;

public class EmailAlreadyExistsException extends BusinessException {

    public EmailAlreadyExistsException() {
        super(3, "email already exists");
    }
}

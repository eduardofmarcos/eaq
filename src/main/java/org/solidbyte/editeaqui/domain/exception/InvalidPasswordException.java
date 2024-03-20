package org.solidbyte.editeaqui.domain.exception;

public class InvalidPasswordException extends BusinessException {
    public InvalidPasswordException() {
        super(4, "invalid password");
    }
}


package org.solidbyte.editeaqui.domain.exception;

public class NameAlreadyExistsException extends BusinessException {

    public NameAlreadyExistsException() {
        super(2, "name already exists");
    }
}


package org.solidbyte.editeaqui.domain.exception;

public class EditorNotFoundException extends BusinessException {

    public EditorNotFoundException() {
        super(1, "editor not found");
    }
}


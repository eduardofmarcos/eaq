package org.solidbyte.editeaqui.domain.exception;

import java.util.List;

public class ModelValidationException extends BusinessException {

    public ModelValidationException(List<String> messages) {
        super(8, messages);
    }
}

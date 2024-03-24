package org.solidbyte.editeaqui.domain.validator;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.exception.ModelValidationException;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@ApplicationScoped
public class ModelValidator {

    private final Validator validator;

    public <T> T validate(T model) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(model);

        if (!constraintViolations.isEmpty()) {
            final var messages =
                    constraintViolations.stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.toList());
            throw new ModelValidationException(messages);
        }

        return model;
    }
}
package org.solidbyte.editeaqui.domain.model.editor;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.validator.ModelValidator;

import java.util.UUID;

@Named
@AllArgsConstructor
@ApplicationScoped
public class EditorModelBuilder {

    private final ModelValidator modelValidator;

    // constructor overload differentiate by id, if there is "id" is an update operation if not, it is a creation operation
    public Editor build(UUID id, String name, String email, String password, String cpf, String phone, String address, String city, String state, String zip, String country, boolean isActive) {
        return modelValidator.validate(new Editor(id, name, email, password, cpf, phone, address, city, state, zip, country, isActive));
    }

    public Editor build(String name, String email, String password, String cpf, String phone, String address, String city, String state, String zip, String country, boolean isActive) {
        return modelValidator.validate(new Editor(UUID.randomUUID(), name, email, password, cpf, phone, address, city, state, zip, country, true));
    }

}

package org.solidbyte.editeaqui.domain.model.user;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.validator.ModelValidator;

import java.util.UUID;

@Named
@AllArgsConstructor
@ApplicationScoped
public class UserModelBuilder {

    private final ModelValidator modelValidator;

    public User build(UUID id, String name, String email, String password, String phone, String address, String city, String state, String zip, String country) {
        return modelValidator.validate(
                new User(UUID.randomUUID(), name, email, password, phone, address, city, state, zip, country));
    }

}
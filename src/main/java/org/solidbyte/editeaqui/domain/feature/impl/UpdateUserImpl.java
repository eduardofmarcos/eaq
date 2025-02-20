package org.solidbyte.editeaqui.domain.feature.impl;


import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.feature.FindUserById;
import org.solidbyte.editeaqui.domain.feature.UpdateUser;
import org.solidbyte.editeaqui.domain.model.user.UpdateUserInput;
import org.solidbyte.editeaqui.domain.model.user.User;
import org.solidbyte.editeaqui.domain.model.user.UserRepository;
import org.solidbyte.editeaqui.domain.validator.ModelValidator;

@AllArgsConstructor
@ApplicationScoped
public class UpdateUserImpl implements UpdateUser {

    private final FindUserById findUserById;
    private final UserRepository userRepository;
    private final ModelValidator modelValidator;

    @Override
    public User handle(UpdateUserInput updateUserInput) {
        final User user = findUserById.handle(updateUserInput.getId());

        updateFields(user, updateUserInput);
        userRepository.update(modelValidator.validate(user));
        return user;
    }

    private void updateFields(User user, UpdateUserInput updateUserInput) {

        if (isPresent(updateUserInput.getName())) {
            user.setName(updateUserInput.getName());
        }

        if (isPresent(updateUserInput.getPhone())) {
            user.setPhone(updateUserInput.getPhone());
        }

        if (isPresent(updateUserInput.getAddress())) {
            user.setAddress(updateUserInput.getAddress());
        }

        if (isPresent(updateUserInput.getCity())) {
            user.setCity(updateUserInput.getCity());
        }

        if (isPresent(updateUserInput.getState())) {
            user.setState(updateUserInput.getState());
        }

        if (isPresent(updateUserInput.getZip())) {
            user.setZip(updateUserInput.getZip());
        }

        if (isPresent(updateUserInput.getCountry())) {
            user.setCountry(updateUserInput.getCountry());
        }

    }

    private boolean isPresent(String property) {
        return property != null && !property.isEmpty();
    }

}

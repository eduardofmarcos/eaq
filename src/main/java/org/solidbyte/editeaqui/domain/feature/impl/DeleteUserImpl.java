package org.solidbyte.editeaqui.domain.feature.impl;


import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.feature.DeleteUser;
import org.solidbyte.editeaqui.domain.feature.FindUserById;
import org.solidbyte.editeaqui.domain.model.user.User;
import org.solidbyte.editeaqui.domain.model.user.UserRepository;
import org.solidbyte.editeaqui.domain.validator.ModelValidator;

import java.util.UUID;

@AllArgsConstructor
@ApplicationScoped
public class DeleteUserImpl implements DeleteUser {

    private final FindUserById findUserById;
    private final UserRepository userRepository;
    private final ModelValidator modelValidator;

    @Override
    public User handle(UUID uuid) {
        final User user = findUserById.handle(uuid);
        updateFields(user);
        userRepository.update(modelValidator.validate(user));
        return null;
    }

    private void updateFields(User user) {
        user.setActive(false);
    }
}

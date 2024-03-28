package org.solidbyte.editeaqui.domain.feature.impl;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.exception.UserNotFoundException;
import org.solidbyte.editeaqui.domain.feature.FindUserById;
import org.solidbyte.editeaqui.domain.model.user.User;
import org.solidbyte.editeaqui.domain.model.user.UserRepository;

import java.util.UUID;

@AllArgsConstructor
@ApplicationScoped
public class FindUserByIdImpl implements FindUserById {

    private final UserRepository userRepository;

    @Override
    public User handle(UUID id) {
        User user = userRepository.findUserById(id).orElseThrow(UserNotFoundException::new);
        return user;
    }
}

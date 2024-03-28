package org.solidbyte.editeaqui.domain.feature.impl;

import jakarta.enterprise.context.ApplicationScoped;
import org.solidbyte.editeaqui.domain.exception.InvalidPasswordException;
import org.solidbyte.editeaqui.domain.exception.UserNotFoundException;
import org.solidbyte.editeaqui.domain.feature.LoginUser;
import org.solidbyte.editeaqui.domain.model.provider.HashProvider;
import org.solidbyte.editeaqui.domain.model.user.LoginUserInput;
import org.solidbyte.editeaqui.domain.model.user.User;

import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.model.user.UserRepository;


@AllArgsConstructor
@ApplicationScoped
public class LoginUserImpl implements LoginUser {

    private final UserRepository userRepository;
    private final HashProvider hashProvider;

    @Override
    public User handle(LoginUserInput loginUserInput) {
        final var user =
                userRepository
                        .findByEmail(loginUserInput.getEmail())
                        .orElseThrow(UserNotFoundException::new);
        if (!isPasswordValid(loginUserInput.getPassword(), user.getPassword())) {
            throw new InvalidPasswordException();
        }
        return user;
    }

    private boolean isPasswordValid(String password, String hashedPassword) {
        return hashProvider.checkPassword(password, hashedPassword);
    }
}
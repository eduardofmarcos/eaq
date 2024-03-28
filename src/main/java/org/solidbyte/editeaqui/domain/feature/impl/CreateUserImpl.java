package org.solidbyte.editeaqui.domain.feature.impl;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.exception.EmailAlreadyExistsException;
import org.solidbyte.editeaqui.domain.feature.CreateUser;
import org.solidbyte.editeaqui.domain.model.user.CreateUserInput;
import org.solidbyte.editeaqui.domain.model.user.User;
import org.solidbyte.editeaqui.domain.model.user.UserModelBuilder;
import org.solidbyte.editeaqui.domain.model.user.UserRepository;

@AllArgsConstructor
@ApplicationScoped
public class CreateUserImpl implements CreateUser {

    private final UserRepository userRepository;
    private final UserModelBuilder userBuilder;

    @Override
    public User handle(CreateUserInput createUserInput) {
        final var user =
                userBuilder.build(
                        createUserInput.getName(),
                        createUserInput.getEmail(),
                        createUserInput.getPassword(),
                        createUserInput.getPhone(),
                        createUserInput.getAddress(),
                        createUserInput.getCity(),
                        createUserInput.getState(),
                        createUserInput.getZip(),
                        createUserInput.getCountry(),
                        createUserInput.isActive());

//        checkExistingUsername(user.getName());
        checkExistingEmail(user.getEmail());
        userRepository.save(user);
        return user;
    }

//    private void checkExistingUsername(String name) {
//        if (userRepository.existsBy("name", name)) {
//            throw new UsernameAlreadyExistsException();
//        }
//    }

    private void checkExistingEmail(String email) {
        if (userRepository.existsBy("email", email)) {
            throw new EmailAlreadyExistsException();
        }
    }

}

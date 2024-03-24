package org.solidbyte.editeaqui.domain.feature;


import org.solidbyte.editeaqui.domain.model.user.CreateUserInput;
import org.solidbyte.editeaqui.domain.model.user.User;

public interface CreateUser {
    User handle(CreateUserInput createUserInput);
}

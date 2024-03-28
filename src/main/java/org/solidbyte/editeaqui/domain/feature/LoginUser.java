package org.solidbyte.editeaqui.domain.feature;

import jakarta.enterprise.context.ApplicationScoped;
import org.solidbyte.editeaqui.domain.model.user.LoginUserInput;
import org.solidbyte.editeaqui.domain.model.user.User;


public interface LoginUser {
    User handle(LoginUserInput loginUserInput);
}

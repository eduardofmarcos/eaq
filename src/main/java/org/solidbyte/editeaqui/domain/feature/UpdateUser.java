package org.solidbyte.editeaqui.domain.feature;

import org.solidbyte.editeaqui.domain.model.user.UpdateUserInput;
import org.solidbyte.editeaqui.domain.model.user.User;

public interface UpdateUser {
    User handle(UpdateUserInput updateUserInput);
}

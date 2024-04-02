package org.solidbyte.editeaqui.domain.feature;

import org.solidbyte.editeaqui.domain.model.user.User;

import java.util.UUID;

public interface DeleteUser {
    User handle(UUID uuid);
}

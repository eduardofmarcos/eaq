package org.solidbyte.editeaqui.domain.model.user;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    void save(User user);

    boolean existsBy(String field, String value);

    Optional<User> findByEmail(String email);

    Optional<User> findUserById(UUID id);

    boolean existsEmail(UUID excludeId, String email);

    void update(User user);

    Optional<User> findByUsername(String username);
}
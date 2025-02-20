package org.solidbyte.editeaqui.infrastructure.repository.hibernate.panache;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.model.user.User;
import org.solidbyte.editeaqui.domain.model.user.UserRepository;
import org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity.EntityUtils;
import org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

import static io.quarkus.panache.common.Parameters.with;

@ApplicationScoped
@AllArgsConstructor
public class UserRepositoryPanache extends AbstractPanacheRepository<UserEntity, UUID>
        implements UserRepository {

    private final EntityUtils entityUtils;

    @Override
    public void save(User user) {
        persist(new UserEntity(user));
    }

    @Override
    public boolean existsBy(String field, String value) {
        return count("upper(" + field + ")", value.toUpperCase().trim()) > 0;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return find("upper(email)", email.toUpperCase().trim())
                .firstResultOptional()
                .map(entityUtils::user);
    }

    @Override
    public Optional<User> findUserById(UUID id) {
        Optional<User> user = findByIdOptional(id).map(entityUtils::user);
        return user;
    }

    @Override
    public boolean existsEmail(UUID excludeId, String email) {
        return count(
                "id != :excludeId and upper(email) = :email",
                with("excludeId", excludeId).and("email", email.toUpperCase().trim()))
                > 0;
    }

    @Override
    public void update(User user) {
        final UUID id = UUID.fromString("73c660cb-e0cc-4720-9459-ec17202f72c4");

        final UUID idTest = user.getId();
        final UserEntity userEntity = findById(idTest);
        userEntity.update(user);
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return find("upper(username)", username.toUpperCase().trim())
                .firstResultOptional()
                .map(entityUtils::user);
    }
}

package org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.model.user.User;
import org.solidbyte.editeaqui.domain.model.user.UserModelBuilder;

@ApplicationScoped
@AllArgsConstructor
public class EntityUtils {

    private final UserModelBuilder userBuilder;

    public User user(UserEntity userEntity) {
        final var id = userEntity.getId();
        final var name = userEntity.getName();
        final var email = userEntity.getEmail();
        final var password = userEntity.getPassword();
        final var phone = userEntity.getPhone();
        final var address = userEntity.getAddress();
        final var city = userEntity.getCity();
        final var state = userEntity.getState();
        final var zip = userEntity.getZip();
        final var country = userEntity.getCountry();
        return userBuilder.build(id, name, email, password, phone, address, city, state,zip, country);
    }

}

package org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.model.user.User;
import org.solidbyte.editeaqui.domain.model.user.UserModelBuilder;

import java.util.UUID;

@ApplicationScoped
@AllArgsConstructor
public class EntityUtils {

    private final UserModelBuilder userBuilder;

    public User user(UserEntity userEntity) {
        final UUID id = userEntity.getId();
        final String name = userEntity.getName();
        final String email = userEntity.getEmail();
        final String password = userEntity.getPassword();
        final String phone = userEntity.getPhone();
        final String address = userEntity.getAddress();
        final String city = userEntity.getCity();
        final String state = userEntity.getState();
        final String zip = userEntity.getZip();
        final String country = userEntity.getCountry();
        final boolean isActive = userEntity.isActive();

        return userBuilder.build(id, name, email, password, phone, address, city, state, zip, country, isActive);
    }

}

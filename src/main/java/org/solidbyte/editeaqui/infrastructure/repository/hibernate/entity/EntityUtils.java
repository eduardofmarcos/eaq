package org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.model.editor.Editor;
import org.solidbyte.editeaqui.domain.model.editor.EditorModelBuilder;
import org.solidbyte.editeaqui.domain.model.user.User;
import org.solidbyte.editeaqui.domain.model.user.UserModelBuilder;

import java.util.UUID;

@ApplicationScoped
@AllArgsConstructor
public class EntityUtils {

    private final UserModelBuilder userBuilder;
    private final EditorModelBuilder editorBuilder;

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

    public Editor editor(EditorEntity editorEntity) {
        final UUID id = editorEntity.getId();
        final String name = editorEntity.getName();
        final String email = editorEntity.getEmail();
        final String password = editorEntity.getPassword();
        final String cpf = editorEntity.getCpf();
        final String phone = editorEntity.getPhone();
        final String address = editorEntity.getAddress();
        final String city = editorEntity.getCity();
        final String state = editorEntity.getState();
        final String zip = editorEntity.getZip();
        final String country = editorEntity.getCountry();
        final boolean isActive = editorEntity.isActive();

        return editorBuilder.build(id, name, email, password, cpf, phone, address, city, state, zip, country, isActive);
    }

}

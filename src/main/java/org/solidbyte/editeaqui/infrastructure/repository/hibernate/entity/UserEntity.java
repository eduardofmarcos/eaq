package org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.solidbyte.editeaqui.domain.model.user.User;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    private UUID id;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String address;

    private String city;

    private String state;

    private String country;

    private String zip;

    private boolean isActive;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoEntity> photos;

    public UserEntity(User user) {
        this.id = user.getId();
        update(user);
    }

    //    check this later about password and email;
    public void update(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.city = user.getCity();
        this.state = user.getState();
        this.zip = user.getZip();
        this.country = user.getCountry();
        this.isActive = user.isActive();
    }
}

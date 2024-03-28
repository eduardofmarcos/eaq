package org.solidbyte.editeaqui.application.web.model.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.solidbyte.editeaqui.domain.model.user.User;


@Getter
@Setter
@NoArgsConstructor
@JsonRootName("user")
@RegisterForReflection
public class UserResponse {

    private String name;

    private String email;

    private String phone;

    private String address;

    private String city;

    private String state;

    private String country;

    private String zip;

    private String token;

    public UserResponse(User user, String token) {
       this.name = user.getName();
       this.email = user.getEmail();
       this.phone = user.getPhone();
       this.address = user.getAddress();
       this.city = user.getCity();
       this.state = user.getState();
       this.country= user.getCountry();
       this.zip = user.getZip();
       this.token = token;
    }
}

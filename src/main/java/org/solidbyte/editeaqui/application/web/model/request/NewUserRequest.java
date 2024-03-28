package org.solidbyte.editeaqui.application.web.model.request;


import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.solidbyte.editeaqui.domain.model.user.CreateUserInput;

@Getter
@Setter
@JsonRootName("user")
@RegisterForReflection
public class NewUserRequest {
    private String name;

    private String email;

    private String password;

    private String phone;

    private String address;

    private String city;

    private String state;

    private String country;

    private String zip;

    public CreateUserInput toCreateUserInput() {
        return new CreateUserInput(this.name, this.email, this.password, this.phone, this.address, this.city, this.state, this.country, this.zip, true);
    }
}

package org.solidbyte.editeaqui.application.web.model.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.solidbyte.editeaqui.domain.model.constants.ValidationMessages;
import org.solidbyte.editeaqui.domain.model.user.LoginUserInput;


@Getter
@Setter
@JsonRootName("user")
@RegisterForReflection
public class LoginRequest {

    @NotBlank(message = ValidationMessages.EMAIL_MUST_BE_NOT_BLANK)
    private String email;

    @NotBlank(message = ValidationMessages.PASSWORD_MUST_BE_NOT_BLANK)
    private String password;

    public LoginUserInput toLoginUserInput() {
        return new LoginUserInput(this.email, this.password);
    }
}

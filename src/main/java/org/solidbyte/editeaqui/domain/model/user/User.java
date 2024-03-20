package org.solidbyte.editeaqui.domain.model.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.solidbyte.editeaqui.domain.model.constants.ValidationMessages;


import java.util.UUID;

@Data
@AllArgsConstructor
public class User {

    @NotNull private UUID id;

    @NotBlank(message = ValidationMessages.NAME_MUST_BE_NOT_BLANK)
    private String name;

    @NotBlank(message = ValidationMessages.EMAIL_MUST_BE_NOT_BLANK)
    private String email;

    @NotBlank(message = ValidationMessages.PASSWORD_MUST_BE_NOT_BLANK)
    private String password;

    @NotBlank(message = ValidationMessages.PHONE_MUST_BE_NOT_BLANK)
    private String phone;

    @NotBlank(message = ValidationMessages.ADDRESS_MUST_BE_NOT_BLANK)
    private String address;

    @NotBlank(message = ValidationMessages.CITY_MUST_BE_NOT_BLANK)
    private String city;

    @NotBlank(message = ValidationMessages.STATE_MUST_BE_NOT_BLANK)
    private String state;

    @NotBlank(message = ValidationMessages.ZIP_MUST_BE_NOT_BLANK)
    private String zip;

    @NotBlank(message = ValidationMessages.COUNTRY_MUST_BE_NOT_BLANK)
    private String country;

}

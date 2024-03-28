package org.solidbyte.editeaqui.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UpdateUserInput {
    private UUID id;
    private String name;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
}

package org.solidbyte.editeaqui.domain.model.editor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateEditorInput {
    private String name;
    private String email;
    private String password;
    private String cpf;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private boolean isActive;
}

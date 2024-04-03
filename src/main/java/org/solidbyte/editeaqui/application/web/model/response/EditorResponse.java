package org.solidbyte.editeaqui.application.web.model.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.solidbyte.editeaqui.domain.model.editor.Editor;


@Getter
@Setter
@NoArgsConstructor
@JsonRootName("editor")
@RegisterForReflection
public class EditorResponse {

    private String name;

    private String email;

    private String cpf;

    private String phone;

    private String address;

    private String city;

    private String state;

    private String country;

    private String zip;

    private String token;

    public EditorResponse(Editor editor, String token) {
        this.name = editor.getName();
        this.email = editor.getEmail();
        this.cpf = editor.getCpf();
        this.phone = editor.getPhone();
        this.address = editor.getAddress();
        this.city = editor.getCity();
        this.state = editor.getState();
        this.country = editor.getCountry();
        this.zip = editor.getZip();
        this.token = token;
    }
}

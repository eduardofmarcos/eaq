package org.solidbyte.editeaqui.application.web.model.request;


import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.solidbyte.editeaqui.domain.model.editor.CreateEditorInput;

@Getter
@Setter
@JsonRootName("editor")
@RegisterForReflection
public class NewEditorRequest {
    private String name;

    private String email;

    private String password;

    private String cpf;

    private String phone;

    private String address;

    private String city;

    private String state;

    private String country;

    private String zip;

    public CreateEditorInput toCreateEditorInput() {
        return new CreateEditorInput(this.name, this.email, this.password, this.cpf, this.phone, this.address, this.city, this.state, this.country, this.zip, true);
    }
}

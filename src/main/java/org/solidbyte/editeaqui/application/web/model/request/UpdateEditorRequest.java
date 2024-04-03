package org.solidbyte.editeaqui.application.web.model.request;


import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.solidbyte.editeaqui.domain.model.constants.ValidationMessages;
import org.solidbyte.editeaqui.domain.model.editor.UpdateEditorInput;

import java.util.UUID;

@Getter
@Setter
@JsonRootName("editor")
//@AtLeastOneFieldMustBeNotNull
@RegisterForReflection
public class UpdateEditorRequest {

    @Pattern(regexp = "\\A(?!\\s*\\Z).+", message = ValidationMessages.NAME_MUST_BE_NOT_BLANK)
    private String name;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;

    public UpdateEditorInput toUpdateEditorInput(UUID editorId) {
        return new UpdateEditorInput(editorId, this.name, this.phone, this.address, this.city, this.state, this.zip, this.country);
    }
}
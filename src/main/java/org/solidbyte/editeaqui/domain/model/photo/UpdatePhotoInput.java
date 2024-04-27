package org.solidbyte.editeaqui.domain.model.photo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.solidbyte.editeaqui.domain.model.user.User;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UpdatePhotoInput {
    private String description;
    private String filename;
    private boolean isEdited;
    private boolean isEditing;
    private boolean isPaid;
    private String transactionalId;
}

package org.solidbyte.editeaqui.domain.model.photo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.solidbyte.editeaqui.domain.model.editor.Editor;
import org.solidbyte.editeaqui.domain.model.user.User;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreatePhotoInput {
    private UUID user;
    private UUID editor;
    private String bucket;
    private boolean isPublished;
    private String description;
    private String filename;
    private boolean isEdited;
    private boolean isEditing;
    private boolean isPaid;
    private double price;
    private String transactionalId;
}

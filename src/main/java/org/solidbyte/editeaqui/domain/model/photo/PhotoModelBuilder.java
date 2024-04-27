package org.solidbyte.editeaqui.domain.model.photo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.model.editor.Editor;
import org.solidbyte.editeaqui.domain.model.user.User;
import org.solidbyte.editeaqui.domain.validator.ModelValidator;

import java.util.UUID;

@Named
@AllArgsConstructor
@ApplicationScoped
public class PhotoModelBuilder {

    private final ModelValidator modelValidator;

    // constructor overload differentiate by id, if there is "id" is an update operation if not, it is a creation operation
    public Photo build(UUID id,UUID user,UUID editor,String bucket,boolean isPublished,String description,String filename,boolean isEdited,boolean isEditing,boolean isPaid,double price,String transactionalId) {
        return modelValidator.validate(new Photo(id, user, editor, bucket, isPublished, description, filename, isEdited, isEditing, isPaid, price,transactionalId));
    }

    public Photo build(UUID user,UUID editor,String bucket,boolean isPublished,String description,String filename,boolean isEdited,boolean isEditing,boolean isPaid,double price,String transactionalId) {
        return modelValidator.validate(new Photo(UUID.randomUUID(), user, editor, bucket, isPublished, description, filename, isEdited, isEditing, isPaid, price,transactionalId));
    }

}

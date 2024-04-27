package org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.solidbyte.editeaqui.domain.model.editor.Editor;
import org.solidbyte.editeaqui.domain.model.photo.Photo;
import org.solidbyte.editeaqui.domain.model.user.User;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PHOTOS")
public class PhotoEntity {
    @Id
    private UUID id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "editor_id")
    private EditorEntity editor;


    private String bucket;


    private boolean isPublished;


    private String description;


    private String filename;


    private boolean isEdited;


    private boolean isEditing;


    private boolean isPaid;


    private double price;

    private String transactionalId;

    public PhotoEntity(Photo photo) {
        this.id = photo.getId();
        update(photo);
    }

    public void update(Photo photo) {
        this.description = photo.getDescription();
        this.filename = photo.getFilename();
        this.isEdited = photo.isEdited();
        this.isEditing = photo.isEditing();
        this.isPaid = photo.isPaid();
        this.transactionalId = photo.getTransactionalId();
    }

}

package org.solidbyte.photo.repository.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.solidbyte.editor.repository.entity.EditorEntity;
import org.solidbyte.repository.user.entity.UserEntity;

@Entity(name = "photos")
public class PhotoEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "clientId", referencedColumnName = "id")
    public UserEntity user;

    @ManyToOne
    @JoinColumn(name = "editorId", referencedColumnName = "id")
    public EditorEntity editor;

    @Column
    public String bucket;

    @Column
    public boolean published;

    @Column
    public String description;

    @Column
    public String filename;

    @Column
    public boolean isEdited;

    @Column
    public boolean isEditing;

    @Column
    public boolean isPaid = false;

    @Column
    public double price;

    @Column(nullable = true)
    public String transactionId;
}

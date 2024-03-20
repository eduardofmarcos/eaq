package org.solidbyte.editor.repository.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.solidbyte.photo.repository.entity.PhotoEntity;

import java.util.List;

@Entity(name = "editors")
public class EditorEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column
    public String name;

    @Column
    public String email;

    @Column
    public String password;

    @Column
    public String cpf;

    @Column
    public String phone;

    @Column
    public String address;

    @Column
    public String city;

    @Column
    public String state;

    @Column
    public String zip;

    @Column
    public String country;

    @Column
    public boolean isWorking = false;

    @OneToMany(mappedBy = "editor", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<PhotoEntity> photos;
}

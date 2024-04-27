package org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.solidbyte.editeaqui.domain.model.editor.Editor;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EDITORS")
public class EditorEntity {
    @Id
    private UUID id;

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

    private boolean isActive;

    @OneToMany(mappedBy = "editor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoEntity> photos;


    public EditorEntity(Editor editor) {
        this.id = editor.getId();
        update(editor);
    }

    //    check this later about password and email;
    public void update(Editor editor) {
        this.name = editor.getName();
        this.email = editor.getEmail();
        this.password = editor.getPassword();
        this.cpf = editor.getCpf();
        this.phone = editor.getPhone();
        this.address = editor.getAddress();
        this.city = editor.getCity();
        this.state = editor.getState();
        this.zip = editor.getZip();
        this.country = editor.getCountry();
        this.isActive = editor.isActive();
    }
}
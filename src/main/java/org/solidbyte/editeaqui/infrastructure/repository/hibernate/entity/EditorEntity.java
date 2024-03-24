package org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "EDITORS")
public class EditorEntity {
    @Id
    private UUID id;
}

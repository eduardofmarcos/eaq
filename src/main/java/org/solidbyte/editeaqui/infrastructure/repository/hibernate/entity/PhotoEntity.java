package org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PHOTOS")
public class PhotoEntity {
}

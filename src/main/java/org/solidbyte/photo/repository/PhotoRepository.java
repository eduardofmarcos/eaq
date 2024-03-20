package org.solidbyte.photo.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.solidbyte.photo.repository.entity.PhotoEntity;

public class PhotoRepository implements PanacheRepository<PhotoEntity> {
}

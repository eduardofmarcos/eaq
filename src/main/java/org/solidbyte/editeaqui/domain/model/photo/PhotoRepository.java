package org.solidbyte.editeaqui.domain.model.photo;

import org.solidbyte.editeaqui.domain.model.editor.Editor;

import java.util.Optional;
import java.util.UUID;

public interface PhotoRepository {

    void save(Photo photo);

    boolean existsBy(String field, String value);

    Optional<Photo> findPhotoById(UUID id);

    void update(Photo photo);

}

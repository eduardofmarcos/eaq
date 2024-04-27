package org.solidbyte.editeaqui.infrastructure.repository.hibernate.panache;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.model.editor.Editor;
import org.solidbyte.editeaqui.domain.model.editor.EditorRepository;
import org.solidbyte.editeaqui.domain.model.photo.Photo;
import org.solidbyte.editeaqui.domain.model.photo.PhotoRepository;
import org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity.EditorEntity;
import org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity.EntityUtils;
import org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity.PhotoEntity;

import java.util.Optional;
import java.util.UUID;

import static io.quarkus.panache.common.Parameters.with;
@ApplicationScoped
@AllArgsConstructor
public class PhotoRepositoryPanache extends AbstractPanacheRepository<PhotoEntity, UUID>
        implements PhotoRepository {
        private final EntityUtils entityUtils;

        @Override
        public void save(Photo photo) {
            persist(new PhotoEntity(photo));
        }

        @Override
        public boolean existsBy(String field, String value) {
            return count("upper(" + field + ")", value.toUpperCase().trim()) > 0;
        }

        @Override
        public Optional<Photo> findPhotoById(UUID id) {
            return findByIdOptional(id).map(entityUtils::photo);
        }
        @Override
        public void update(Photo photo) {
            final UUID id = UUID.fromString("73c660cb-e0cc-4720-9459-ec17202f72c4");

            final UUID idTest = photo.getId();
            final PhotoEntity photoEntity = findById(idTest);
            photoEntity.update(photo);
        }


}

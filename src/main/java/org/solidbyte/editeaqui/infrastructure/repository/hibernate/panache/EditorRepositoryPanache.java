package org.solidbyte.editeaqui.infrastructure.repository.hibernate.panache;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.model.editor.Editor;
import org.solidbyte.editeaqui.domain.model.editor.EditorRepository;
import org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity.EditorEntity;
import org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity.EntityUtils;

import java.util.Optional;
import java.util.UUID;

import static io.quarkus.panache.common.Parameters.with;

@ApplicationScoped
@AllArgsConstructor
public class EditorRepositoryPanache extends AbstractPanacheRepository<EditorEntity, UUID>
        implements EditorRepository {

    private final EntityUtils entityUtils;

    @Override
    public void save(Editor editor) {
        persist(new EditorEntity(editor));
    }

    @Override
    public boolean existsBy(String field, String value) {
        return count("upper(" + field + ")", value.toUpperCase().trim()) > 0;
    }

    @Override
    public Optional<Editor> findByEmail(String email) {
        return find("upper(email)", email.toUpperCase().trim())
                .firstResultOptional()
                .map(entityUtils::editor);
    }

    @Override
    public Optional<Editor> findEditorById(UUID id) {
        Optional<Editor> editor = findByIdOptional(id).map(entityUtils::editor);
        return editor;
    }

    @Override
    public boolean existsEmail(UUID excludeId, String email) {
        return count(
                "id != :excludeId and upper(email) = :email",
                with("excludeId", excludeId).and("email", email.toUpperCase().trim()))
                > 0;
    }

    @Override
    public void update(Editor editor) {
        final UUID id = UUID.fromString("73c660cb-e0cc-4720-9459-ec17202f72c4");

        final UUID idTest = editor.getId();
        final EditorEntity editorEntity = findById(idTest);
        editorEntity.update(editor);
    }


    @Override
    public Optional<Editor> findByEditorName(String editorname) {
        return find("upper(editorName)", editorname.toUpperCase().trim())
                .firstResultOptional()
                .map(entityUtils::editor);
    }
}

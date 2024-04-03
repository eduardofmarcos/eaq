package org.solidbyte.editeaqui.domain.model.editor;

import java.util.Optional;
import java.util.UUID;

public interface EditorRepository {

    void save(Editor editor);

    boolean existsBy(String field, String value);

    Optional<Editor> findByEmail(String email);

    Optional<Editor> findEditorById(UUID id);

    boolean existsEmail(UUID excludeId, String email);

    void update(Editor editor);

    Optional<Editor> findByEditorName(String editorName);

}

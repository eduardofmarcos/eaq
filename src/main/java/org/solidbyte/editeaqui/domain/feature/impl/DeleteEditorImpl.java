package org.solidbyte.editeaqui.domain.feature.impl;


import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.feature.DeleteEditor;
import org.solidbyte.editeaqui.domain.feature.FindEditorById;
import org.solidbyte.editeaqui.domain.model.editor.Editor;
import org.solidbyte.editeaqui.domain.model.editor.EditorRepository;
import org.solidbyte.editeaqui.domain.validator.ModelValidator;

import java.util.UUID;

@AllArgsConstructor
@ApplicationScoped
public class DeleteEditorImpl implements DeleteEditor {

    private final FindEditorById findEditorById;
    private final EditorRepository editorRepository;
    private final ModelValidator modelValidator;

    @Override
    public Editor handle(UUID uuid) {
        final Editor editor = findEditorById.handle(uuid);
        updateFields(editor);
        editorRepository.update(modelValidator.validate(editor));
        return null;
    }

    private void updateFields(Editor editor) {
        editor.setActive(false);
    }
}

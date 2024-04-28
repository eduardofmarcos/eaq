package org.solidbyte.editeaqui.domain.feature.impl;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.exception.EditorNotFoundException;
import org.solidbyte.editeaqui.domain.exception.UserNotFoundException;
import org.solidbyte.editeaqui.domain.feature.FindEditorById;
import org.solidbyte.editeaqui.domain.model.editor.Editor;
import org.solidbyte.editeaqui.domain.model.editor.EditorRepository;

import java.util.UUID;

@AllArgsConstructor
@ApplicationScoped
public class FindEditorByIdImpl implements FindEditorById {

    private final EditorRepository editorRepository;

    @Override
    public Editor handle(UUID id) {
        Editor editor = editorRepository.findEditorById(id).orElseThrow(EditorNotFoundException::new);
        return editor;
    }
}

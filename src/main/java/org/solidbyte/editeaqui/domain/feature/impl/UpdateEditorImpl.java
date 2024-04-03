package org.solidbyte.editeaqui.domain.feature.impl;


import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.feature.FindEditorById;
import org.solidbyte.editeaqui.domain.feature.UpdateEditor;
import org.solidbyte.editeaqui.domain.model.editor.Editor;
import org.solidbyte.editeaqui.domain.model.editor.EditorRepository;
import org.solidbyte.editeaqui.domain.model.editor.UpdateEditorInput;
import org.solidbyte.editeaqui.domain.validator.ModelValidator;

@AllArgsConstructor
@ApplicationScoped
public class UpdateEditorImpl implements UpdateEditor {

    private final FindEditorById findEditorById;
    private final EditorRepository editorRepository;
    private final ModelValidator modelValidator;

    @Override
    public Editor handle(UpdateEditorInput updateEditorInput) {
        final Editor editor = findEditorById.handle(updateEditorInput.getId());

        updateFields(editor, updateEditorInput);
        editorRepository.update(modelValidator.validate(editor));
        return editor;
    }

    private void updateFields(Editor editor, UpdateEditorInput updateEditorInput) {

        if (isPresent(updateEditorInput.getName())) {
            editor.setName(updateEditorInput.getName());
        }

        if (isPresent(updateEditorInput.getPhone())) {
            editor.setPhone(updateEditorInput.getPhone());
        }

        if (isPresent(updateEditorInput.getAddress())) {
            editor.setAddress(updateEditorInput.getAddress());
        }

        if (isPresent(updateEditorInput.getCity())) {
            editor.setCity(updateEditorInput.getCity());
        }

        if (isPresent(updateEditorInput.getState())) {
            editor.setState(updateEditorInput.getState());
        }

        if (isPresent(updateEditorInput.getZip())) {
            editor.setZip(updateEditorInput.getZip());
        }

        if (isPresent(updateEditorInput.getCountry())) {
            editor.setCountry(updateEditorInput.getCountry());
        }

    }

    private boolean isPresent(String property) {
        return property != null && !property.isEmpty();
    }

}

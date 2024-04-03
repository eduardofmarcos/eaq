package org.solidbyte.editeaqui.domain.feature.impl;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.domain.exception.EmailAlreadyExistsException;
import org.solidbyte.editeaqui.domain.feature.CreateEditor;
import org.solidbyte.editeaqui.domain.model.editor.CreateEditorInput;
import org.solidbyte.editeaqui.domain.model.editor.Editor;
import org.solidbyte.editeaqui.domain.model.editor.EditorModelBuilder;
import org.solidbyte.editeaqui.domain.model.editor.EditorRepository;

@AllArgsConstructor
@ApplicationScoped
public class CreateEditorImpl implements CreateEditor {

    private final EditorRepository editorRepository;
    private final EditorModelBuilder editorBuilder;

    @Override
    public Editor handle(CreateEditorInput createEditorInput) {
        final Editor editor =
                editorBuilder.build(
                        createEditorInput.getName(),
                        createEditorInput.getEmail(),
                        createEditorInput.getPassword(),
                        createEditorInput.getCpf(),
                        createEditorInput.getPhone(),
                        createEditorInput.getAddress(),
                        createEditorInput.getCity(),
                        createEditorInput.getState(),
                        createEditorInput.getZip(),
                        createEditorInput.getCountry(),
                        createEditorInput.isActive());

        checkExistingEmail(editor.getEmail());
        editorRepository.save(editor);
        return editor;
    }

    private void checkExistingEmail(String email) {
        if (editorRepository.existsBy("email", email)) {
            throw new EmailAlreadyExistsException();
        }
    }

}

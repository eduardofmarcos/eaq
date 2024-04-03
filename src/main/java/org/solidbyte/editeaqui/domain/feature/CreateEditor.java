package org.solidbyte.editeaqui.domain.feature;


import org.solidbyte.editeaqui.domain.model.editor.CreateEditorInput;
import org.solidbyte.editeaqui.domain.model.editor.Editor;

public interface CreateEditor {
    Editor handle(CreateEditorInput createEditorInput);
}

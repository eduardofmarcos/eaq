package org.solidbyte.editeaqui.domain.feature;

import org.solidbyte.editeaqui.domain.model.editor.Editor;
import org.solidbyte.editeaqui.domain.model.editor.UpdateEditorInput;

public interface UpdateEditor {
    Editor handle(UpdateEditorInput updateEditorInput);
}

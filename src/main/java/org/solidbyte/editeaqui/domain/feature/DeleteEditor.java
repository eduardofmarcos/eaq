package org.solidbyte.editeaqui.domain.feature;


import org.solidbyte.editeaqui.domain.model.editor.Editor;

import java.util.UUID;

public interface DeleteEditor {
    Editor handle(UUID uuid);
}

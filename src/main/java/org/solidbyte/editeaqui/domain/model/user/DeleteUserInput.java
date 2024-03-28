package org.solidbyte.editeaqui.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class DeleteUserInput {
    private UUID id;
    private boolean isActive;
}

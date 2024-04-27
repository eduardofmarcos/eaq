package org.solidbyte.editeaqui.domain.model.photo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.solidbyte.editeaqui.domain.model.constants.ValidationMessages;
import org.solidbyte.editeaqui.domain.model.editor.Editor;
import org.solidbyte.editeaqui.domain.model.user.User;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Photo {
    @NotNull
    private UUID id;

    private UUID user;

    private UUID editor;

    private String bucket;

    private boolean isPublished;

    @NotBlank(message = ValidationMessages.DESCRIPTION_MUST_BE_NOT_BLANK)
    private String description;

    @NotBlank(message = ValidationMessages.FILENAME_MUST_BE_NOT_BLANK)
    private String filename;

    private boolean isEdited;

    private boolean isEditing;

    private boolean isPaid;

    @NotBlank(message = ValidationMessages.PRICE_MUST_BE_NOT_BLANK)
    @NotNull
    private double price;

    private String transactionalId;

}
/**
 * @Entity() export class Photo {
 * @PrimaryGeneratedColumn() id: number;
 * @ManyToOne(() => Client, { onDelete: 'CASCADE' })
 * @JoinColumn({ name: 'clientId' })
 * client: Client;
 * @ManyToOne(() => Editor)
 * @JoinColumn({ name: 'editorId' })
 * editor: Editor;
 * @Column() bucket: string;
 * @Column() published: boolean;
 * @Column() description: string;
 * @Column() filename: string;
 * @Column() isEdited: boolean;
 * @Column() isEditing: boolean;
 * @Column('boolean', { default: false })
 * isPaid: boolean;
 * @Column() price: number;
 * @Column({ default: null, nullable: true })
 * transactionId: string;
 * }
 */

package org.solidbyte.editeaqui.application.web.resource;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.application.web.model.request.UpdateEditorRequest;
import org.solidbyte.editeaqui.application.web.model.response.EditorResponse;
import org.solidbyte.editeaqui.domain.feature.DeleteEditor;
import org.solidbyte.editeaqui.domain.feature.FindEditorById;
import org.solidbyte.editeaqui.domain.feature.UpdateEditor;
import org.solidbyte.editeaqui.domain.model.constants.ValidationMessages;
import org.solidbyte.editeaqui.domain.model.editor.Editor;

import java.util.UUID;

@Path("editor")
@AllArgsConstructor
public class EditorResource {

    private final FindEditorById findEditorById;
    private final UpdateEditor updateEditor;
    private final DeleteEditor deleteEditor;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response read() {
        final UUID editorID = UUID.fromString("82587421-677f-4c58-901c-8db19c6e1bc0");
        final Editor editor = findEditorById.handle(editorID);
        return Response.ok(new EditorResponse(editor, "mock-token-value")).status(Response.Status.OK).build();
    }


    @PATCH
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(
            @Valid @NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL)
            UpdateEditorRequest updateEditorRequest) {
        final UUID editorID = UUID.fromString("82587421-677f-4c58-901c-8db19c6e1bc0");
        final Editor editor = updateEditor.handle(updateEditorRequest.toUpdateEditorInput(editorID));
        return Response.ok(new EditorResponse(editor, "token-mock-value")).status(Response.Status.OK).build();
    }

    @DELETE
    @Transactional
    public Response delete() {

        final UUID editorID = UUID.fromString("82587421-677f-4c58-901c-8db19c6ebc0");
        deleteEditor.handle(editorID);

        return Response.ok().status(Response.Status.NO_CONTENT).build();
    }

}

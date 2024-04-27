package org.solidbyte.editeaqui.application.web.resource;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.application.web.model.request.NewEditorRequest;
import org.solidbyte.editeaqui.application.web.model.response.EditorResponse;
import org.solidbyte.editeaqui.domain.feature.CreateEditor;
import org.solidbyte.editeaqui.domain.model.constants.ValidationMessages;
import org.solidbyte.editeaqui.domain.model.editor.Editor;


@Path("editors")
@AllArgsConstructor
public class EditorsResource {

    private final CreateEditor createEditor;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(
            @Valid @NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL) NewEditorRequest newEditorRequest) {
        final Editor editor = createEditor.handle(newEditorRequest.toCreateEditorInput());
        return Response.ok(new EditorResponse(editor, "token-mock-value")).status(Response.Status.CREATED).build();
    }


//    @POST
//    @Path("/login")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response login(
//            @Valid @NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL)
//            LoginRequest loginRequest) {
//        User user;
//        try {
////            user = loginUser.handle(loginRequest.toLoginUserInput());
//        } catch (UserNotFoundException | InvalidPasswordException ex) {
//            throw new UnauthorizedException();
//        }
//        return Response.ok(new UserResponse("user", "token-mock-value")).status(Response.Status.OK).build();
//    }

}
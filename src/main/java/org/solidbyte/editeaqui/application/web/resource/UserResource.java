package org.solidbyte.editeaqui.application.web.resource;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.application.web.model.request.UpdateUserRequest;
import org.solidbyte.editeaqui.application.web.model.response.UserResponse;
import org.solidbyte.editeaqui.domain.feature.DeleteUser;
import org.solidbyte.editeaqui.domain.feature.FindUserById;
import org.solidbyte.editeaqui.domain.feature.UpdateUser;
import org.solidbyte.editeaqui.domain.model.constants.ValidationMessages;
import org.solidbyte.editeaqui.domain.model.user.User;

import java.util.UUID;

@Path("user")
@AllArgsConstructor
public class UserResource {

    private final FindUserById findUserById;
    private final UpdateUser updateUser;
    private final DeleteUser deleteUser;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response read() {
        final UUID userID = UUID.fromString("82587421-677f-4c58-901c-8db19c6e1bc0");
        final User user = findUserById.handle(userID);
        return Response.ok(new UserResponse(user, "mock-token-value")).status(Response.Status.OK).build();
    }


    @PATCH
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(
            @Valid @NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL)
            UpdateUserRequest updateUserRequest) {
        final UUID userID = UUID.fromString("82587421-677f-4c58-901c-8db19c6e1bc0");
        final User user = updateUser.handle(updateUserRequest.toUpdateUserInput(userID));
        return Response.ok(new UserResponse(user, "token-mock-value")).status(Response.Status.OK).build();
    }

    @DELETE
    @Transactional
    public Response delete() {

        final UUID userID = UUID.fromString("82587421-677f-4c58-901c-8db19c6ebc0");
        deleteUser.handle(userID);

        return Response.ok().status(Response.Status.NO_CONTENT).build();
    }

}

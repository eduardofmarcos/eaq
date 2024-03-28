package org.solidbyte.editeaqui.application.web.resource;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.application.web.model.request.UpdateUserRequest;
import org.solidbyte.editeaqui.application.web.model.response.UserResponse;
import org.solidbyte.editeaqui.domain.feature.DeleteUser;
import org.solidbyte.editeaqui.domain.feature.FindUserById;
import org.solidbyte.editeaqui.domain.feature.UpdateUser;
import org.solidbyte.editeaqui.domain.model.constants.ValidationMessages;
import org.solidbyte.editeaqui.infrastructure.web.provider.TokenProvider;
import org.solidbyte.editeaqui.infrastructure.web.security.annotation.Secured;
import org.solidbyte.editeaqui.infrastructure.web.security.profile.Role;

import java.util.UUID;

@Path("users")
@AllArgsConstructor
public class UserResource {

    private final FindUserById findUserById;
    private final UpdateUser updateUser;
    private final DeleteUser deleteUser;
    private final TokenProvider tokenProvider;


    @GET
    @Secured({Role.ADMIN,Role.USER})
    @Produces(MediaType.APPLICATION_JSON)
    public Response read(@Context SecurityContext securityContext) {
        final var userId = UUID.fromString(securityContext.getUserPrincipal().getName());
        System.out.println(userId);
        final var userID = UUID.fromString("82587421-677f-4c58-901c-8db19c6e1bc0");
        final var user = findUserById.handle(userID);
        final var token = tokenProvider.createUserToken(user.getId().toString());
        return Response.ok(new UserResponse(user,token)).status(Response.Status.OK).build();
    }


    @PATCH
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(
            @Valid @NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL)
            UpdateUserRequest updateUserRequest) {
//        final var userId = UUID.fromString(securityContext.getUserPrincipal().getName());
        final var userID = UUID.fromString("82587421-677f-4c58-901c-8db19c6e1bc0");
        final var user = updateUser.handle(updateUserRequest.toUpdateUserInput(userID));
//        final var token = tokenProvider.createUserToken(user.getId().toString());
        return Response.ok(user).status(Response.Status.OK).build();
    }

    @DELETE
    @Transactional
    public Response delete() {
//        final var userId = UUID.fromString(securityContext.getUserPrincipal().getName());
        final var userID = UUID.fromString("82587421-677f-4c58-901c-8db19c6e1bc0");
        final var user = deleteUser.handle(userID);
//        final var token = tokenProvider.createUserToken(user.getId().toString());
        return Response.ok(user).status(Response.Status.NO_CONTENT).build();
    }

}

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
import org.solidbyte.editeaqui.application.web.model.request.NewUserRequest;

import org.solidbyte.editeaqui.domain.feature.CreateUser;
import org.solidbyte.editeaqui.domain.model.constants.ValidationMessages;

@Path("users")
@AllArgsConstructor
public class UsersResource {

    private final CreateUser createUser;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(
            @Valid @NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL) NewUserRequest newUserRequest){
        final var user = createUser.handle(newUserRequest.toCreateUserInput());
        return Response.ok(user).status(Response.Status.CREATED).build();
    }
}
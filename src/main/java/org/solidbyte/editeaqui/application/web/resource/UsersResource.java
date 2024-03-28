package org.solidbyte.editeaqui.application.web.resource;

import io.quarkus.security.UnauthorizedException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import org.solidbyte.editeaqui.application.web.model.request.LoginRequest;
import org.solidbyte.editeaqui.application.web.model.request.NewUserRequest;
import org.solidbyte.editeaqui.application.web.model.response.UserResponse;
import org.solidbyte.editeaqui.domain.exception.InvalidPasswordException;
import org.solidbyte.editeaqui.domain.exception.UserNotFoundException;
import org.solidbyte.editeaqui.domain.feature.CreateUser;
import org.solidbyte.editeaqui.domain.feature.LoginUser;
import org.solidbyte.editeaqui.domain.model.constants.ValidationMessages;
import org.solidbyte.editeaqui.domain.model.user.LoginUserInput;
import org.solidbyte.editeaqui.domain.model.user.User;
import org.solidbyte.editeaqui.infrastructure.web.provider.TokenProvider;

@Path("users")
@AllArgsConstructor
public class UsersResource {

    private final CreateUser createUser;
    private final TokenProvider tokenProvider;
    private final LoginUser loginUser;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(
            @Valid @NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL) NewUserRequest newUserRequest) {
        final var user = createUser.handle(newUserRequest.toCreateUserInput());
        final var token = tokenProvider.createUserToken(user.getId().toString());
        return Response.ok(new UserResponse(user, token)).status(Response.Status.CREATED).build();
    }


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(
            @Valid @NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL)
            LoginRequest loginRequest) {
        User user;
        try {
            user = loginUser.handle(loginRequest.toLoginUserInput());
        } catch (UserNotFoundException | InvalidPasswordException ex) {
            throw new UnauthorizedException();
        }
        final var token = tokenProvider.createUserToken(user.getId().toString());
        return Response.ok(new UserResponse(user, token)).status(Response.Status.OK).build();
    }

}
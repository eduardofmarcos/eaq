package org.solidbyte.editeaqui.application.web.resource;

import io.quarkus.security.UnauthorizedException;
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
import org.solidbyte.editeaqui.application.web.model.response.UserResponse;

import org.solidbyte.editeaqui.domain.feature.CreateUser;
import org.solidbyte.editeaqui.domain.model.constants.ValidationMessages;
import org.solidbyte.editeaqui.domain.model.user.User;


@Path("users")
@AllArgsConstructor
public class UsersResource {

    private final CreateUser createUser;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(
            @Valid @NotNull(message = ValidationMessages.REQUEST_BODY_MUST_BE_NOT_NULL) NewUserRequest newUserRequest) {
        final User user = createUser.handle(newUserRequest.toCreateUserInput());
        return Response.ok(new UserResponse(user, "token-mock-value")).status(Response.Status.CREATED).build();
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
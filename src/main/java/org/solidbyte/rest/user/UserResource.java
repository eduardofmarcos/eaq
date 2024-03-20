package org.solidbyte.rest.user;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.solidbyte.dto.user.UpdateUserDto;
import org.solidbyte.mapping.user.UserPartialUpdateMapper;
import org.solidbyte.repository.user.entity.UserEntity;
import org.solidbyte.service.user.UsersService;

import java.util.List;

@Path("/api/v1/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UsersService usersService;

    @GET
    public List<UserEntity> getAllUsers() {
        return usersService.findAllUsers();
    }

    @GET
    @Path("/{id}")
    public UserEntity getUserById(@PathParam("id") Long id) {
        return usersService.findUserById(id);
    }

    @POST
    public void createUser(UserEntity user) {
        usersService.persistUser(user);
    }

    @PATCH
    public UserEntity partialUpdateUser(UserEntity user) {
        return usersService.partialUpdateUser(user);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUserById(@PathParam("id") Long id) {
        usersService.deleteUser(id);
    }
}


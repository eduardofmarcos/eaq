package org.solidbyte.service.user;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.NotFoundException;
import org.solidbyte.dto.user.UpdateUserDto;
import org.solidbyte.mapping.user.UserFullUpdateMapper;
import org.solidbyte.mapping.user.UserPartialUpdateMapper;
import org.solidbyte.repository.user.UserRepository;
import org.solidbyte.repository.user.entity.UserEntity;

import java.util.List;

/**
 * Service class containing business methods for managing users.
 */
@ApplicationScoped
public class UsersService {
    private final UserRepository userRepository;
    private final UserPartialUpdateMapper userPartialUpdateMapper;


    public UsersService(UserRepository userRepository, UserPartialUpdateMapper userPartialUpdateMapper) {
        this.userRepository = userRepository;
        this.userPartialUpdateMapper = userPartialUpdateMapper;
    }

    @WithSpan("UserService.findAllUsers")
    @Transactional
    public List<UserEntity> findAllUsers() {
        Log.debug("Getting all users");
        return this.userRepository.listAll();
    }

    @WithSpan("UserService.findUserById")
    @Transactional
    public UserEntity findUserById(Long id) {
        Log.debugf("Finding user by id = %d", id);
        UserEntity user = this.userRepository.findById(id);
        if (user == null) {
            throw new NotFoundException("User not found with id: " + id);
        }
        return user;
    }

    @WithSpan("UserService.persistUser")
    @Transactional
    public void persistUser(UserEntity user) {
        Log.debugf("Persisting user: %s", user);
        this.userRepository.persist(user);
    }

    @WithSpan("UserService.partialUpdateUser")
    @Transactional
    public UserEntity partialUpdateUser(UserEntity user) {
        Log.infof("Partially updating user with id: %s", user.getId());
        UserEntity updatedUser = this.userRepository.findById(user.getId());
        if (updatedUser == null) {
            throw new NotFoundException("User not found with id: " + user.getId());
        }
        this.userPartialUpdateMapper.mapPartialUpdate(user, updatedUser);
        return updatedUser;
    }

    @WithSpan("UserService.deleteUser")
    @Transactional
    public void deleteUser(Long id) {
        Log.debugf("Deleting user by id = %d", id);
        UserEntity user = this.userRepository.findById(id);
        if (user == null) {
            throw new NotFoundException("User not found with id: " + id);
        }
        this.userRepository.deleteById(id);
    }

}

package org.solidbyte.mapping.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.solidbyte.repository.user.entity.UserEntity;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;


/**
 * Mapper to map <code><strong>non-null</strong></code> fields on an input {@link UserEntity} onto a target {@link UserEntity}.
 */
@Mapper(componentModel = "jakarta", nullValuePropertyMappingStrategy = IGNORE)
public interface UserPartialUpdateMapper {
    /**
     * Maps all fields except <code>id</code> from {@code input} onto {@code target}.
     * @param input The input {@link UserEntity}
     * @param target The target {@link UserEntity}
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "email", ignore = true)
    void mapPartialUpdate(UserEntity input, @MappingTarget UserEntity target);
}
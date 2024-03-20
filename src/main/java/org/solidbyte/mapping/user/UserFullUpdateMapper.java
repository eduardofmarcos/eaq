package org.solidbyte.mapping.user;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.solidbyte.repository.user.entity.UserEntity;


/**
 * Mapper to map all fields on an input {@link UserEntity} onto a target {@link UserEntity}.
 */

@Mapper(componentModel = "jakarta")
public interface UserFullUpdateMapper {
    /**
     * Maps all fields except <code>id</code> from {@code input} onto {@code target}.
     * @param input The input {@link UserEntity}
     * @param target The target {@link UserEntity}
     */
    @Mapping(target = "id", ignore = true)
    void mapFullUpdate(UserEntity input, @MappingTarget UserEntity target);
}

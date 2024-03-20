package org.solidbyte.editeaqui.infrastructure.repository.hibernate.panache;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.solidbyte.editeaqui.infrastructure.repository.hibernate.entity.UserEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AbstractPanacheRepository<ENTITY, ID> implements PanacheRepositoryBase<ENTITY, ID> {

    protected UserEntity findUserEntityById(UUID id) {
        return getEntityManager().find(UserEntity.class, id);
    }


//    protected FavoriteRelationshipEntity findFavoriteRelationshipEntityByKey(
//            FavoriteRelationship favoriteRelationship) {
//
//        final var userEntity = findUserEntityById(favoriteRelationship.getUser().getId());
//        final var articleEntity = findArticleEntityById(favoriteRelationship.getArticle().getId());
//
//        final var favoriteRelationshipEntityKey = new FavoriteRelationshipEntityKey();
//        favoriteRelationshipEntityKey.setUser(userEntity);
//        favoriteRelationshipEntityKey.setArticle(articleEntity);
//
//        return getEntityManager().find(FavoriteRelationshipEntity.class, favoriteRelationshipEntityKey);
//    }

    protected boolean isNotEmpty(List<?> list) {
        return list != null && !list.isEmpty();
    }

    protected List<String> toUpperCase(List<String> subjectList) {
        return subjectList.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}

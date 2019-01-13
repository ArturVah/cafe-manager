package am.artyshok.mapper;

import am.artyshok.dto.User;
import am.artyshok.entity.UserEntity;
import am.artyshok.security.domain.UserPrincipal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,componentModel = "spring")
public interface UserMapper {
    UserEntity map(User user);

    User map(UserEntity userEntity);

    void updateUserEntity(User user,@MappingTarget UserEntity userEntity);

    UserPrincipal mapToPrincipal(UserEntity userEntity); 
}

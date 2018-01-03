package org.melsif.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.melsif.dto.UserDto;
import org.melsif.model.Security.Account;
import org.melsif.model.User;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "user.matricule", target = "matricule"),
            @Mapping(source = "user.firstName", target = "firstName"),
            @Mapping(source = "user.lastName", target = "lastName"),
            @Mapping(source = "user.email", target = "email"),
            @Mapping(source = "user.account.username", target = "username"),
    })
    UserDto userToUserDto(User user);
}

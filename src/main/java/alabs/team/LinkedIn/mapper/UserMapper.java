package alabs.team.LinkedIn.mapper;

import alabs.team.LinkedIn.dto.UserDTO;
import alabs.team.LinkedIn.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
    List<UserDTO> toDtoList(List<User> users);
}
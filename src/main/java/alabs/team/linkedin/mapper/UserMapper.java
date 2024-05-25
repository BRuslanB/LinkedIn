package alabs.team.linkedin.mapper;

import alabs.team.linkedin.dto.UserDTO;
import alabs.team.linkedin.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
//    User toEntity(UserDTO userDTO);
    List<UserDTO> toDtoList(List<User> users);
}
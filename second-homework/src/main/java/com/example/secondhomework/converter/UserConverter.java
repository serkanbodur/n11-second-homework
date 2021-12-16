package com.example.secondhomework.converter;


import com.example.secondhomework.dto.UserDTO;
import com.example.secondhomework.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    List<UserDTO> convertAllUsersToUserDTOs(List<User> user);

    UserDTO convertUserToUserDTO(User user);

    User convertUserDTOToUser(UserDTO userDTO);

}

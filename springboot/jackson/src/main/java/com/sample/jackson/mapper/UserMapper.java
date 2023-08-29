package com.sample.jackson.mapper;

import com.sample.jackson.model.UserData;
import com.sample.jackson.persistence.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserData userToUserData(User user);

    List<UserData> userToUserData(List <User> user);

    User userDataToUser(UserData userData);

}

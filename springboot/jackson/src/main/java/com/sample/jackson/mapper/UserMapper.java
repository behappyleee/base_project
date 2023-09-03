package com.sample.jackson.mapper;

import com.sample.jackson.model.UserData;
import com.sample.jackson.persistence.User;
import org.mapstruct.Mapper;
import java.util.List;

// Mapper 어노테이션 - 객체간 맵핑 한 코드를 생성해주는 Library

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserData userToUserData(User user);

    List<UserData> userToUserData(List <User> user);

    User userDataToUser(UserData userData);

}

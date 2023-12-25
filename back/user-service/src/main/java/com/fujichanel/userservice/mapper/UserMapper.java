package com.fujichanel.userservice.mapper;

import com.fujichanel.userservice.dto.UserRequest;
import com.fujichanel.userservice.dto.UserResponse;
import com.fujichanel.userservice.entities.User;

public interface UserMapper {
    User mapToUser(UserRequest request);
    UserResponse mapToUserResponse(User user);
}

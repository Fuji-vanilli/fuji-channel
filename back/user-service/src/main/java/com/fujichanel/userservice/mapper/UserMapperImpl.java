package com.fujichanel.userservice.mapper;

import com.fujichanel.userservice.dto.UserRequest;
import com.fujichanel.userservice.dto.UserResponse;
import com.fujichanel.userservice.entities.User;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserMapperImpl implements UserMapper {
    @Override
    public User mapToUser(UserRequest request) {
        return User.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .photo(request.getPhoto())
                .build();
    }

    @Override
    public UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .photo(user.getPhoto())
                .creationDate(user.getCreationDate())
                .lastUpdateDate(user.getLastUpdateDate())
                .build();
    }
}

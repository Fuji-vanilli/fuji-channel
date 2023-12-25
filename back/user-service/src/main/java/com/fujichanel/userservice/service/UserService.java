package com.fujichanel.userservice.service;

import com.fujichanel.userservice.dto.UserRequest;
import com.fujichanel.userservice.dto.UserResponse;

import java.util.Set;

public interface UserService {
    UserResponse add(UserRequest request);
    UserResponse get(String id);
    Set<UserResponse> all(int page, int size);
    Boolean delete(String id);
}

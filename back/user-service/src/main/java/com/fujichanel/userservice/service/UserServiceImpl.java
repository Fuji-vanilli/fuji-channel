package com.fujichanel.userservice.service;

import com.fujichanel.userservice.dto.UserRequest;
import com.fujichanel.userservice.dto.UserResponse;
import com.fujichanel.userservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public UserResponse add(UserRequest request) {
        return null;
    }

    @Override
    public UserResponse get(String id) {
        return null;
    }

    @Override
    public Set<UserResponse> all(int page, int size) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }
}

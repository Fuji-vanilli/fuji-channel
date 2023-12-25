package com.fujichanel.userservice.controller;

import com.fujichanel.userservice.dto.UserRequest;
import com.fujichanel.userservice.dto.UserResponse;
import com.fujichanel.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static com.fujichanel.userservice.utils.Root.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT)
@RequiredArgsConstructor
public class UserApi implements UserController{
    private final UserService userService;

    @Override
    public ResponseEntity<UserResponse> add(UserRequest request) {
        return ResponseEntity.ok(userService.add(request));
    }

    @Override
    public ResponseEntity<UserResponse> get(String id) {
        return ResponseEntity.ok(userService.get(id));
    }

    @Override
    public ResponseEntity<Set<UserResponse>> get(int page, int size) {
        return ResponseEntity.ok(userService.all(page, size));
    }

    @Override
    public ResponseEntity<Boolean> delete(String id) {
        return ResponseEntity.ok(userService.delete(id));
    }
}

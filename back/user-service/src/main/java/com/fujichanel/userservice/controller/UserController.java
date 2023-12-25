package com.fujichanel.userservice.controller;

import com.fujichanel.userservice.dto.UserRequest;
import com.fujichanel.userservice.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

public interface UserController {
    @PostMapping("add")
    ResponseEntity<UserResponse> add(@RequestBody UserRequest request);
    @GetMapping("get/{id}")
    ResponseEntity<UserResponse> get(@PathVariable String id);
    @GetMapping("all")
    ResponseEntity<Set<UserResponse>> get(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "18") int size
    );
    @DeleteMapping("delete/{id}")
    ResponseEntity<Boolean> delete(@PathVariable String id);
}

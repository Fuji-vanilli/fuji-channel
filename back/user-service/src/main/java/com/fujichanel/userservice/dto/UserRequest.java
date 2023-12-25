package com.fujichanel.userservice.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class UserRequest {
    private String username;
    private String password;
    private String photo;
}

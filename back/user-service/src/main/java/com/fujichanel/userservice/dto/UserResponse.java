package com.fujichanel.userservice.dto;

import lombok.*;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class UserResponse {
    private String id;
    private String username;
    private String password;
    private String photo;
    private Date creationDate;
    private Date lastUpdateDate;
}

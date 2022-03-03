package com.multiclient.userservice.entity;

import lombok.Data;

@Data
public class JwtRequest {
    private String userName;
    private String password;
}

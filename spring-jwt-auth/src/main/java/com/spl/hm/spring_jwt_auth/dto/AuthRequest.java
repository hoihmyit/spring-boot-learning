package com.spl.hm.spring_jwt_auth.dto;

import com.spl.hm.spring_jwt_auth.entity.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    private String username;
    private String password;
    private String fullName;
    private RoleEnum role;

}

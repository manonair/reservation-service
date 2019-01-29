package com.mt.reservation.vo;

import lombok.Data;

@Data
public class UserVO {

    private Long id;

    private String username;

    private String password;

    private boolean accountExpired;

    private boolean accountLocked;

    private boolean credentialsExpired;

    private boolean enabled;

   
}

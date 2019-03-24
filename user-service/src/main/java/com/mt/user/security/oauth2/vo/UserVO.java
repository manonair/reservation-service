package com.mt.user.security.oauth2.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserVO  implements Serializable{

    private Long id;
    
    private String username;

    private String password;

    private boolean accountExpired;

    private boolean accountLocked;

    private boolean credentialsExpired;

    private boolean enabled;
    
    private String accessToken;
    
    private Long authorityId;

    private String authorityName;
    
    

}

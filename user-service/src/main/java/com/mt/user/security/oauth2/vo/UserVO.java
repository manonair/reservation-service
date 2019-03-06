package com.mt.user.security.oauth2.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserVO  implements Serializable{

	
	private long id;

	private String name;

	private String email;

	private String mobileNumber;


	private String username;

	private String password;

}

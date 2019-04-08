package com.mt.user.security.oauth2.config.server;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mt.user.security.oauth2.vo.UserVO;

public class Test {

	public static void main(String[] args) {
		 	 
		
		BCryptPasswordEncoder bcryptPassword=new BCryptPasswordEncoder();
		System.out.println(bcryptPassword.encode("test123"));
		 if(bcryptPassword.matches("test123","$2a$08$tBy/ZNBsLoQAOO9A3QEbMecjuAqXXSyAHnjOtnt6JHniqEUo5MGsC") ) {
			 System.out.println("TRUE");
		 }else {
			 System.out.println("FALSE");
		 }

	}
}

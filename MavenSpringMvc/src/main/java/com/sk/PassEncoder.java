package com.sk;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassEncoder {
	public static void main(String  ... args){
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String password ="test";
		System.out.println(encoder.encode(password));
	}

}

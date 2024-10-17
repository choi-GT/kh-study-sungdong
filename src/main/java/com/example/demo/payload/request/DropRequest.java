package com.example.demo.payload.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DropRequest {
	private String userID;
	private String password;
	private String password2;
	
}

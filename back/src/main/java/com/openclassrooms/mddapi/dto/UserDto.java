package com.openclassrooms.mddapi.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDto {
	private int id;
	private String email;
	private String userName;
	private String password;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;	
}

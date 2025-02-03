package com.openclassrooms.mddapi.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDtoWithoutPassword {
	private int id;
	private String email;
	private String userName;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;	
}

package com.openclassrooms.mddapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.dto.LoginRequestDto;
import com.openclassrooms.mddapi.dto.UserDto;
import com.openclassrooms.mddapi.services.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserDto user) {
		String token = authService.register(user);
		
		if(token == null) {
			return ResponseEntity.status(401).body(null);
		}
		
		return ResponseEntity.ok(token);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequest) {
		System.out.println("Hello login");
		String token = authService.login(loginRequest.getEmail(), loginRequest.getPassword());
		
		if(token == null) {
			return ResponseEntity.status(401).body("Unauthorized");
		}
		
		return ResponseEntity.ok(token);
	}
}

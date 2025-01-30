package com.openclassrooms.mddapi.services;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.dto.UserDto;
import com.openclassrooms.mddapi.models.UserModel;
import com.openclassrooms.mddapi.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;
	private final JWTService jwtService;
	
	public String register(UserDto userDto) {
		UserModel userModel = modelMapper.map(userDto, UserModel.class);
		
		userModel.setCreatedAt(LocalDateTime.now());
		userModel.setUpatedAt(LocalDateTime.now());
		userModel.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
		
		UserModel response = userRepository.save(userModel);
		
		if(response != null) {
			String token = jwtService.generateToken(userModel);
			return token;
		}
		
		return null;
	}
	
}

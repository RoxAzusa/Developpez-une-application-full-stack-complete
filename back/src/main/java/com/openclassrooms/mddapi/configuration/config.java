package com.openclassrooms.mddapi.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
	@Bean
	public ModelMapper CreateModelMapper() {
		return new ModelMapper();
	}
}

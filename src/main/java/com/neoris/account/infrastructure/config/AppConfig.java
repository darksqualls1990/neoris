package com.neoris.account.infrastructure.config;

import org.reactivecommons.utils.ObjectMapper;
import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Configuration
@EnableConfigurationProperties
public class AppConfig {

	/**
	 * CorsFilter
	 * @return CorsFilter
	 */
	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source= new UrlBasedCorsConfigurationSource();
		
		final CorsConfiguration config= new CorsConfiguration();
		
		config.addAllowedOriginPattern("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("HEAD");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PATCH");
		config.setAllowCredentials(false);
		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);
	}

}

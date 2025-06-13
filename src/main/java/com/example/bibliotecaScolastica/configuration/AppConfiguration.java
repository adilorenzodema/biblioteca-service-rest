package com.example.bibliotecaScolastica.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class AppConfiguration {
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create().driverClassName("org.postgresql.Driver")
				.url("jdbc:postgresql://aws-0-eu-west-2.pooler.supabase.com:5432/postgres")
				.username("postgres.vstgvcdwlcwlhdqmtwdi").password("BibliotecaGiugno").build();
	}
	
	@Bean
	public SecurityFilterChain web(HttpSecurity http) throws Exception {
		http.cors(withDefaults()); // <--- ABILITA CORS
		http.csrf(AbstractHttpConfigurer::disable);
		http.authorizeHttpRequests(requests ->
			requests
				.requestMatchers("/api/**").permitAll()
				.anyRequest().authenticated()
		);
		return http.build();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.addAllowedOrigin("*");
	    configuration.addAllowedMethod("*");
	    configuration.addAllowedHeader("*");

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}
}

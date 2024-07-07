package com.cosblog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cosblog.config.auth.PrincipalDetailService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//빈 등록 : 스프링 컨터에너에서 객체를 관리할 수 있게 하는 것

@Configuration // 빈등록 (IOC관리)
@EnableWebSecurity // 시큐리티 필터가 등록이 된다.
public class SecurityConfig{

	@Autowired
	private PrincipalDetailService principalDetailService;

	@Bean // IOC화
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.disable()) // CSRF 토큰 비활성화 (테스트 시 유용)
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(new AntPathRequestMatcher("/"),
								new AntPathRequestMatcher("/**"),
								new AntPathRequestMatcher("/api/**"),
								new AntPathRequestMatcher("/main/**"),
								new AntPathRequestMatcher("/auth/**"),
								new AntPathRequestMatcher("/js/**"),
								new AntPathRequestMatcher("/css/**"),
								new AntPathRequestMatcher("/image/**")).permitAll()
						.anyRequest().authenticated()
				);
//				.formLogin(form -> form
//						.loginPage("/auth/loginForm")
//						.loginProcessingUrl("/auth/loginProc")
//						.defaultSuccessUrl("/") // 스프링 시큐리티가 해당 주소로 요청하는 로그인을 가로채서 대신 로그인 해줌
//				);

		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
}

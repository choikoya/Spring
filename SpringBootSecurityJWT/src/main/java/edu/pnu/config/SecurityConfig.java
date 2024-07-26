package edu.pnu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import edu.pnu.config.filter.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity // 스프링 시큐리티를 활성화

public class SecurityConfig {
	
	

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); //BCryptPasswordEncoder를 사용하여 비밀번호를 인코딩하는 PasswordEncoder 빈을 정의
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		 // CSRF 보호 비활성화
		http.csrf(csrf->csrf.disable());
		
		http.authorizeHttpRequests(auth->auth // 요청 경로별로 접근 권한을 설정
					.requestMatchers("/member/**").authenticated() // "/member/**" 경로는 인증된 사용자만 접근 가능
					.requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN") // "/manager/**" 경로는 MANAGER 또는 ADMIN 권한을 가진 사용자만 접근 가능
					.requestMatchers("/admin/**").hasRole("ADMIN")// "/admin/**" 경로는 ADMIN 권한을 가진 사용자만 접근 가능
					.anyRequest().permitAll());// 나머지 요청은 모두 허용
		
		// 폼 로그인 및 HTTP 기본 인증 비활성화
		http.formLogin(frmLogin->frmLogin.disable());
		http.httpBasic(basic->basic.disable());
		
		 // 세션 관리 설정 (세션을 상태 없이 관리하도록 설정. 주로 JWT 인증을 사용할 때 필요)
		http.sessionManagement(sm->sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		// JWT 인증 필터 추가(요청을 가로채 JWT 토큰을 확인하고 인증을 처리)
		http.addFilter(new JWTAuthenticationFilter(
				authenticationConfiguration.getAuthenticationManager()));
				
		return http.build();
		
	}
	
	//의존성 주입(AuthenticationConfiguration을 주입받아 인증 관리자를 설정하는 데 사용)
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;
	

}

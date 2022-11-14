package fi.haagahelia.barcafavoritesbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/css/**").permitAll().antMatchers("/h2-console/**")
				.permitAll().antMatchers("/player/**").permitAll().antMatchers("/api/player/**").permitAll()
				.antMatchers("/api/currentusername").permitAll().anyRequest().authenticated().and().headers()
				.frameOptions().sameOrigin().and().formLogin()
				.defaultSuccessUrl("https://barcafavorites-frontend.herokuapp.com/players", true).permitAll().and()
				.logout().clearAuthentication(true).deleteCookies("JSESSIONID").invalidateHttpSession(true).and()
				.httpBasic();
		return http.build();
	}
//	LOCALHOST	
//	@Bean
//	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().antMatchers("/css/**").permitAll().antMatchers("/h2-console/**")
//				.permitAll().antMatchers("/player/**").permitAll().antMatchers("/api/player/**").permitAll()
//				.antMatchers("/api/currentuser").permitAll().anyRequest().authenticated().and().headers().frameOptions()
//				.sameOrigin().and().formLogin().defaultSuccessUrl("http://localhost:3000/players", true).permitAll()
//				.and().logout().clearAuthentication(true).deleteCookies("JSESSIONID").invalidateHttpSession(true).and()
//				.httpBasic().and().cors();
//		return http.build();
//	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

//	LOCALHOST
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
//		configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
//		configuration.setAllowCredentials(true);
//		configuration.addAllowedHeader("*");
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("https://barcafavorites-frontend.herokuapp.com"));
//		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT"));
//		configuration.setAllowCredentials(true);
//		configuration.addAllowedHeader("*");
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
}
package c300.definers.fyp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public MemberDetailsService memberDetailsService() {
		return new MemberDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(memberDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()

				// Members functions
				.antMatchers("/members", "/members/edit/*", "/members/delete/*").hasRole("ADMIN")
				// "/members/add" & "/members/save" open for visitors to sign up
				.antMatchers("/members/add", "/members/save").permitAll()

				// Pool
				.antMatchers("/pool/newPool", "/pool/save", "/pool/manage", "/pool/edit/*", "/pool/edit/pool/edit/*",
						"/pool/delete/*")
				.hasRole("ADMIN").antMatchers("/pool").permitAll()
				.antMatchers("/pool/Dep1/*", "/pool/Dep1/pool/Dep1/*", "/pool/Dep2/*", "/pool/Dep2/pool/Dep2/*")
				.hasAnyRole("USER")

				// Token
				.antMatchers("/tokens/add", "/tokens/save", "/token/edit/*", "/token/delete/*")
				.hasAnyRole("ADMIN", "USER").antMatchers("/tokens").permitAll()

				// Swap
				.antMatchers("/swap/save").hasAnyRole("ADMIN", "USER")

				// Wallet
				.antMatchers("/wallet").hasAnyRole("ADMIN", "USER")

				.antMatchers("/", "/charts", "/about", "/docs", "/docs/definers").permitAll()
				.antMatchers("/bootstrap/*/*").permitAll().antMatchers("/images/*").permitAll().antMatchers("/css/*")
				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/", true).and().logout().logoutUrl("/logout").permitAll().and().exceptionHandling()
				.accessDeniedPage("/403");

	}
}

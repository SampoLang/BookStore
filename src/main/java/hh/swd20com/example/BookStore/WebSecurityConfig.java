package hh.swd20com.example.BookStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import hh.swd20com.example.BookStore.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        	.antMatchers("/css/**").permitAll()
        	.anyRequest().authenticated()
        	.and()
      .formLogin()
      .loginPage("/login")
          .defaultSuccessUrl("/booklist", true)
          .permitAll()
          .and()
      .logout()
          .permitAll()
          .and()
      .httpBasic();
      return http.build();
    }
    @Autowired
    private UserDetailServiceImpl userDetailsService;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(new
    BCryptPasswordEncoder());
    }


	 /*
	 @Bean
	 public UserDetailsService userDetailsService() {
		 List<UserDetails> users = new ArrayList<UserDetails>();
		 PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		 UserDetails user1 = User
				 .withUsername("user")
				 .password(passwordEncoder.encode("user"))
				 .roles("USER")
				 .build();
		 UserDetails user2 = User
				 .withUsername("admin")
				 .password(passwordEncoder.encode("admin"))
				 .roles("USER","ADMIN")
				 .build();
		 users.add(user1);
		 users.add(user2);
		 return new InMemoryUserDetailsManager(users);
	 }*/

}

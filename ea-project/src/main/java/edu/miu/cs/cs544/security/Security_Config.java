package edu.miu.cs.cs544.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Security_Config  extends WebSecurityConfigurerAdapter{

	 @Override
	    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
	    {
		   System.out.println("<<<<<<<<<<<<<<< Auth Builder >>>>>>>>>>>>>>");
	    	authenticationManagerBuilder.inMemoryAuthentication().
	    	withUser("Ahmed").password("123").roles("admin");
	    }
	    
	    @Bean
	    public PasswordEncoder getPasswordEncoder() {
	    	return NoOpPasswordEncoder.getInstance();
	    }
	    
	    @Override
	    public void configure(HttpSecurity http) {
	    	try {
	    		 System.out.println("<<<<<<<<<<<<<<< HTTP SEC >>>>>>>>>>>>>>");
				http.authorizeRequests()
				.antMatchers("/reservation").hasRole("admin").
				and().httpBasic();
			} 
	    	catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	   
}

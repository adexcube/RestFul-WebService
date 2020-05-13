//package edu.miu.cs.cs544;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	protected void configure(HttpSecurity http) throws Exception {
//	    http.authorizeRequests()
//	      .anyRequest().authenticated()
//	      .and().httpBasic();
//	}
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//      throws Exception {
//        auth.inMemoryAuthentication().withUser("darhy")
//          .password("1234").roles("ADMIN");
//    }
//}

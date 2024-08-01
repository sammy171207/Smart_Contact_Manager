package com.scm.scm.config;

import com.scm.scm.services.impl.SecurityCustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /// user create and login using java code with in memory server
//    @Bean
//    public UserDetailsService userDetailsService(){
//       UserDetails user1= User
//               .withDefaultPasswordEncoder()
//               .username("admin123")
//               .password("admin123")
//               .roles("ADMIN","USER")
//               .build();
//
//      UserDetails user2= User.withUsername("sam")
//               .password("sam")
//               .roles("ADMIN")
//               .build();
//      var inMemoryUserDetailsManager=  new InMemoryUserDetailsManager();
//        return  inMemoryUserDetailsManager;
//    }
    @Autowired
    private SecurityCustomUserDetailService userDetailService;

    ///configuration of authetication provider for spring and securtiy
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //configuration
        // code here that which config are public and which are private
        httpSecurity.authorizeHttpRequests(authorize->{
//            authorize.requestMatchers("/home","/register","/login").permitAll();
             authorize.requestMatchers("/user/**").authenticated();
             authorize.anyRequest().permitAll();
        });
        //form default login which are normally come when we use security

        httpSecurity.formLogin(Customizer.withDefaults());
        return httpSecurity.build();

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}

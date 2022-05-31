package com.example.pazarbox.core.utillities.security;


import com.example.pazarbox.business.concretes.UserManager;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import javax.crypto.SecretKey;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityManager extends WebSecurityConfigurerAdapter {

    private final UserManager userManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http .cors ().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).and ()
                .csrf ().disable ()
                .sessionManagement ().sessionCreationPolicy (SessionCreationPolicy.STATELESS).and()
             //   .addFilter (new JwtUsernameAndPasswordAuthenticationFilter (authenticationManager (),
              //          jwtConfig,	secretKey))
              //  .addFilterAfter(new JwtTokenVerifier(jwtConfig, secretKey), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests ()
                .antMatchers ("/","index","/css/*","/js/*").permitAll ()
                .antMatchers ("/api/v1/registration/**").permitAll ()


                .anyRequest ()
                .authenticated ().and ()
                .httpBasic ();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider (daoAuthenticationProvider ());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider ();
        provider.setPasswordEncoder (bCryptPasswordEncoder);
        provider.setUserDetailsService (userManager);
        return provider;
    }



}

package com.developersboard.onlinebankingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String[] PUBLIC_MATCHERS = {
            "/css/**",
            "/js/**",
            "/",
            "/home",
            "/h2-console/**",
            "/signup"
    };


    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Configuration
    @EnableWebSecurity
    protected class WebSecurityConfig extends WebSecurityConfigurerAdapter {


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers(PUBLIC_MATCHERS).permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .failureUrl("/index?error")
                    .defaultSuccessUrl("/onlineBanking")
                    .loginPage("/login")
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll();
        }

        @Override
        public void configure(final AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("mike")
                    .password("pages")
                    .roles("USER");
        }
    }


}

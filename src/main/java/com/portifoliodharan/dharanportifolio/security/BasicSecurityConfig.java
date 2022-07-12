package com.portifoliodharan.dharanportifolio.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
        auth.inMemoryAuthentication()
                .withUser("useradmin")
                .password("admin")
                .roles("ADMIN")
                .authorities("ROLE_ADMIN");

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/user/signin").permitAll()
                .antMatchers("/user/login").permitAll()
                .antMatchers("/send-mail").permitAll()
//                .antMatchers("/**").permitAll()
//                .antMatchers("/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/projetos/**").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic()
                //tipo de sessão - Stateless, não guarda sessão nenhuma
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().cors()
                .and().csrf().disable();
    }
}

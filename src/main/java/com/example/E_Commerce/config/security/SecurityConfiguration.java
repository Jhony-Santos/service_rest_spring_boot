package com.example.E_Commerce.config.security;


import com.example.E_Commerce.filter.JWTAuthenticationFilter;
import com.example.E_Commerce.filter.JWTAuthorizationFilter;
import com.example.E_Commerce.service.AuthenticationUserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationUserDetailService authenticationUserDetailService;

    @Override protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, AuthenticationConfigConstants.SIGN_UP_URL).permitAll()
                /*.antMatchers("/cliente/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/compra/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/estoque/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/fornecedores/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/items/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/produto/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/venda/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/items/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/stock/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/buy/**").hasAnyAuthority("USER", "ADMIN")*/
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // this disables session creation on Spring Security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUserDetailService).passwordEncoder(bCryptPasswordEncoder);
    }
}

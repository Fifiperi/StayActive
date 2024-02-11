package fsre.stayactive.config;
import fsre.stayactive.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Autowired
    DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService (){
        return new UserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider (){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsService());
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MyAuthenticationSuccessHandler();
    }


    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/user/register/**","/user/register", "/images/**")
                .permitAll()
                .requestMatchers("/users/**").hasAuthority("TRENER")
                .requestMatchers("/user/gender/**",  "/user/female").hasAuthority("KORISNIK")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().successHandler(myAuthenticationSuccessHandler())
                .loginPage("/login")
                .permitAll()
                .usernameParameter("email")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/").permitAll();

        http.authenticationProvider(authenticationProvider());
        http.headers().frameOptions().sameOrigin();

        return http.build();

    }
}
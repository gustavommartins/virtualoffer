package br.com.gustavom.virtualoffer.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig {

    final DataSource dataSource;
    private static final String ADMINISTRADOR =  "admin";

    @Autowired
    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(requests -> requests
                        .requestMatchers("/")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                ).formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")).build();
    }

    @Bean
    public UserDetailsManager users() {
        UserDetailsManager users = new JdbcUserDetailsManager(this.dataSource);
        criaUsuarioDefaultSeNaoExistirUsuarios(users);
        return users;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private void criaUsuarioDefaultSeNaoExistirUsuarios(UserDetailsManager user) {
        if(!user.userExists(ADMINISTRADOR)){
            user.createUser(createDefaulUser());
        }
    }

    private UserDetails createDefaulUser() {
        PasswordEncoder encoder = passwordEncoder();
        return User.builder()
                .username(ADMINISTRADOR)
                .password(encoder.encode(ADMINISTRADOR))
                .roles("ADMIN")
                .build();
    }

}
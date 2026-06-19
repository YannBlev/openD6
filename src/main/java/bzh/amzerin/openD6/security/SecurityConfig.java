package bzh.amzerin.openD6.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((authorize) -> authorize
                .requestMatchers("/films/nouveau", "/genres", "/participants").hasRole("admin")
                .requestMatchers("/films/*/avis").authenticated()
                .anyRequest().permitAll()
        )
        .httpBasic(Customizer.withDefaults())
                .formLogin((formLogin) -> formLogin
                        .loginPage("/openD6/login")
                        .loginProcessingUrl("/openD6/login")
                        .failureUrl("/openD6/login?error=true")
                        .defaultSuccessUrl("/openD6", true)
                        .permitAll()
                )
                .logout((logout) -> logout.logoutSuccessUrl("/")
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .clearAuthentication(true)
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
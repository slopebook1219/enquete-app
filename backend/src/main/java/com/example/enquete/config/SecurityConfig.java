package com.example.enquete.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                // 他の全リクエストは認証を必須にする
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")          // ログインページのURL
                .loginProcessingUrl("/login") // ログイン処理を行うURL
                .defaultSuccessUrl("/home")   // ログイン成功時の遷移先
                .failureUrl("/login?error")   // ログイン失敗時の遷移先
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login")
            );

        return http.build();
    }

    // パスワードの暗号化（照合用）
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

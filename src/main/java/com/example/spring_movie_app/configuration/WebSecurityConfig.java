package com.example.spring_movie_app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // 静的リソースをSpring Securityの保護対象から外す
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/img/**",
                "/css/**",
                "/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 認可
        // /loginのみ認可
        http.authorizeHttpRequests()
                .antMatchers("/", "/login", "/signup").permitAll()
                .anyRequest().authenticated();

        // フォーム認証の設定
        http.formLogin()
                .loginProcessingUrl("/login") // 認証処理を起動させるパス
                .loginPage("/login") // ログインフォームのパス
                .failureUrl("/login?error") // ログイン処理失敗時の遷移先
                .defaultSuccessUrl("/movie") // 認証成功時の遷移先
                .usernameParameter("userName")
                .passwordParameter("password");

        // ログアウトの設定
        http.logout()
                .logoutSuccessUrl("/login?logout") // ログアウト完了時のパス
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);
    }

    /**
     * パスワードエンコーダーのインスタンスを提供する
     *
     * @return BCryptPasswordEncoderインスタンス
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // パスワードエンコーダーのインスタンスを生成
        // bcryptアルゴリズムを利用
        return new BCryptPasswordEncoder();
    }
}

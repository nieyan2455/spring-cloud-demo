/*
package com.ny.springcloud.config;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


*/
/**
 * 自定义登录成功配置
 *
 * @author Chill
 *//*


@Configuration
@AllArgsConstructor
@EnableResourceServer
public class MyResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    */
/**
     * 自定义登录成功处理器
     *//*

    private final AuthenticationSuccessHandler appLoginInSuccessHandler;

    @Override
    @SneakyThrows
    public void configure(HttpSecurity http) {
        http.headers().frameOptions().disable();
        http.formLogin()
                .successHandler(appLoginInSuccessHandler)
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/actuator/**",
                        "/oauth/captcha",
                        "/oauth/**",
                        "/oauth/logout",
                        "/oauth/clear-cache",
                        "/oauth/render/**",
                        "/oauth/callback/**",
                        "/oauth/revoke/**",
                        "/oauth/refresh/**",
                        "/token/**",
                        "/mobile/**",
                        "/v2/api-docs").permitAll()
                .anyRequest().authenticated().and()
                .csrf().disable();
    }

}

*/

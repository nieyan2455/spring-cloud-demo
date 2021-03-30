package com.ny.springcloud.config;

import com.ny.springcloud.entity.MyUserDetails;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Security配置
 *
 * @author Chill
 */
@Configuration
@AllArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    PasswordEncoder passwordEncoder;

/*    @Bean
    @Override
    @SneakyThrows
    public AuthenticationManager authenticationManagerBean() {
        return super.authenticationManagerBean();
    }*/

    /**
     * 配置密码加密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        String idForEncode = "bcrypt";
        Map encoders = new HashMap<>();
        encoders.put(idForEncode, new BCryptPasswordEncoder());
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("sha256", new StandardPasswordEncoder());

        PasswordEncoder passwordEncoder =
                new DelegatingPasswordEncoder(idForEncode, encoders);
        return passwordEncoder;

    }

    /**
     * 配置安全拦截机制
     *
     * @param http
     */
    @Override
    @SneakyThrows
    protected void configure(HttpSecurity http) {
        http.authorizeRequests().antMatchers("/r/**").authenticated()// /r/下的所有请求必须认证
                .anyRequest().permitAll()    //其他请求放行
                .and().formLogin()  //允许表单登录
                .defaultSuccessUrl("/login-success"); //成功跳转的链接,重定向
                //.successForwardUrl("/login-success"); //成功跳转的链接,转发,表单提交过来request是post方法，不能转发到get方法上
        http.httpBasic().and().csrf().disable();
    }



}

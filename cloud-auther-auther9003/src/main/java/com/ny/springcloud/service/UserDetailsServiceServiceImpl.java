package com.ny.springcloud.service;

import com.ny.springcloud.entity.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

/**
 * @author nieyan
 * @create 2021-03-10 11:00
 */

@Component
public class UserDetailsServiceServiceImpl implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        String passwordEncode = passwordEncoder.encode("123456");
        MyUserDetails myUserDetails = new MyUserDetails("admin", passwordEncode, 1l, "c1", AuthorityUtils.createAuthorityList("admin"));
        return myUserDetails;
    }
}

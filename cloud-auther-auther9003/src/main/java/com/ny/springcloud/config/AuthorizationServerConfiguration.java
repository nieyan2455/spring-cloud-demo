/*
package com.ny.springcloud.config;

import com.ny.springcloud.enhancer.MyJwtTokenEnhancer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * @author nieyan
 * @create 2021-03-10 11:07
 **//*

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer
                .allowFormAuthenticationForClients()
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    */
/**
     * 配置客户端，支持哪些客户端
     *
     * @param clients
     * @throws Exception
     *//*

    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //客户端配置使用内存方式
        clients.inMemory()      //in-memory方式
                .withClient("c1")   //clientId
                .secret(new BCryptPasswordEncoder().encode("secret"))   //客户端密钥
                */
/*.resourceIds("resource") *//*
   //资源列表
                .authorizedGrantTypes("authorization_code","password","client_credentials","implicit","refresh_token") //oauth的授权方式
                .scopes("all")  //授权范围
                .autoApprove(false) //跳转到授权页面
                .redirectUris("http://www.baidu.com")
           */
/*     .and()  //多客户端
                .inMemory()      //in-memory方式
                .withClient("c1")   //clientId
                .secret(new BCryptPasswordEncoder().encode("secret"))   //客户端密钥
                *//*
*/
/*.resourceIds("resource")*//*
*/
/*    //资源列表
                .authorizedGrantTypes("authorization_code","password") //oauth的授权方式
                .scopes("all")  //授权范围
                .autoApprove(false) //跳转到授权页面
                .redirectUris("http://www.baidu.com")*//*
;
    }

    */
/**
     * 配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)
     *
     * @param endpoints
     * @throws Exception
     *//*

    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> tokenEnhancers = new ArrayList<>();

        tokenEnhancers.add(jwtAccessTokenConverter);
        tokenEnhancerChain.setTokenEnhancers(tokenEnhancers);

        endpoints.authenticationManager(authenticationManager)
                .accessTokenConverter(jwtAccessTokenConverter)
                .tokenEnhancer(tokenEnhancerChain)
                .userDetailsService(userDetailsService)
                // refresh_token有两种使用方式：重复使用(true)、非重复使用(false)，默认为true
                //      1.重复使用：access_token过期刷新时， refresh token过期时间未改变，仍以初次生成的时间为准
                //      2.非重复使用：access_token过期刷新时， refresh_token过期时间延续，在refresh_token有效期内刷新而无需失效再次登录
                .reuseRefreshTokens(false);
    }



}
*/

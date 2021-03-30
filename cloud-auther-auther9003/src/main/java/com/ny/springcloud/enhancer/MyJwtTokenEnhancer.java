/*
package com.ny.springcloud.enhancer;

import com.ny.springcloud.constant.TokenConstant;
import com.ny.springcloud.entity.MyUserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

*/
/**
 * @author nieyan
 * @create 2021-03-10 14:38
 **//*

public class MyJwtTokenEnhancer implements TokenEnhancer {

    */
/**
     * JWT内容增强
     *//*

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

            MyUserDetails user = (MyUserDetails) oAuth2Authentication.getUserAuthentication().getPrincipal();
            Map<String, Object> map = new HashMap<>(2);
            map.put(TokenConstant.JWT_USER_ID_KEY, user.getId());
            map.put(TokenConstant.JWT_CLIENT_ID_KEY, user.getClientId());

            ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(map);
            return oAuth2AccessToken;


    }
}
*/

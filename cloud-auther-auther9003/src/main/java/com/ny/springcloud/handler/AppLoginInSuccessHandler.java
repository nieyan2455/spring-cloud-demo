/*

package com.ny.springcloud.handler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

*/
/**
 * APP登录成功处理器
 *
 * @author Chill
 *//*

@Slf4j
@AllArgsConstructor
@Component("appLoginInSuccessHandler")
public class AppLoginInSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private final PasswordEncoder passwordEncoder;

	private final ClientDetailsService clientDetailsService;

	private final AuthorizationServerTokenServices authorizationServerTokenServices;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
		log.info("【AppLoginInSuccessHandler】 onAuthenticationSuccess authentication={}", authentication);

	}

}
*/

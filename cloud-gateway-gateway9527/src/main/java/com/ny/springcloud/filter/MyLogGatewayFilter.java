package com.ny.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.LinkedHashSet;

/**
 * @author nieyan
 * @create 2021-03-03 10:18
 **/
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        log.info("uri====" + request.getURI());
        LinkedHashSet<URI> uris = exchange.getAttributeOrDefault(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR, null);
        if (uris != null) {
            URI requestUri = uris.stream().findFirst().orElse(request.getURI());
            log.info("requestUri====" + requestUri);
        }
        log.info("*****MyLogGatewayFilter*****");
        if (!request.getURI().toString().contains("filter")) {
            return chain.filter(exchange);
        }
        String id = request.getQueryParams().getFirst("id");
        if (id == null) {
            log.error("----参数不合法-----");
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return 1;
    }
}

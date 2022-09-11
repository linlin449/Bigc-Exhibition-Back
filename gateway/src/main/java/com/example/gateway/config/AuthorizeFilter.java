package com.example.gateway.config;

import cn.bigc.common.entity.AdminToken;
import cn.bigc.common.service.AdminTokenService;
import cn.bigc.common.service.impl.AdminTokenServiceImpl;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    private static final String AUTHORIZE_TOKEN = "X-Token";
    private final AdminTokenService adminTokenService = new AdminTokenServiceImpl();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String path = request.getURI().getPath();
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        if (antPathMatcher.match("/admin/login/**", path)) {
            return chain.filter(exchange);
        }
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst(AUTHORIZE_TOKEN);

        if (token == null || token.equals("")) {
            // 无权限
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        AdminToken adminToken = adminTokenService.getByToken(token);
        if (adminToken == null) {
            // 无权限
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        } else {
            return chain.filter(exchange);
        }


    }

    @Override
    public int getOrder() {
        return 0;
    }
}
package com.example.demo;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;

@Component
public class FilterLogging implements GlobalFilter {

    @Override
    public reactor.core.publisher.Mono<Void> filter(
            org.springframework.web.server.ServerWebExchange exchange,
            org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {

        System.out.println("Incoming request: "
                + exchange.getRequest().getURI());

        return chain.filter(exchange);
    }
}
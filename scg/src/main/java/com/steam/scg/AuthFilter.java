package com.steam.scg;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {
    public AuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();
            System.out.println(request.toString());

//            // Request Header 에 token 이 존재하지 않을 때
//            if(!request.getHeaders().containsKey("token")){
//                return handleUnAuthorized(exchange); // 401 Error
//            }
//
//            // Request Header 에서 token 문자열 받아오기
//            List<String> token = request.getHeaders().get("token");
//            String tokenString = Objects.requireNonNull(token).get(0);
//
//            // 토큰 검증
//            if(!tokenString.equals("A.B.C")) {
//                return handleUnAuthorized(exchange); // 토큰이 일치하지 않을 때
//            }

            return chain.filter(exchange); // 토큰이 일치할 때

        });
    }

//    private Mono<Void> handleUnAuthorized(ServerWebExchange exchange) {
//        ServerHttpResponse response = (ServerHttpResponse) exchange.getResponse();
//
//        response.setStatusCode(HttpStatus.UNAUTHORIZED);
//        return response.setComplete();
//    }

//    private Validate validateToken(String tokenHeader) {
//        Algorithm a = Algorithm.HMAC256(secret);
//        JWTVerifier verifier = JWT.require(a).build();
//        final RequestContext ctx = RequestContext.getCurrentContext();
//        try{
//            DecodedJWT decodedJWT = verifier.verify(tokenHeader);
//            log.info("token validate");
//        }catch (SignatureVerificationException exception){
//            return new Validate(false,1);
//        }catch (TokenExpiredException exception){
//            return new Validate(false,2);
//        }
//
//        return new Validate(true,0);
//    }

    public static class Config {

    }
}

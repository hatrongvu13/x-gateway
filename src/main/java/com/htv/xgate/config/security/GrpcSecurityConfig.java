package com.htv.xgate.config.security;

import com.htv.xgate.config.grpc.GrpcClientJwtInterceptor;
import io.grpc.Metadata;
import io.grpc.ServerCall;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.interceptor.GlobalClientInterceptorConfigurer;
import net.devh.boot.grpc.server.security.authentication.GrpcAuthenticationReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.annotation.Nullable;

@Configuration
@RequiredArgsConstructor
public class GrpcSecurityConfig {

    private final GrpcClientJwtInterceptor grpcClientJwtInterceptor;

    @Bean
    public GrpcAuthenticationReader grpcAuthenticationReader() {
        return new GrpcAuthenticationReader() {
            @Nullable
            @Override
            public Authentication readAuthentication(ServerCall<?, ?> call, Metadata headers) throws AuthenticationException {
                return null;
            }
        };
    }

    @Bean
    public GlobalClientInterceptorConfigurer globalClientInterceptorConfigurer() {
        return request -> request.add(grpcClientJwtInterceptor);
    }

}

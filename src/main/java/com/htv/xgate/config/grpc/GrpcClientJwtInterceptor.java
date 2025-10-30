package com.htv.xgate.config.grpc;

import com.htv.xgate.utils.SecurityUtils;
import io.grpc.*;
import org.springframework.stereotype.Component;

@Component
public class GrpcClientJwtInterceptor implements ClientInterceptor {

    private final static Metadata.Key<String> auth = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
        return new ForwardingClientCall.SimpleForwardingClientCall<>(channel.newCall(methodDescriptor, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener, Metadata headers) {
                headers.put(auth, "Bearer " + SecurityUtils.extractToken());
                super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<>(responseListener) {}, headers);
            }
        };
    }
}

package com.htv.xgate.graphql;

import com.htv.xgate.model.dto.user.UserInfo;
import com.htv.xgate.model.request.authentication.Login;
import com.htv.xgate.model.request.authentication.Register;
import com.htv.xgate.model.response.authentication.Token;
import com.htv.xgate.services.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthenticationGraphql {

    private final AuthenticationService authenticationService;

    @QueryMapping
    public Token login(@Argument Login request) {
        return authenticationService.login(request);
    }

    @QueryMapping
    public UserDetails info(@Argument UserInfo request) {
        return authenticationService.info(request);
    }

    @MutationMapping
    public Token register(Register request) {
        return authenticationService.register(request);
    }

}

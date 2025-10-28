package com.htv.xgate.services.authentication;

import com.htv.xgate.model.dto.user.UserInfo;
import com.htv.xgate.model.request.authentication.Login;
import com.htv.xgate.model.request.authentication.Register;
import com.htv.xgate.model.response.authentication.Token;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    Token login(Login request);

    Token register(Register request);

    UserDetails info(UserInfo request);
}

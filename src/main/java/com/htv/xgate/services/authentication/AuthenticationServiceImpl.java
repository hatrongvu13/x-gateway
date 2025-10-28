package com.htv.xgate.services.authentication;

import com.htv.xgate.model.dto.user.UserInfo;
import com.htv.xgate.model.request.authentication.Login;
import com.htv.xgate.model.request.authentication.Register;
import com.htv.xgate.model.response.authentication.Token;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public Token login(Login request) {
        return null;
    }

    @Override
    public Token register(Register request) {
        return null;
    }

    @Override
    public UserDetails info(UserInfo request) {
        return null;
    }
}

package com.htv.xgate.utils;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class SecurityUtil {
    public static String extractToken() {
        var context = SecurityContextHolder.getContext();
        if (context != null && context.getAuthentication() != null) {
            Object credentials = context.getAuthentication().getCredentials();
            if (credentials instanceof String token && token.startsWith("ey")) {
                return token;
            }
        }
        return null;
    }
}

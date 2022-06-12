package com.ozkan.musicStore.Security.JWT;


import com.ozkan.musicStore.Security.UserPrincipal;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface JwtProviderI
{
    String generateToken(UserPrincipal auth);

    Authentication getAuthentication(HttpServletRequest request);

    // 3rd Operation
    boolean validateToken(HttpServletRequest request);
}

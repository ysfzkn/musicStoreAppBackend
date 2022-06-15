package com.ozkan.musicStore.Util;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class SecurityUtils
{
    public static final String ROLE_PREFIX = "ROLE_";

    // key value of header coming from Authorization
    public static final String AUTH_HEADER = "authorization";
    // JWT Authorizotaion Type
    public static final String AUTH_TOKEN_TYPE = "Bearer";
    // Formatted Bearer Token for the server side
    public static final String AUTH_TOKEN_PREFIX = AUTH_TOKEN_TYPE + " ";

    public static SimpleGrantedAuthority convertAuthority(String role)
    {
        String formattedRole = role.startsWith(ROLE_PREFIX) ? role : ROLE_PREFIX + role;

        return new SimpleGrantedAuthority(formattedRole);
    }

    public static String extractAuthTokenFromRequest(HttpServletRequest request)
    {
        String bearerToken = request.getHeader(AUTH_HEADER);

        if(StringUtils.hasLength(bearerToken) && bearerToken.startsWith(AUTH_TOKEN_PREFIX))
        {
            return bearerToken.substring(7);
        }
        else
        {
            return null; // if token is null
        }
    }
}

package com.ozkan.musicStore.Security.JWT;

import com.ozkan.musicStore.Security.UserPrincipal;
import com.ozkan.musicStore.Util.SecurityUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtProvider implements JwtProviderI
{
    @Value("${app.jwt.secret}")
    private String JWT_TOKEN;

    @Value("${app.jwt.expiration-in-ms}")
    private Long JWT_EXP;

    // 1st Operation
    @Override
    public String generateToken(UserPrincipal auth)
    {
        String authorities = auth.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(auth.getUsername())
                .claim("roles", authorities)
                .claim("userId", auth.getId())
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXP))
                .signWith(SignatureAlgorithm.HS512, JWT_TOKEN)
                .compact();
    }

    // 2nd Operation
    @Override
    public Authentication getAuthentication(HttpServletRequest request)
    {
        Claims claims = extractClaims(request);

        if (claims == null)
        {
            return null;
        }

        String username = claims.getSubject();
        Long userId = claims.get("userId" , Long.class);

        Set<GrantedAuthority> authorities = Arrays.stream(claims.get("roles").toString().split(","))
                .map(SecurityUtils::convertAuthority)
                .collect(Collectors.toSet());

        UserDetails userDetails = UserPrincipal.builder()
                .username(username)
                .authorities(authorities)
                .id(userId)
                .build();

        if (username == null)
        {
            return null;
        }

        return new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
    }

    // 3rd Operation
    @Override
    public boolean validateToken(HttpServletRequest request)
    {
        Claims claims = extractClaims(request);

        if (claims == null)
        {
            return false;
        }
        if(claims.getExpiration().before(new Date()))
        {
            return false;
        }
        return true;


    }

    private Claims extractClaims(HttpServletRequest request)
    {
        String token = SecurityUtils.extractAuthTokenFromRequest(request);

        if (token == null)
        {
            return null;
        }

        return Jwts.parser()
                .setSigningKey(JWT_TOKEN)
                .parseClaimsJws(token)
                .getBody();
    }


}

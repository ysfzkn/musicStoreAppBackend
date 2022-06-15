package com.ozkan.musicStore.Security;


import com.ozkan.musicStore.Util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class InternalApiAuthFilter extends OncePerRequestFilter
{

    private final String accessKey;

    public InternalApiAuthFilter(String accessKey)
    {
        this.accessKey = accessKey;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException
    {
        return !request.getRequestURI().startsWith("/internal");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException
    {
        try
        {
            String requestKey = SecurityUtils.extractAuthTokenFromRequest(request);

            if (requestKey == null || !requestKey.equals(accessKey))
            {
                log.warn("Internal key endpoint without/wrong key uri: {}", request.getRequestURI());
                throw new RuntimeException("UNAUTHORIZED");
            }

            UserPrincipal user = UserPrincipal.createSuperUser();

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user,
                    null, user.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(auth); //authentication check
        }
        catch (Exception e)
        {
            log.error("Could not set user authentication in security context", e);
        }

        filterChain.doFilter(request, response);
    }
}

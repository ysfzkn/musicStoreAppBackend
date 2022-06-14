package com.ozkan.musicStore.Service;

import com.ozkan.musicStore.Model.User;
import com.ozkan.musicStore.Security.JWT.JwtProviderI;
import com.ozkan.musicStore.Security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements AuthServiceI
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProviderI jwtProvider;

    @Override
    public User signInReturnJWT(User requestSignIn)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestSignIn.getUsername(), requestSignIn.getPassword())
        );
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        String jwt = jwtProvider.generateToken(userPrincipal);

        User signInUser = userPrincipal.getUser();
        signInUser.setToken(jwt);

        return signInUser;
    }
}

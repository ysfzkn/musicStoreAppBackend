package com.ozkan.musicStore.Service;


import com.ozkan.musicStore.Model.User;

public interface AuthServiceI
{
    User signInReturnJWT(User requestSignIn);
}

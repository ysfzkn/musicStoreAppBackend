package com.ozkan.musicStore.Service;

import com.ozkan.musicStore.Model.User;

import java.util.Optional;

public interface UserServiceI
 {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeToAdmin(String username);
}

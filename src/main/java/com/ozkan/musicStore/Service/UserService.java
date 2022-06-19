package com.ozkan.musicStore.Service;

import com.ozkan.musicStore.Model.Role;
import com.ozkan.musicStore.Model.User;
import com.ozkan.musicStore.Repository.UserRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService implements UserServiceI
{
    @Autowired
    private UserRepositoryI userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user)
    {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER); // Default role defined
        user.setCreateTime(LocalDateTime.now());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional // This method level annotation is compulsory cause this is updating operation
    public void changeToAdmin(String username)
    {
        userRepository.updateUserRole(username, Role.ADMIN);
    }
}

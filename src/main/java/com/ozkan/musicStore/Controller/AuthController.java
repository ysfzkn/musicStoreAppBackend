package com.ozkan.musicStore.Controller;

import com.ozkan.musicStore.Model.User;
import com.ozkan.musicStore.Service.AuthServiceI;
import com.ozkan.musicStore.Service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController
{
    @Autowired
    private AuthServiceI authService;

    @Autowired
    private UserServiceI userService;

    @PostMapping("sign-up") //auth/sign-up
    public ResponseEntity<?> signUp(@RequestBody User user)
    {
        if (userService.findByUsername(user.getUsername()).isPresent())
        {
            System.out.println("User is present!");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        System.out.println("Controller working!");
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("sign-in") //auth/sign-in
    public ResponseEntity<?> singIn(@RequestBody User user)
    {
        return new ResponseEntity<>(authService.signInReturnJWT(user), HttpStatus.OK);
    }
}

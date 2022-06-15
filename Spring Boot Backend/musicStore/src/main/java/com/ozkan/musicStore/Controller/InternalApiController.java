package com.ozkan.musicStore.Controller;

import com.ozkan.musicStore.Service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("internal") // prepath
public class InternalApiController
{
    @Autowired
    private UserServiceI userService;

    @PutMapping("change-to-admin/{username}") //internal/change-to-admin/username
    public ResponseEntity<?> changeToAdmin(@PathVariable String username)
    {
        userService.changeToAdmin(username);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

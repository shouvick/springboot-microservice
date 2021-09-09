package com.shouvick.user.controller;

import com.shouvick.user.entity.User;
import com.shouvick.user.interaction.responseTemplateInteraction;
import com.shouvick.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("save user method called");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public responseTemplateInteraction getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("get user with department method called");
        return userService.getUserWithDepartment(userId);
    }

}

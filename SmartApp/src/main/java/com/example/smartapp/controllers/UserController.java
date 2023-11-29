/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.smartapp.controllers;

import com.example.smartapp.common.ApiResponse;
import com.example.smartapp.dto.ResponseDto;
import com.example.smartapp.dto.user.SignInDto;
import com.example.smartapp.dto.user.SignInReponseDto;
import com.example.smartapp.dto.user.SignupDto;
import com.example.smartapp.model.User;
import com.example.smartapp.repository.UserRepo;
import com.example.smartapp.service.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Star
 */
@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepository;

    @PostMapping("/signup")
    public ResponseDto signup(@RequestBody SignupDto signupDto) {
        return userService.signUp(signupDto);
    }


    

    @PostMapping("/signin")
    public SignInReponseDto signIn(@RequestBody SignInDto signInDto) {
        return userService.signIn(signInDto);
    }

    @PostMapping("/edit")
    public String userEdit(@RequestParam("id") User user, @RequestParam Map<String, String> form) {
        userService.changeUserRoles(user, form);
        return  "role has been updated";
      
    }

}
package com.example.pazarbox.api.controllers;

import com.example.pazarbox.business.abstracts.RegistrationService;
import com.example.pazarbox.core.utillities.results.Result;
import com.example.pazarbox.dataAccess.abstracts.UserDao;
import com.example.pazarbox.entity.concretes.DTOs.RegistrationRequest;
import com.example.pazarbox.entity.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    private final UserDao userDao;



    @PostMapping
    public Result register(@RequestBody RegistrationRequest request) {
        return registrationService.register (request);
    }

    @GetMapping(path = "confirm")
    public Result confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken (token);
    }

}

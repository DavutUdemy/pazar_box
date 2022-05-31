package com.example.pazarbox.core.utillities.validation;

import com.example.pazarbox.core.utillities.email.EmailValidatorManager;
import com.example.pazarbox.core.utillities.results.Result;
import com.example.pazarbox.dataAccess.abstracts.UserDao;
import com.example.pazarbox.entity.concretes.DTOs.RegistrationRequest;

public interface ValidationService {
    public Result takenEmail(String email);
    public Result isValid(String email);

}

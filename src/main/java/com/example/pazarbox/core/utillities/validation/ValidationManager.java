package com.example.pazarbox.core.utillities.validation;

import com.example.pazarbox.core.utillities.email.EmailValidatorManager;
import com.example.pazarbox.core.utillities.email.EmailValidatorService;
import com.example.pazarbox.core.utillities.results.Result;
import com.example.pazarbox.core.utillities.results.SuccessResult;
import com.example.pazarbox.dataAccess.abstracts.UserDao;
import com.example.pazarbox.entity.concretes.DTOs.RegistrationRequest;
import com.example.pazarbox.entity.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ValidationManager implements  ValidationService{
    private final EmailValidatorService emailValidatorService;
    private final UserDao userDao;
    @Override
    public Result takenEmail(String email) {
        Optional<User> userEmail = userDao.findUserByEmail (email);
        if(userEmail.isPresent ()){
            throw new IllegalStateException("There is an account which is linked with this email");
        }

        return new SuccessResult();
    }

    @Override
    public Result isValid(String email) {
        boolean checkIfEmailIsValid =  emailValidatorService.testEmail(email);
        if(!checkIfEmailIsValid){
            throw new IllegalStateException("Please enter valid email");
        }
        return new SuccessResult();
    }
}

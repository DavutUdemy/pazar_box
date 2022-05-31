package com.example.pazarbox.business.abstracts;

import com.example.pazarbox.core.utillities.email.EmailValidatorManager;
import com.example.pazarbox.core.utillities.results.Result;
import com.example.pazarbox.dataAccess.abstracts.UserDao;
import com.example.pazarbox.entity.concretes.DTOs.RegistrationRequest;

public interface RegistrationService {
    public Result register(RegistrationRequest request);
    public Result confirmToken(String token);
    public String buildEmail(String name,String link);

}

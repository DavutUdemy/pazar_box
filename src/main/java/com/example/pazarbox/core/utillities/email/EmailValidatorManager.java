package com.example.pazarbox.core.utillities.email;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class EmailValidatorManager implements EmailValidatorService {
    @Override
    public boolean testEmail(String s) {
        final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(s).matches();
    }

}


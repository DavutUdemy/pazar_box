package com.example.pazarbox.business.abstracts;

import com.example.pazarbox.entity.concretes.ConfirmationToken;

import java.util.Optional;

public interface ConfirmationTokenService {
    public void saveConfirmationToken(ConfirmationToken token);
    public Optional<ConfirmationToken> getToken(String token);
    public int setConfirmedAt(String token);
}

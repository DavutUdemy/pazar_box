package com.example.pazarbox.business.concretes;


import com.example.pazarbox.business.abstracts.ConfirmationTokenService;
import com.example.pazarbox.dataAccess.abstracts.ConfirmationTokenDao;
import com.example.pazarbox.entity.concretes.ConfirmationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmationTokenManager implements ConfirmationTokenService {

	private final ConfirmationTokenDao confirmationTokenRepository;
    @Override
	public void saveConfirmationToken(ConfirmationToken token) {
		confirmationTokenRepository.save (token);
	}
    @Override
	public Optional<ConfirmationToken> getToken(String token) {
		return confirmationTokenRepository.findByToken (token);
	}

	@Override
	public int setConfirmedAt(String token) {
		return confirmationTokenRepository.updateConfirmedAt (
				token, LocalDateTime.now ());
	}
}

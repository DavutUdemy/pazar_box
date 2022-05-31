package com.example.pazarbox.business.concretes;

import com.example.pazarbox.business.abstracts.UserService;
import com.example.pazarbox.dataAccess.abstracts.UserDao;
import com.example.pazarbox.entity.concretes.ConfirmationToken;
import com.example.pazarbox.entity.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserManager implements UserDetailsService, UserService {
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final UserDao userDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenManager confirmationTokenService;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public String signUp(User user) {
        String encodedPassword = bCryptPasswordEncoder
                .encode (user.getPassword ());

        user.setPassword (encodedPassword);

        userDao.save (user);

        String token = UUID.randomUUID ().toString ();

        ConfirmationToken confirmationToken = new ConfirmationToken (
                token,
                LocalDateTime.now (),
                LocalDateTime.now ().plusMinutes (15),
                user
        );

        confirmationTokenService.saveConfirmationToken (
                confirmationToken);

//        TODO: SEND EMAIL

        return token;

    }

    @Override
    public int updatePassword(String password, String email) {
        String encodedPassword = bCryptPasswordEncoder
                .encode (password);

        return userDao.updatePassword (encodedPassword,email);
    }
}

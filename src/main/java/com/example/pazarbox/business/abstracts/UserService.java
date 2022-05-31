package com.example.pazarbox.business.abstracts;

import com.example.pazarbox.entity.concretes.User;

public interface UserService {
    public String signUp(User user);
    public int updatePassword(String password, String email);
}

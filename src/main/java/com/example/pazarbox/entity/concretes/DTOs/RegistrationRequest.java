package com.example.pazarbox.entity.concretes.DTOs;


import com.example.pazarbox.entity.concretes.UserRole;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class  RegistrationRequest {
    @NotNull(message = "FirstName can not be null!")
    private final String firstName;
    @NotNull(message = "LastName can not be null!")
    private final String lastName;
    @NotNull(message = "Email can not be null!")
    private final String email;
    @NotNull(message = "Password can not be null!")
    private final String password;
    private final String phoneNumber;
    private final UserRole userRole;
}
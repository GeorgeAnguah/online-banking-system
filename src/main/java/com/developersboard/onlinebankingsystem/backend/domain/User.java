package com.developersboard.onlinebankingsystem.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data    // Activates setters and getters
@ToString(exclude = {"password"})
@NoArgsConstructor
@EqualsAndHashCode(of={"username", "email" })
public class User {

   private String username;
   private String password;
   private String firstName;
   private String lastName;
   private String address;
   private String dateOfBirth;
   private String phone;
   private String email;
   private String userType;

}

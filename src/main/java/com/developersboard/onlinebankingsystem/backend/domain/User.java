package com.developersboard.onlinebankingsystem.backend.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data    // Activates setters and getters
@ToString(exclude = {"password"})
@NoArgsConstructor
@EqualsAndHashCode(of = {"username", "email"})
public class User implements Serializable {

    private static final long serialVersionUID = -7742076060725830050L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

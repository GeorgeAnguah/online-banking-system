package com.developersboard.onlinebankingsystem.backend.domain;

import com.developersboard.onlinebankingsystem.enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data    // Activates setters,getters, hashcode and toString
@ToString(exclude = {"password"})
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"username", "email"})
@MappedSuperclass
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String firstName;
    private String lastName;
    private String address;
    private String dateOfBirth;
    private String phone;
    private String email;
    private String userType;

    @Enumerated(EnumType.STRING)
    private UserType type;

}

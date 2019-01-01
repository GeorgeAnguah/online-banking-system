package com.developersboard.onlinebankingsystem.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data    // generate setters and getters
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of = {"cardNumber"})
public class DebitCard implements Serializable {

    private static final long serialVersionUID = 4452439317547764192L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer cardNumber;
    private String cvv;
    private String expiredMonth;
    private String expiredYear;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", unique = true)
    private Customer customer;

}

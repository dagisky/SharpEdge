package com.sharpEdge.UserService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_sequence",
            sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
}

package com.techman.techmandatory2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User2 {

    @Id
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "host", nullable = false)
    private String host; //ip address

    private String firstName;
    private String lastName;
    private String password;

}

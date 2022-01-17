package com.techman.techmandatory2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString
public class OutsideUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String platform;

    @OneToMany(mappedBy = "outsideUser")
    Set<Friendship> friendships;


    public OutsideUser( String username, String platform) {
        this.username = username;
        this.platform = platform;
    }

}
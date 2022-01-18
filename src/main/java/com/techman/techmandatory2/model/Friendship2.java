package com.techman.techmandatory2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString
public class Friendship2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "friendshipId", nullable = false)
    private int friendshipId;

    @JoinColumn(name= "srcUser", referencedColumnName = "email", nullable =  false)
    private String srcUserEmail;

    @JoinColumn(name= "destUser", referencedColumnName = "email", nullable =  false)
    private String destUserEmail;

    @Column(name="status", nullable = false)
    private String status; //e.g. pending, accepted, denied, blocked

    public Friendship2(String srcUserEmail, String destUserEmail, String status) {
        this.srcUserEmail = srcUserEmail;
        this.destUserEmail = destUserEmail;
        this.status = status;
    }

}

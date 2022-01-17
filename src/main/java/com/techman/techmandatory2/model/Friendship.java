package com.techman.techmandatory2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Friendship {

    @EmbeddedId
    FriendshipKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("outsideUserId")
    @JoinColumn(name = "outsideUser_id")
    OutsideUser outsideUser;

    String status;
}

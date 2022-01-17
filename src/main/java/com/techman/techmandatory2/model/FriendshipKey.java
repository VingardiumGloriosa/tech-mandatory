package com.techman.techmandatory2.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@EqualsAndHashCode
public class FriendshipKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "outsideUser_id")
    Long courseId;
}

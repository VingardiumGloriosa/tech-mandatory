package com.techman.techmandatory2.repo;

import com.techman.techmandatory2.model.Friendship;
import com.techman.techmandatory2.model.FriendshipKey;
import com.techman.techmandatory2.model.OutsideUser;
import com.techman.techmandatory2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendshipRepo extends JpaRepository<Friendship, FriendshipKey> {
    List<Friendship> findByUserAndOutsideUser(User user, OutsideUser outsideUser);
}

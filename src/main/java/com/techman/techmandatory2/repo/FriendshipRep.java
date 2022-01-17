package com.techman.techmandatory2.repo;

import com.techman.techmandatory2.model.Friendship;
import com.techman.techmandatory2.model.FriendshipKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRep extends JpaRepository<Friendship, FriendshipKey> {
}

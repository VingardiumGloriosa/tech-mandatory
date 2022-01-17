package com.techman.techmandatory2.repo;

import com.techman.techmandatory2.model.OutsideUser;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OutsideUserRepo extends JpaRepository<OutsideUser, Long> {

    boolean existsByUsername(String username);
    Optional<OutsideUser> findByUsername(String username);
}


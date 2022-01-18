package com.example.demo.repo;

import com.example.demo.model.Friendship2;
import org.springframework.data.repository.CrudRepository;

public interface Friendship2Repo extends CrudRepository <Friendship2, Integer>{

    Friendship2 findBySrcUserEmailAndDestUserEmail(String srcUserEmail, String destUserEmail);

}

package com.techman.techmandatory2.repo;



import com.techman.techmandatory2.model.Friendship2;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Friendship2Repo extends CrudRepository <Friendship2, Integer>{

    Friendship2 findBySrcUserEmailAndDestUserEmail(String srcUserEmail, String destUserEmail);

}

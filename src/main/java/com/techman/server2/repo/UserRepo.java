package com.techman.server2.repo;


//import com.techman.server2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
//public interface UserRepo extends JpaRepository<User, Long> {
//    Optional<User> findByUsername(String username);
//    boolean existsByUsername(String username);

//    @Query(value = "SELECT * FROM user WHERE first_name LIKE %?1% OR last_name LIKE %?1% OR username LIKE %?1% ORDER BY first_name" , nativeQuery = true)
//    List<User> findAllByFirstNameContainingOrLastNameContainingOrUsernameContaining (@Param("search") String search);
//}

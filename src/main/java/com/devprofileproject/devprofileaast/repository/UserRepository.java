package com.devprofileproject.devprofileaast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devprofileproject.devprofileaast.User;

import java.util.Optional;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //User hwa el entity ele ehna shaghleen maaha, Integer bet refere lel ID

    // betedey functions gahza zay save, findById(int id), delete, findall()


    Optional<User> findByUsername(String Username);
    //Bet3ml Query lewahda "select * from User where Username = ?"

    Optional<User>  findByEmai(String emai);

    boolean existsByUsername (String username);

    boolean existsByEmail (String email);

}

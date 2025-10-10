package com.pard.server.seminar1.week3.inclass.user.repository;

import com.pard.server.seminar1.week3.inclass.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findAllByOrderByAgeDesc();
}

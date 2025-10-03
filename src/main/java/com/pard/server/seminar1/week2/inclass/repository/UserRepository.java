package com.pard.server.seminar1.week2.inclass.repository;

import com.pard.server.seminar1.week2.inclass.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    public Map<Long, User> userRepository = new HashMap<>();

    public void save(User user) {
        userRepository.put(user.getStudentId(), user);
    }

    public User findById(Long studentId) {
        return userRepository.get(studentId);
    }

    public List<User> findAll() {
        return userRepository.values().stream().toList();
    }

    public void deleteById(Long studentId) {
        userRepository.remove(studentId);
    }
}

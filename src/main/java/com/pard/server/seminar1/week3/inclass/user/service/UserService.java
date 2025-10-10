package com.pard.server.seminar1.week3.inclass.user.service;

import com.pard.server.seminar1.week3.inclass.user.dto.request.UserRequest;
import com.pard.server.seminar1.week3.inclass.user.dto.response.UserResponse;
import com.pard.server.seminar1.week3.inclass.user.entity.User;
import com.pard.server.seminar1.week3.inclass.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(UserRequest.UserInfo request) {
//        User user = User.builder()
//                .age(request.getAge())
//                .name(request.getName())
//                .email(request.getEmail())
//                .password(request.getPassword())
//                .build();

        User user = request.toEntity();
        userRepository.save(user);
    }

    public UserResponse.Name readName(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        return UserResponse.Name.builder()
                .name(user.getName())
                .build();
    }

    public Long getUserNum(String email){
        User user = userRepository.findByEmail(email);

        return user.getId();
    }

    public List<UserResponse.AgeEmail> readAgeEmail() {
        List<User> users = userRepository.findAllByOrderByAgeDesc();

        return users.stream().map(user ->
                UserResponse.AgeEmail.builder()
                        .age(user.getAge())
                        .email(user.getEmail())
                        .build()).toList();
    }

    @Transactional
    public void update(Long userId, UserRequest.UserInfo request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        user.updateEmail(request.getEmail());
    }
}

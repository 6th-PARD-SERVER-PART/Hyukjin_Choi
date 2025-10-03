package com.pard.server.seminar1.week2.inclass.service;

import com.pard.server.seminar1.week2.inclass.dto.UserDto;
import com.pard.server.seminar1.week2.inclass.dto.UserResponseDto;
import com.pard.server.seminar1.week2.inclass.entity.User;
import com.pard.server.seminar1.week2.inclass.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        User user = User.builder()
                .studentId(userDto.getStudentId())
                .studentName(userDto.getStudentName())
                .age(userDto.getAge())
                .email(userDto.getEmail())
                .build();

        userRepository.save(user);
    }

    public UserDto findById(Long studentId) {
        User user = userRepository.findById(studentId);

        return UserDto.builder()
                .studentId(user.getStudentId())
                .studentName(user.getStudentName())
                .age(user.getAge())
                .email(user.getEmail())
                .build();
    }

    public UserResponseDto findNameAndAge(Long studentId) {
        User user = userRepository.findById(studentId);

        return UserResponseDto.builder()
                .studentName(user.getStudentName())
                .age(user.getAge())
                .build();
    }

    public List<UserDto> findAll() {
        List<UserDto> userDtos = new ArrayList<>();

        userRepository.findAll().forEach(user->{
            UserDto userDto = UserDto.builder()
                    .studentId(user.getStudentId())
                    .studentName(user.getStudentName())
                    .age(user.getAge())
                    .email(user.getEmail())
                    .build();
            userDtos.add(userDto);
        });

        return userDtos;
    }

    public void updateById(Long studentId, UserDto userDto) {
        User user = userRepository.findById(studentId);
        user.updateStudentName(userDto.getStudentName());

        userRepository.save(user);
    }

    public void deleteById(Long studentId) {
        userRepository.deleteById(studentId);
    }
}

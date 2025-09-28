package com.pard.server.seminar1.week2.controller;

import com.pard.server.seminar1.week2.dto.UserDto;
import com.pard.server.seminar1.week2.dto.UserResponseDto;
import com.pard.server.seminar1.week2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public String save(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return "저장완료!!";
    }

    @GetMapping("/{studentId}")
    public UserDto findById(@PathVariable Long studentId) {
        return userService.findById(studentId);
    }

    @GetMapping("/{studentId}/nameAndAge")
    public UserResponseDto findNameAndAge(@PathVariable Long studentId) {
        return userService.findNameAndAge(studentId);
    }

    @PatchMapping("/{studentId}")
    public String updateById(@PathVariable Long studentId, @RequestBody UserDto userDto) {
        userService.updateById(studentId, userDto);
        return "수정완료~";
    }

    @DeleteMapping("{studentId}")
    public String deleteById(@PathVariable Long studentId) {
        userService.deleteById(studentId);
        return "삭제완료~";
    }

    @GetMapping("")
    public List<UserDto> finaAll() {
        return userService.findAll();
    }
}

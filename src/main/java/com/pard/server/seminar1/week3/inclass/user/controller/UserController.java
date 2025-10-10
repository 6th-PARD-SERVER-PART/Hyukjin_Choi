package com.pard.server.seminar1.week3.inclass.user.controller;

import com.pard.server.seminar1.week3.inclass.user.dto.request.UserRequest;
import com.pard.server.seminar1.week3.inclass.user.dto.response.UserResponse;
import com.pard.server.seminar1.week3.inclass.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wk3/inclass/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("")
    public void save(@RequestBody UserRequest.UserInfo request) {
        userService.save(request);
    }

    @GetMapping("/{userId}/name")
    public ResponseEntity<?> readName(@PathVariable Long userId) {
        try {
            UserResponse.Name name = userService.readName(userId);
            return ResponseEntity.ok(name);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{email}/userNum")
    public ResponseEntity<Long> readByEmail(@PathVariable String email) {
        Long responseValue = userService.getUserNum(email);
        return new ResponseEntity<>(responseValue, HttpStatus.OK);
    }

    @GetMapping("sortAge")
    public List<UserResponse.AgeEmail> readAgeEmail() {
        return userService.readAgeEmail();
    }

    @PatchMapping("/{userId}")
    public void update(@PathVariable Long userId, @RequestBody UserRequest.UserInfo request) {
        userService.update(userId, request);
    }
}

package com.pard.server.seminar1.week3.inclass.user.dto.request;

import com.pard.server.seminar1.week3.inclass.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequest {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class UserInfo {
        private String name;
        private String email;
        private String password;
        private int age;

        public User toEntity() {
            return User.of(name,email,password,age);
        }
    }
}

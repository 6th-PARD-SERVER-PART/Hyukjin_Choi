package com.pard.server.seminar1.week3.inclass.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserResponse {

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Name{
        private String name;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class AgeEmail{
        private int age;
        private String email;
    }
}

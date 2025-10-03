package com.pard.server.seminar1.week2.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    private Long id;
    private String name;
    private String email;
    private String password;

    public static Member of(
            Long id,
            String name,
            String email,
            String password
    ) {
        return Member.builder()
                .id(id)
                .name(name)
                .email(email)
                .password(password)
                .build();
    }

    public void updateMemberName(String name) {
        this.name = name;
    }
}

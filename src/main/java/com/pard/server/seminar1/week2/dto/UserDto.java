package com.pard.server.seminar1.week2.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @Builder
public class UserDto {
    private Long studentId;
    private String studentName;
    private int age;
    private String email;
}

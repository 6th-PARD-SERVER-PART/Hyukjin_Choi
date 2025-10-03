package com.pard.server.seminar1.week2.inclass.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long studentId;
    private String studentName;
    private int age;
    private String email;

    public void updateStudentName(String studentName) {
        this.studentName = studentName;
    }
}

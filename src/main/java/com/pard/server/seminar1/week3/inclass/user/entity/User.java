package com.pard.server.seminar1.week3.inclass.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @jakarta.persistence.Id //이 어노테이션이 뭐더라
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    private String password;

    private int age;

    public static User of (
            String name,
            String email,
            String password,
            int age
    ) {
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .age(age)
                .build();
    }

    public void updateEmail(String newEmail) {
        this.email = newEmail;
    }

}

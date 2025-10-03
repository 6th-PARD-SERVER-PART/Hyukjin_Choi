package com.pard.server.seminar1.week2.homework.dto;


import com.pard.server.seminar1.week2.homework.entity.Member;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MemberCreateRequest {
    private Long id;
    private String name;
    private String email;
    private String password;

    public Member toEntity(){
        return Member.of(
                id,
                name,
                email,
                password
        );
    }
}

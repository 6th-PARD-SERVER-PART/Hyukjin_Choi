package com.pard.server.seminar1.week2.homework.dto;

import com.pard.server.seminar1.week2.homework.entity.Member;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MemberDetailResponse {
    private String name;
    private String email;

    public static MemberDetailResponse fromEntity(Member member
    ) {
        return MemberDetailResponse.builder()
                .name(member.getName())
                .email(member.getEmail())
                .build();
    }
}


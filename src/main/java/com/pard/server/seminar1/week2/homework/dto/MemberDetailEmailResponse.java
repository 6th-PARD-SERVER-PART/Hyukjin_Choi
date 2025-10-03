package com.pard.server.seminar1.week2.homework.dto;

import com.pard.server.seminar1.week2.homework.entity.Member;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MemberDetailEmailResponse {
    private String email;

    public static MemberDetailEmailResponse fromEntity(Member member
    ) {
        return MemberDetailEmailResponse.builder()
                .email(member.getEmail())
                .build();
    }
}

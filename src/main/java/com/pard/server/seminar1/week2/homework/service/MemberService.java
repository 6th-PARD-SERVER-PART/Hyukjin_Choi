package com.pard.server.seminar1.week2.homework.service;

import com.pard.server.seminar1.week2.homework.dto.MemberCreateRequest;
import com.pard.server.seminar1.week2.homework.dto.MemberDetailEmailResponse;
import com.pard.server.seminar1.week2.homework.dto.MemberDetailResponse;
import com.pard.server.seminar1.week2.homework.dto.MemberUpdateRequest;
import com.pard.server.seminar1.week2.homework.entity.Member;
import com.pard.server.seminar1.week2.homework.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void createMember(MemberCreateRequest request) {
        Member member = request.toEntity();

        memberRepository.save(member);
    }

    public MemberDetailResponse findById(Long memberId) {
        Member member = memberRepository.findById(memberId);

        return MemberDetailResponse.fromEntity(member);
    }

    public MemberDetailEmailResponse findEmailById(Long memberId) {
        Member member = memberRepository.findById(memberId);

        return MemberDetailEmailResponse.fromEntity(member);
    }

    public void updateMemberNameById(Long memberId, MemberUpdateRequest request) {
        Member member = memberRepository.findById(memberId);
        member.updateMemberName(request.getName());

        memberRepository.save(member);
    }

    public void deleteById(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    public List<MemberDetailResponse> findAll() {
        List<MemberDetailResponse> responses = new ArrayList<>();

        memberRepository.findAll().forEach(member ->{
            MemberDetailResponse memberDetailResponse = MemberDetailResponse.fromEntity(member);
            responses.add(memberDetailResponse);
        });

        return responses;
    }
}

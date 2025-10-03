package com.pard.server.seminar1.week2.homework.repository;

import com.pard.server.seminar1.week2.homework.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {
    public Map<Long, Member> memberRepository = new HashMap<>();

    public void save(Member member) {
        memberRepository.put(member.getId(), member);
    }

    public Member findById(Long memberId) {
        return memberRepository.get(memberId);
    }

    public List<Member> findAll() {
        return memberRepository.values().stream().toList();
    }

    public void deleteById(Long memberId) {
        memberRepository.remove(memberId);
    }


}

package com.pard.server.seminar1.week2.homework.controller;

import com.pard.server.seminar1.week2.homework.dto.MemberCreateRequest;
import com.pard.server.seminar1.week2.homework.dto.MemberDetailEmailResponse;
import com.pard.server.seminar1.week2.homework.dto.MemberDetailResponse;
import com.pard.server.seminar1.week2.homework.dto.MemberUpdateRequest;
import com.pard.server.seminar1.week2.homework.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("wk2/homework/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("")
    public String create(@RequestBody MemberCreateRequest request) {
        memberService.createMember(request);
        return "저장완료!!";
    }

    @GetMapping("/{studentId}")
    public MemberDetailResponse findByById(@PathVariable Long studentId) {
        return memberService.findById(studentId);
    }

    @GetMapping("/{studentId}/nameAndAge")
    public MemberDetailEmailResponse findByEmail(@PathVariable Long studentId) {
        return memberService.findEmailById(studentId);
    }

    @PatchMapping("/{studentId}")
    public String updateById(@PathVariable Long studentId, @RequestBody MemberUpdateRequest request) {
        memberService.updateMemberNameById(studentId, request);
        return "수정완료~";
    }

    @DeleteMapping("{studentId}")
    public String deleteById(@PathVariable Long studentId) {
        memberService.deleteById(studentId);
        return "삭제완료~";
    }

    @GetMapping("")
    public List<MemberDetailResponse> finaAll() {
        return memberService.findAll();
    }
}



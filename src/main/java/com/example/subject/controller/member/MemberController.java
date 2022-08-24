package com.example.subject.controller.member;

import com.example.subject.dto.SignupForm;
import com.example.subject.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String signupForm() {

        return "/member/signup";
    }

    @GetMapping("/login")
    public String login() {
        return "/member/login";
    }

    @PostMapping("/login")
    public void lgoin(SignupForm signupForm) {
        memberService.login(signupForm);
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute SignupForm signupForm) {
        memberService.createMember(signupForm);

        return "/member/signup";
    }
}

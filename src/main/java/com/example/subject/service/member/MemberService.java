package com.example.subject.service.member;

import com.example.subject.dao.MemberMapper;
import com.example.subject.domain.Member;
import com.example.subject.dto.SignupForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public void createMember(SignupForm signupForm) {
        String encodedPassword = passwordEncoder.encode(signupForm.getPassword());
        Member newMember = Member.builder()
                .username(signupForm.getUsername())
                .password(encodedPassword).build();
        memberMapper.save(newMember);

    }

    public Member findMember(String username) {
        Member findMember = memberMapper.findByUsername(username);
        return findMember;
    }

    public void login(SignupForm signupForm) {
        String rawPassword = signupForm.getPassword();
        Member member = findMember(signupForm.getUsername());
        if (passwordEncoder.matches(rawPassword, member.getPassword()) && passwordEncoder.upgradeEncoding(member.getPassword()) ){
            String encodedPassword = passwordEncoder.encode(signupForm.getPassword());
            member.setPassword(encodedPassword);
            updatePassword(member);
        }
//        passwordEncoder.upgradeEncoding(member.getPassword());
//        System.out.println(passwordEncoder.upgradeEncoding(member.getPassword()));
        System.out.println(passwordEncoder.matches(rawPassword, member.getPassword()));

    }

    private void updatePassword(Member member) {
        String encodedPassword = passwordEncoder.encode(member.getPassword());
        memberMapper.updatePassword(member);

    }
}

package com.example.subject.dao;

import com.example.subject.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void save(Member member);

    Member findByUsername(String username);

    void updatePassword(Member member);
}

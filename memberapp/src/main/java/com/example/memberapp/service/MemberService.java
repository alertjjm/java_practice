package com.example.memberapp.service;
import com.example.memberapp.model.Member;
public interface MemberService {
    void save(Member member);
    Member findByUserName(String username);
    Member findByUserEmail(String email);
}

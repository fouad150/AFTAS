package com.example.demo.service;

import com.example.demo.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    boolean isExistsByNumber(Integer number);
    Member save(Member member);
    Member findByNumber(Integer number);
    Member findMemberByNumber(Integer number);

    List<Member> findByFirstNameOrLastName(String firstName,String lastName);

    Optional<Member> findById(Long id);

}

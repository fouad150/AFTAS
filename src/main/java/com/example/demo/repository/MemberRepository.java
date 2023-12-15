package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByNumber(Integer number);
    Member findByNumber(Integer number);
    Optional<Member> findMemberByNumber(Integer number);
    List<Optional<Member>> findByFirstNameOrLastName(String firstName,String lastName);

}

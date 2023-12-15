package com.example.demo.service.impl;

import com.example.demo.entity.Member;
import com.example.demo.exception.DoesNoExistException;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository  memberRepository;
    @Override
    public boolean isExistsByNumber(Integer number){
        return memberRepository.existsByNumber(number);
    }

    @Override
    public Member save(Member member){
        return memberRepository.save(member);
    }
    @Override
    public Member findByNumber(Integer number){
        return memberRepository.findByNumber(number);
    }

    @Override
    public Member findMemberByNumber(Integer number){
        Optional<Member> memberOptional=memberRepository.findMemberByNumber(number);
        if(memberOptional.isPresent()){
            return memberOptional.get();
        }else{
            throw new DoesNoExistException("there is no member with this number");
        }
    }

    @Override
    public List<Member> findByFirstNameOrLastName(String firstName, String lastName){
        List<Optional<Member>> optionalList=memberRepository.findByFirstNameOrLastName(firstName,lastName);
        if(optionalList.isEmpty()){
            throw new DoesNoExistException("there is no member with this keyword");
        }else{
            List<Member> members=optionalList.stream().flatMap(Optional::stream).toList();
            return members;
        }
    }
    @Override
    public Optional<Member> findById(Long id){
        return memberRepository.findById(id);
    }


}

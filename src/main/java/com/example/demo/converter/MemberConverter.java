package com.example.demo.converter;

import com.example.demo.DTO.MemberDTO;
import com.example.demo.entity.Member;

public class MemberConverter {
    public static Member convertToEntity(MemberDTO memberDTO) {
        Member member = new Member();
        member.setNumber(memberDTO.getNumber());
        member.setFirstName(memberDTO.getFirstName());
        member.setLastName(memberDTO.getLastName());
        member.setAccessionDate(memberDTO.getAccessionDate());
        member.setNationality(memberDTO.getNationality());
        member.setIdentityNumber(memberDTO.getIdentityNumber());
        member.setIdentityDocument(memberDTO.getIdentityDocument());
        return member;
    }

    public static MemberDTO convertToDTO(Member member){
        MemberDTO memberDTO=new MemberDTO();
        memberDTO.setNumber(member.getNumber());
        memberDTO.setFirstName(member.getFirstName());
        memberDTO.setLastName(member.getLastName());
        memberDTO.setAccessionDate(member.getAccessionDate());
        memberDTO.setNationality(member.getNationality());
        memberDTO.setIdentityNumber(member.getIdentityNumber());
        memberDTO.setIdentityDocument(member.getIdentityDocument());
        return memberDTO;
    }
}

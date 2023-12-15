package com.example.demo.controller;

import com.example.demo.entity.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/members/{keyword}")
    public ResponseEntity<?> getMember(@PathVariable("keyword") String keyword) {

            try{
                int number = Integer.parseInt(keyword);
                Member member=memberService.findMemberByNumber(number);
                return new ResponseEntity<>(member, HttpStatus.OK);
            } catch (NumberFormatException e){
                List<Member> members=memberService.findByFirstNameOrLastName(keyword,keyword);
                return new ResponseEntity<>(members,HttpStatus.OK);
            }
    }

    }
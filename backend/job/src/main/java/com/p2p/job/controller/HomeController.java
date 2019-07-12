package com.p2p.job.controller;

import java.util.stream.IntStream;

import com.p2p.job.entity.Member;
import com.p2p.job.repository.MemberRepository;
import com.p2p.job.repository.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String Home(){
        
        return "index";
    }
}
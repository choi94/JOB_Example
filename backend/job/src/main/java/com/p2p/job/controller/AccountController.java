package com.p2p.job.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8000", maxAge = 3600)
@RestController
@RequestMapping("/account")
public class AccountController {

    
}
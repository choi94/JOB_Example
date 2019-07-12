package com.p2p.job;



import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.p2p.job.entity.Member;
import com.p2p.job.entity.Profile;
import com.p2p.job.repository.MemberRepository;
import com.p2p.job.repository.ProfileRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class JobApplicationTests {

	@Autowired
	MemberRepository memberRepo;

	@Autowired
    ProfileRepository profileRepo;

	@Test
	public void contextLoads() {
		
	}

}

package com.p2p.job.repository;

import java.util.List;

import com.p2p.job.entity.Member;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, String>{
    
}
package com.p2p.job.repository;

import com.p2p.job.entity.Profile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long>{
    
}
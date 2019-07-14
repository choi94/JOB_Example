package com.p2p.job.repository;

import com.p2p.job.entity.PDSBoard;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PDSBoardRepository extends CrudRepository<PDSBoard, Long> {

    @Modifying
    @Query("UPDATE FROM PDSFile f set f.pdsfile = :newFileName WHERE f.fno = :fno")
    public int updatePDSFile(Long fno, String newFileName);

}
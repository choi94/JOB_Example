package com.p2p.job.repository;

import java.util.List;

import com.p2p.job.entity.FreeBoard;

import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeBoardRepository extends CrudRepository<FreeBoard, Long>, QuerydslPredicateExecutor<FreeBoard> {
    public List<FreeBoard> findByBnoGreaterThan(Long bno, Pageable page);

    // @Query("SELECT b.no, b.title, b.content, b.writer FROM " +
    //         "FreeBoard b LEFT OUTER JOIN b.replies r " +
    //         "WHERE b.bno > 0 GROUP BY b.no")

}
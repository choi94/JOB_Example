package com.p2p.job;






import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.p2p.job.entity.FreeBoard;
import com.p2p.job.entity.FreeBoardReply;
import com.p2p.job.entity.QFreeBoard;
import com.p2p.job.entity.QFreeBoardReply;
import com.p2p.job.repository.FreeBoardReplyRepository;
import com.p2p.job.repository.FreeBoardRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryFactory;
import static com.querydsl.core.group.GroupBy.*;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class JobApplicationTests {

	@Autowired
	FreeBoardRepository boardRepo;

	@Autowired
	FreeBoardReplyRepository replyRepo;

	@Autowired
	JPAQueryFactory queryFactory;

	@Test
	@Transactional
	public void contextLoads() {
			QFreeBoard boards = QFreeBoard.freeBoard;
			QFreeBoardReply boardReply = QFreeBoardReply.freeBoardReply;

			Map<FreeBoard, List<FreeBoardReply>> transform = queryFactory
				.from(boards)
				.leftJoin(boards.replies, boardReply)
				.transform(groupBy(boards).as(list(boardReply)));
			System.out.println("시작");
			transform.forEach( (board,replies) -> {
				System.out.println("===================================");
				System.out.println(board.toString());
				System.out.println(replies.toString()); 
				System.out.println("===================================");
			});

		// Optional<FreeBoard> result = boardRepo.findById(199L);

		// result.ifPresent(board -> {
		// 	System.out.println("시작임!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		// 	System.out.println(board);
		// 	System.out.println(board.getReplies().toString());


		// 	List<FreeBoardReply> replies = board.getReplies();

			
		// 	for ( int i = 7; i <= 10; i++) {
		// 		FreeBoardReply reply = new FreeBoardReply();
		// 		reply.setReply("REPLY......" + i);
		// 		reply.setReplyer("replyer0" + i);
		// 		reply.setBoard(board);

		// 		replies.add(reply);

		// 		board.setReplies(replies);

		// 		boardRepo.save(board);
		// 	}
			
		// });
		

		// BooleanBuilder builder = new BooleanBuilder();
		// QFreeBoard boards = QFreeBoard.freeBoard;
		// QFreeBoardReply boardReply = QFreeBoardReply.freeBoardReply;
		
		// List<Object> result = new ArrayList<>();




		// queryFactory.from(boards)
		// 	// .leftJoin(boardReply.board, boards).fetchJoin()
		// 	// .on(boards.bno.eq(boardReply.rno))
		// 	// .where(boards.writer.eq("user0"))
		// 	// .orderBy(boards.bno.desc())
		// 	.fetch()
		// 	.forEach(arr -> {
		// 		result.add(arr);
		// 	});

		// 	result.forEach(System.out::println);

		// builder.and(boards.bno.gt(190L));

		// boardRepo.findAll(builder).forEach(System.out::println);

		// Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");

		// boardRepo.findByBnoGreaterThan(0L, page).forEach(board -> {
		// 	log.info(board.getBno() + " : " + board.getTitle() + " : " + board.getReplies().toString());
		// });
		}
}

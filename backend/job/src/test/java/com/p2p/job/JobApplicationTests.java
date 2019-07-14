package com.p2p.job;






import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.p2p.job.entity.QFreeBoard;
import com.p2p.job.entity.QFreeBoardReply;
import com.p2p.job.repository.FreeBoardReplyRepository;
import com.p2p.job.repository.FreeBoardRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

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
	FreeBoardRepository boardRepo;

	@Autowired
	FreeBoardReplyRepository replyRepo;

	@Autowired
	JPAQueryFactory queryFactory;

	@Test
	@Transactional
	public void contextLoads() {

		// Optional<FreeBoard> result = boardRepo.findById(199L);

		// result.ifPresent(board -> {
		// 	System.out.println("시작임!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		// 	System.out.println(board);
		// 	System.out.println(board.getReplies().toString());
		// 	List<FreeBoardReply> replies = board.getReplies();

		// 	FreeBoardReply reply = new FreeBoardReply();
		// 	reply.setReply("REPLY......");
		// 	reply.setReplyer("replyer00");
		// 	reply.setBoard(board);

		// 	replies.add(reply);

		// 	board.setReplies(replies);

		// 	boardRepo.save(board);
		// });
		

		// BooleanBuilder builder = new BooleanBuilder();
		QFreeBoard boards = QFreeBoard.freeBoard;
		QFreeBoardReply boardReply = QFreeBoardReply.freeBoardReply;

		queryFactory.from(boards)
			.join(boards.replies, boardReply)
			// .on(boards.bno.eq(boardReply.rno))
			// .where(boards.writer.eq("user0"))
			// .orderBy(boards.bno.desc())
			.fetch()
			.forEach(System.out::println);

		// builder.and(boards.bno.gt(190L));

		// boardRepo.findAll(builder).forEach(System.out::println);

		// Pageable page = PageRequest.of(2, 10, Sort.Direction.DESC, "bno");

		// boardRepo.findByBnoGreaterThan(0L, page).forEach(board -> {
		// 	log.info(board.getBno() + " : " + board.getTitle());
		// });
	}

}

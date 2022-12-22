package hello.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import hello.model.BoardQuestion;
import hello.model.User;
import hello.repository.BoardQuestionRepository;

@Transactional(readOnly = true)
@Service
public class BoardQuestionService {
	@Autowired
	private BoardQuestionRepository bqrepository;

	@Transactional
	public void boardQuestioninsert(BoardQuestion board, User user, String uploadFolder) {
		UUID uuid = UUID.randomUUID();
		MultipartFile b = board.getUploadquestion();
		String uploadFileName = "";
		if (!b.isEmpty()) {
			uploadFileName = uuid.toString() + "_" + b.getOriginalFilename();
			File saveFile = new File(uploadFolder, uploadFileName);
			try {
				b.transferTo(saveFile);
				board.setQuestionimage(uploadFileName);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		board.setUser(user);
		bqrepository.save(board);
	}

	/*
	 * 페에징 없는 전체보기 public List<Board> findAll(){ return repository.findAll();
	 * 
	 * }
	 */
	
//	// 페이징 포함 전체보기
//	public Page<BoardQuestion> findAll(Pageable pageable) {
//		Page<BoardQuestion> lists = repository.findAll(pageable);// 아무 검색 없을때
//		return lists;
//	}

	// 페이징,검색 포함 전체보기
	public Page<BoardQuestion> findAll(String field, String word, Pageable pageable) {

		Page<BoardQuestion> lists = bqrepository.findAll(pageable);// 아무 검색 없을때
		if (field.equals("title")) {
			lists = bqrepository.findByTitleContaining(word, pageable);
		} else if (field.equals("content")) {
			lists = bqrepository.findByContentContaining(word, pageable);
		}
		return lists;
	}

	public Long count(String field, String word) {
		Long count = bqrepository.count();
		if(field.equals("title")) {
			count=bqrepository.cntTitleSearch(word);
		}else if (field.equals("content")){
			count=bqrepository.cntContentSearch(word);
		}
		return count;
	}

	public Long count() {
		return bqrepository.count();
	}

	@Transactional
	public BoardQuestion findById(Long questionID) {
		BoardQuestion board = bqrepository.findById(questionID).get();
		board.setHitcount(board.getHitcount() + 1);
		return board;

	}

	public BoardQuestion detail(Long questionID) {
		return bqrepository.findById(questionID).get();
	}

	@Transactional
	public void bqdelete(Long questionID) {
		bqrepository.deleteById(questionID);
	}

	@Transactional
	public void bqupdate(BoardQuestion board) {
		BoardQuestion b = bqrepository.findById(board.getQuestionID()).get();
		b.setTitle(board.getTitle());
		b.setContent(board.getContent());
		b.setRegdate(new Date());

	}

}

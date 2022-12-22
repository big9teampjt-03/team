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

import hello.model.BoardCounsel;
import hello.model.User;
import hello.repository.BoardCounselRepository;

@Transactional(readOnly = true)
@Service
public class BoardCounselService {
	@Autowired
	private BoardCounselRepository bcrepository;

	@Transactional
	public void boardCounselinsert(BoardCounsel board,User user,String uploadFolder) {
		UUID uuid = UUID.randomUUID();
		MultipartFile b= board.getUploadcounsel();
		String uploadFileName="";
		if(!b.isEmpty()) {
			uploadFileName=uuid.toString()+"_"+b.getOriginalFilename();
			File saveFile=new File(uploadFolder,uploadFileName);
			try {
				b.transferTo(saveFile);
				board.setCounselimage(uploadFileName);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		board.setUser(user);
		bcrepository.save(board);
	}

	/*
	 * 페에징 없는 전체보기 public List<Board> findAll(){ return repository.findAll();
	 * 
	 * }
	 */

	//페이징 포함 전체보기
//	 public Page<BoardCounsel> findAll(Pageable pageable) {  
//			Page<BoardCounsel> lists = repository.findAll(pageable);// 아무 검색 없을때
//			  return lists; 
//			  }
	
	// 페이징,검색 포함 전체보기
	public Page<BoardCounsel> findAll(String field, String word, Pageable pageable) {

		Page<BoardCounsel> lists = bcrepository.findAll(pageable);// 아무 검색 없을때
		if (field.equals("title")) {
			lists = bcrepository.findByTitleContaining(word, pageable);
		} else if (field.equals("content")) {
			lists = bcrepository.findByContentContaining(word, pageable);
		}

		return lists;
	}

	 public Long count(String field, String word) {
			Long count = bcrepository.count();
			if(field.equals("title")) {
				count=bcrepository.cntTitleSearch(word);
			}else if (field.equals("content")){
				count=bcrepository.cntContentSearch(word);
			}
			return count;
		}

	public Long count() {
		return bcrepository.count();
	}

	@Transactional
	public BoardCounsel findById(Long counselID) {
		BoardCounsel board = bcrepository.findById(counselID).get();
		board.setHitcount(board.getHitcount() + 1);
		return board;

	}

	public BoardCounsel detail(Long counselID) {
		return bcrepository.findById(counselID).get();
	} 
	
	@Transactional 
	public void bcdelete(Long counselID) {
		bcrepository.deleteById(counselID);
	}

	@Transactional
	public void bcupdate(BoardCounsel board,String uploadFolder) {
		UUID uuid = UUID.randomUUID();
		MultipartFile b= board.getUploadcounsel();
		String uploadFileName="";
		if(!b.isEmpty()) {
			uploadFileName=uuid.toString()+"_"+b.getOriginalFilename();
			File saveFile=new File(uploadFolder,uploadFileName);
			try {
				b.transferTo(saveFile);
				board.setCounselimage(uploadFileName);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		bcrepository.save(board);
		BoardCounsel bc =bcrepository.findById(board.getCounselID()).get();
		bc.setTitle(board.getTitle());
		bc.setContent(board.getContent());
		bc.setRegdate(new Date());
		bc.setUploadcounsel(board.getUploadcounsel());
		bc.setCounselimage(board.getCounselimage());

	}

}

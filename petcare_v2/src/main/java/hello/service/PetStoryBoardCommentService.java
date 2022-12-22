package hello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hello.model.BoardPetstory;
import hello.model.CommentPetStory;
import hello.repository.PetStoryBoardCommentRepository;
import hello.repository.PetStoryBoardRepository;

@Service
public class PetStoryBoardCommentService {

	@Autowired
	private PetStoryBoardCommentRepository petStoryBoardCommentRepository;
	@Autowired
	private PetStoryBoardRepository petStoryBoardRepository;

	@Transactional
	public void insert(CommentPetStory petStoryBoardComment) {

		BoardPetstory bpsboard = petStoryBoardRepository.findById(petStoryBoardComment.getBPetstoryl().getPetstoryID())
				.get();
		bpsboard.setReplycnt(bpsboard.getReplycnt() + 1);

		petStoryBoardCommentRepository.insert(petStoryBoardComment.getContent(),
				petStoryBoardComment.getBPetstoryl().getPetstoryID(), petStoryBoardComment.getUser().getUsername(),
				petStoryBoardComment.getUser().getUserid());

		// petStoryBoardCommentRepository.save(petStoryBoardComment);

	}

	/*
	 * public List<CommentPetStory> list(Long petstoryID) { return
	 * petStoryBoardCommentRepository.findByPetStoryId(petstoryID); }
	 */

	public List<CommentPetStory> list(Long petstoryID) {
		return petStoryBoardCommentRepository.list(petstoryID);
	}

	public int getCount(Long petstoryID) {
		return petStoryBoardCommentRepository.getCount(petstoryID);
	}

	@Transactional
	public void delete(Long competstoryID) {
		Optional<CommentPetStory> c = petStoryBoardCommentRepository.findById(competstoryID);
		BoardPetstory b = c.get().getBPetstoryl();
		b.setReplycnt(b.getReplycnt() - 1);
		petStoryBoardCommentRepository.deleteById(competstoryID);
	}

}

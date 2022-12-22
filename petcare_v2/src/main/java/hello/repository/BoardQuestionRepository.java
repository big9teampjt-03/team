package hello.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hello.model.BoardQuestion;

public interface BoardQuestionRepository extends JpaRepository<BoardQuestion, Long> {
	
	public Page<BoardQuestion> findByTitleContaining(String title, Pageable pageable);

	public Page<BoardQuestion> findByContentContaining(String title, Pageable pageable);

	// 제목검색개수

	@Query(value = "select count(*) from board_question where title like CONCAT('%',:word,'%')", nativeQuery = true)
	public Long cntTitleSearch(@Param("word") String word);

	@Query(value = "select count(*) from board_question where title like CONCAT('%',:word,'%')", nativeQuery = true)
	public Long cntContentSearch(@Param("word") String word);

}

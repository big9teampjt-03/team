package hello.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hello.model.BoardCounsel;

public interface BoardCounselRepository extends JpaRepository<BoardCounsel, Long> {

	public Page<BoardCounsel> findByTitleContaining(String title, Pageable pageable);

	public Page<BoardCounsel> findByContentContaining(String title, Pageable pageable);

	// 제목검색개수

	@Query(value = "select count(*) from board_counsel where title like CONCAT('%',:word,'%')", nativeQuery = true)
	public Long cntTitleSearch(@Param("word") String word);

	@Query(value = "select count(*) from board_counsel where title like CONCAT('%',:word,'%')", nativeQuery = true)
	public Long cntContentSearch(@Param("word") String word);

}

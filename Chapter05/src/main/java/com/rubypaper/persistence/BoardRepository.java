package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rubypaper.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	
//	List<Board> findByTitile(String title);
//	List<Board> findByContentContaining(String searchKeyword);
//	List<Board> findByTitileContainingOrcontentContaining(String title, String content);
//	List<Board> findByTitileContainingOrderBySeqDesc(String searchKeyword);
//	Page<Board> findByTitileContaining(String searchKeyword, Pageable paging);
//	
//	

}

package com.rubypaper.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {
	
	private final BoardRepository boardRepo;
	
	@GetMapping("/board")
	public List<Board> getBoards(){
		return boardRepo.findAll();
		
				
	}
	
	@GetMapping("/board/{seq}") //url같으면 오류남
	public Board getBoard(@PathVariable Long seq){ // boardRepo를 사용하여 ID가 seq인 Board 엔티티를 가져옴
		//return boardRepo.findById(seq).orElseThrow();
		Optional<Board> opt = boardRepo.findById(seq);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
		
	}
	//2가지 방법
	@PostMapping("/board")
	public Board postBoard(@RequestBody Board board){
		
		return boardRepo.save(board);
		
				
	}
	
	@PutMapping("/board")
	public Board putBoard(@RequestBody Board board){
		Board b = boardRepo.findById(board.getSeq()).orElseThrow();
		if(board.getTitle()!=null) b.setTitle(board.getTitle());
		if(board.getContent()!=null) b.setContent(board.getContent());
		
		return boardRepo.save(b);
				
	}
	
	@DeleteMapping("/board/{seq}")
	public Board deleteBoard(@PathVariable Long seq){
		Board b = boardRepo.findById(seq).orElseThrow();
		boardRepo.deleteById(seq);
		return b;
				
	}
	
	

}

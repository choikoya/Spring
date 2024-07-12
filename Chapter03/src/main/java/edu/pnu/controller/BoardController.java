package edu.pnu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.BoardVO;

@RestController
public class BoardController {

	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
	
	@GetMapping("/getBoard")
	public BoardVO getWriter() {
		BoardVO board = new BoardVO(); //참조변수에 객체생성해서 넣음
		board.setWriter("테스터"); //setter값이 테스터인지 비교해서 같으면 성공, 다르면 에러
		return board;
	}
}

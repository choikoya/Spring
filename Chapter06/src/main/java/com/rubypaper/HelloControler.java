package com.rubypaper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControler {
	
	
	//localhost:8080/hello?name=홍길동
	//hello홍길동
	@GetMapping("/hello")
	public ModelAndView hello(String name) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("name", name);
		mv.setViewName("hello");
		
		return mv;
	
//	//localhost:8080/hello?name=홍길동
//	//hello홍길동
//	@GetMapping("/hello1")
//	public String hello(String name, Model1 model) {
//		model.addAttribute("name", name);
//		
//		return "hello";
		
	
//	@GetMapping("/hello")
//	public void hello() {
//		// /WEB-INF/board/hello.jsp 가 호출됨
		
//	@GetMapping("/hello")
//	public String hello() {
//		// /WEB-INF/board/abcd.jsp 가 호출됨
//		return "abcd";

		
	}

}

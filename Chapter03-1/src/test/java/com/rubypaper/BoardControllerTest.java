package com.rubypaper;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import com.rubypaper.domain.BoardVO;

//@SpringBootTest(webEnvironment=WebEnvironment.MOCK) //디폴트
//@AutoConfigureMockMvc
//public class BoardControllerTest {
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@Test
//	public void testHello() throws Exception{
//		mockMvc.perform(get("/hello").param("name", "둘리"))
//		.andExpect(status().isOk())
//		.andExpect(content().string("Hello : 둘리"))
//		.andDo(print());
//	}


@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT) //랜덤포트 사용
public class BoardControllerTest{
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testHello() throws Exception{
		String result = restTemplate.getForObject("/hello?name=둘리", String.class);
		assertEquals("Hello : 둘리", result);
	}
	
	//BoardVO같은 자바 객체를 리턴하는 메소드도 동일한 방법으로 테스트 가능
	@Test
	public void testGetBoard() throws Exception{
		BoardVO board = restTemplate.getForObject("/getBoard", BoardVO.class);
		assertEquals("테스터" , board.getWriter());
	}

}

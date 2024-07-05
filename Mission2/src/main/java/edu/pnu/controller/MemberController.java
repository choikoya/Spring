package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;


//웹브라우저를 통한 요청을 받아들이는 컨트롤러 객체
@RestController
public class MemberController {
	
	//MemberService 타입의 memberService라는 참조변수를 선언(memberService 객체를 생성하고 이를 멤버 변수로 사용)
	//이를 통해 MemberController는 MemberService의 기능을 사용할 수 있음
	private MemberService memberService; 
	
	public MemberController() { //생성자만듦
	
	//생성자 내부에서 new MemberService()를 호출하여 MemberService 객체를 생성하고
	//이를 memberService 참조변수에 할당하고 있음
	memberService = new MemberService(); 
	
	

}
	
//	특정 url로부터 요청을 받으면 특정 url 요청을 수행할 Controller와 매핑하여 어노테이션@ 지정
	
	//검색(Read - select)
	
		@GetMapping("/members")
		public List<MemberVO> getAllMember(){ //보통 ResponseEntitiy<?> 많이사용
			return memberService.getAllMember(); //ResponseEntitiy.ok(memberService.getAllMember());
		}
		
		//검색(Read - select)
		@GetMapping("/member")
		public MemberVO getMemberById(Integer id) {
			return memberService.getMemberById(id);
		}
		
		//검색(Read - insert)
		@PostMapping("/member")
		public MemberVO addMember(MemberVO memberVO) {
			return memberService.addMember(memberVO);
		}
		
		//수정(Update -update)
		@PutMapping("/member")
		public int updateMember(MemberVO memberVO) {
			return memberService.updateMember(memberVO);
		}
		
		//삭제(Delete -delete)
		@DeleteMapping("/member")
		public int removeMember(Integer id) {
			return memberService.removeMember(id);
		}
		
		//입력(Create -insert)
		@PostMapping("/memberJSON")
		public MemberVO addMemberJSON(@RequestBody MemberVO memberVO) {
			return addMember(memberVO);
		}
		
		
}

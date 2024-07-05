

package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberDTO;
import edu.pnu.service.MemberService;



@RestController
public class MemberController {
	

	private MemberService memberService; 
	
	public MemberController() { //생성자만듦
	

	memberService = new MemberService(); 
	
	

}
	

	//검색(Read - select)
	
		@GetMapping("/members")
		public List<MemberDTO> getAllMember(){ //보통 ResponseEntitiy<?> 많이사용
			return memberService.getAllMember(); //ResponseEntitiy.ok(memberService.getAllMember());
		}
		
		//검색(Read - select)
		@GetMapping("/member")
		public MemberDTO getMemberById(Integer id) {
			return memberService.getMemberById(id);
		}
		
		//검색(Read - insert)
		@PostMapping("/member")
		public MemberDTO addMember(MemberDTO memberDTO) {
			return memberService.addMember(memberDTO);
		}
		
		//수정(Update -update)
		@PutMapping("/member")
		public int updateMember(MemberDTO memberDTO) {
			return memberService.updateMember(memberDTO);
		}
		
		//삭제(Delete -delete)
		@DeleteMapping("/member")
		public int removeMember(Integer id) {
			return memberService.removeMember(id);
		}
		
		//입력(Create -insert)
		@PostMapping("/memberJSON")
		public MemberDTO addMemberJSON(@RequestBody MemberDTO memberDTO) {
			return addMember(memberDTO);
		}
		
		
}

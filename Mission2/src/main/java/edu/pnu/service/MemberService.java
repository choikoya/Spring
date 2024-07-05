
package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;

@RestController //= @Controller + @ResponseBody

//Misson1에서 controller에서 데이터생성, 제공하는 요청처리까지 했다면
//Misson2에서 controller는 요청을 받아 넘겨주는 역할, service는 데이터를 제공하는 서비스 객체의 역할로 나눠서 연결

public class MemberService {
	
	private List<MemberVO> list = new ArrayList<>();
	
	public MemberService() {
		for(int i=1; i<=10; i++) {
			list.add(MemberVO.builder()
					.id(i)
					.name("name"+i)
					.pass("pass"+i)
					.regidate(new Date())
					.build());
		}
	}
	
	//검색(Read - select)
	public List<MemberVO> getAllMember(){
		return list;
	}
	
	//검색(Read - select)
	public MemberVO getMemberById(Integer id) {
		for (MemberVO m : list) {
			if(m.getId() == id)
				return m;
		}
		return null;
	}
	
	
	
	//검색(Read - insert)
	public MemberVO addMember(MemberVO memberVO) {
		if(getMemberById(memberVO.getId()) != null) {
			System.out.println(memberVO.getId() + "가 이미 존재함");
			return null;
		}
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return memberVO;
	}
	

	//수정(Update -update)
	public int updateMember(MemberVO memberVO) {
		MemberVO m = getMemberById(memberVO.getId());
		if(m == null)
			return 0;
		m.setName(memberVO.getName());
		m.setPass(memberVO.getPass());
		return 1;
	}
	
	//삭제(Delete -delete)
	//id가 id인 객체를 찾아서 삭제
	public int removeMember(Integer id) {
		try {
			list.remove(getMemberById(id));
		} catch(Exception e) {
			return 0;
		}
		return 1;
	}
	
	//입력(Create -insert)
	public MemberVO addMemberJSON(MemberVO memberVO) {
		if(getMemberById(memberVO.getId()) != null) {
			System.out.println(memberVO.getId() + "가 이미 존재함");
			return null;
		}
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return memberVO;
	}
//	
//	@PostMapping("/member JSON")
//	public MemberVO addMemberJSON(@RequestBody MemberVO memberVO) {
//		return addMember(memberVO);
//	}
	

}

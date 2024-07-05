package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import edu.pnu.domain.MemberDTO;


public class MemberService {
	
	private List<MemberDTO> list = new ArrayList<>();
	
	public MemberService() {
		for(int i=1; i<=10; i++) {
			list.add(MemberDTO.builder()
					.id(i)
					.name("name"+i)
					.pass("pass"+i)
					.regidate(new Date())
					.build());
		}
	}
	
	//검색(Read - select)
	public List<MemberDTO> getAllMember(){
		return list;
	}
	
	//검색(Read - select)
	public MemberDTO getMemberById(Integer id) {
		for (MemberDTO m : list) {
			if(m.getId() == id)
				return m;
		}
		return null;
	}
	
	
	
	//검색(Read - insert)
	public MemberDTO addMember(MemberDTO memberDTO) {
		if(getMemberById(memberDTO.getId()) != null) {
			System.out.println(memberDTO.getId() + "가 이미 존재함");
			return null;
		}
		memberDTO.setRegidate(new Date());
		list.add(memberDTO);
		return memberDTO;
	}
	

	//수정(Update -update)
	public int updateMember(MemberDTO memberDTO) {
		MemberDTO m = getMemberById(memberDTO.getId());
		if(m == null)
			return 0;
		m.setName(memberDTO.getName());
		m.setPass(memberDTO.getPass());
		return 1;
	}
	
	//삭제(Delete -delete)
	public int removeMember(Integer id) {
		try {
			list.remove(getMemberById(id));
		} catch(Exception e) {
			return 0;
		}
		return 1;
	}
	
	//입력(Create -insert)
	public MemberDTO addMemberJSON(MemberDTO memberDTO) {
		if(getMemberById(memberDTO.getId()) != null) {
			System.out.println(memberDTO.getId() + "가 이미 존재함");
			return null;
		}
		memberDTO.setRegidate(new Date());
		list.add(memberDTO);
		return memberDTO;
	}
//	
//	@PostMapping("/member JSON")
//	public MemberDTO addMemberJSON(@RequestBody MemberDTO memberDTO) {
//		return addMember(memberDTO);
//	}
	

}

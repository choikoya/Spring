//컨트롤러는 웹 요청을 처리하며, 클라이언트와 상호작용함 @RestController를 사용하여 RESTful API를 구현함
//*컨트롤러는 클라이언트의 요청을 받아 서비스로 전달>서비스는 비지니스 로직을 처리하고 필요시 퍼시스턴스 계층과 상호작용>
//퍼시스턴스 계층은 DB연동을 처리하고 결과를 서비스에 반환>서비스는 결과를 컨트롤러에 전달>컨트롤러는 이를 클라이언트에 응답함

package edu.pnu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/")	public String index()	{ return "index";}
	@GetMapping("/member")	public String member()	{ return "member";}
	@GetMapping("/manager")	public String manager()	{ return "manager";}
	@GetMapping("/admin")	public String admin()	{ return "admin";}
	
}

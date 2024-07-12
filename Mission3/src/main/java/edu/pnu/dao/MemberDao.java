package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import edu.pnu.domain.MemberDTO;

//데이터베이스 접근 객체
public class MemberDao { //db와의 연결 관리 쿼리 실행
	
	private Connection con; //con은 Connection 객체로, 데이터베이스 연결을 나타냄
	
	//jdbConnection만들어 연결하지 않고 바로 db연결 
	public MemberDao() throws SQLException { //MemberDao 클래스의 생성자
		//이 생성자는 DriverManager.getConnection 메서드를 사용하여 데이터베이스에 연결함
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/musthave", "scott", "tiger");
		
	}
	
	//검색(Read - select)
		//getAllMember 메서드는 member 테이블의 모든 레코드를 읽어와 MemberDTO 객체 리스트로 반환함
		public List<MemberDTO> getAllMember() throws SQLException{
			//MemberDTO타입의 객체를 저장할 리스트를 생성함
			List<MemberDTO> list = new ArrayList<>();//ArrayList 클래스의 인스턴스를 생성하고 기본 생성자를 호출
			
			Statement stmt = con.createStatement();//데이터베이스와의 통신을 위해 Statement 객체를 생성
			//SQL 쿼리를 실행하여 ResultSet 객체를 얻음
			ResultSet rs = stmt.executeQuery("select * from member order by id");
			//ResultSet을 순회하며 각 레코드를 읽음
			while(rs.next()) { //next() 메서드는 커서를 한 행 앞으로 이동시켜서 이동된 커서가 가리키는 행이 존재하면 true를, 존재하지 않으면 false를 반환
				//각 레코드를 MemberDTO 객체로 변환하여 리스트에 추가 
				list.add(MemberDTO.builder()//Builder 클래스의 인스턴스를 이용하여 MemberDTO 객체를 생성합
						.id(rs.getInt("id"))
						.pass(rs.getString("pass"))
						.name(rs.getString("name"))
						.regidate(rs.getDate("regidate"))
						.build());
			}
		//Statement와 ResultSet을 사용한 후에는 반드시 닫아야 함
		rs.close();
		stmt.close();
		
		return list;
		}
		
		
	//검색(Read - select)
		public MemberDTO getMemberById(Integer id) {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(null)
			
		}
		
		
	
	
	

	
}

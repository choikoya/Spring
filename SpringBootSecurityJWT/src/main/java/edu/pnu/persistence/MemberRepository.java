//퍼시스턴스는 데이터베이스 연동을 테스트. Repository 인터페이스가 위치하며, JPA를 사용하여 데이터베이스 연동을 수행합
package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

}

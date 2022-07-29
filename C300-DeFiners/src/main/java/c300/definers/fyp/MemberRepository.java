package c300.definers.fyp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	public Member findByUsername (String username);
		
}

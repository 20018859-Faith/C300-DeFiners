package c300.definers.fyp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MemberDetailsService implements UserDetailsService{

	//Wire the MemberRepository to the variable memberRepository.
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public MemberDetails loadUserByUsername (String username) throws UsernameNotFoundException {
		//Finds the username in the database
		Member member = memberRepository.findByUsername(username);
		
		//*when username does not exist. 
		//if Null throw exception.
		if (member == null) {
			throw new UsernameNotFoundException ("Could not find user");
		}
		
		//*when username exist.
		//else create a new object memberDetails with the member information obtained.
		return new MemberDetails (member);
	}
	
}

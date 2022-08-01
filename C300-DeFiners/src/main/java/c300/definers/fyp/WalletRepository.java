package c300.definers.fyp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
	
	// get the list of wallet based on member id
	  public List <Wallet> findByMemberId(int id);

}

package c300.definers.fyp;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Swap {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@DecimalMin(value = "0.00", inclusive = false, message = "Deposit amount 1 cannot be empty!")
	@DecimalMax(value = "1000.00", inclusive = true, message = "Deposit amount 1 cannot exceed $1000!")
	private double amt1;
	
	@NotNull
	@DecimalMin(value = "0.00", inclusive = false, message = "Deposit amount 1 cannot be empty!")
	@DecimalMax(value = "1000.00", inclusive = true, message = "Deposit amount 1 cannot exceed $1000!")
	private double amt2;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmt1() {
		return amt1;
	}

	public void setAmt1(double amt1) {
		this.amt1 = amt1;
	}

	public double getAmt2() {
		return amt2;
	}

	public void setAmt2(double amt2) {
		this.amt2 = amt2;
	}
	
	

}

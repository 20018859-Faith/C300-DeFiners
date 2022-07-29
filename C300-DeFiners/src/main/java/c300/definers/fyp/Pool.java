package c300.definers.fyp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Pool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@NotEmpty(message = "Pool token 1 name cannot be empty!")
	@Size(min = 2, max = 100, message = "Pool token 1 name length must be between 2 and 100 charaters")
	private String token1;

	@NotNull
	@NotEmpty(message = "Pool token 2 name cannot be empty!")
	@Size(min = 2, max = 100, message = "Pool token 2 name length must be between 2 and 100 charaters")
	private String token2;

	@NotNull
	private double fee;

	@NotNull
	@DecimalMin(value = "0.00", inclusive = false, message = "Deposit amount 1 cannot be empty!")
	private double deposit1;

	@NotNull
	@DecimalMin(value = "0.00", inclusive = false, message = "Deposit amount 2 cannot be empty!")
	private double deposit2;

	@NotNull
	@DecimalMin(value = "0.00", inclusive = false, message = "Minimum amount cannot be empty!")
	private double minimum;

	@NotNull
	@DecimalMin(value = "0.00", inclusive = false, message = "Maximum amount cannot be empty!")
	private double maximum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken1() {
		return token1;
	}

	public void setToken1(String token1) {
		this.token1 = token1;
	}

	public String getToken2() {
		return token2;
	}

	public void setToken2(String token2) {
		this.token2 = token2;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getDeposit1() {
		return deposit1;
	}

	public void setDeposit1(double deposit1) {
		this.deposit1 = deposit1;
	}

	public double getDeposit2() {
		return deposit2;
	}

	public void setDeposit2(double deposit2) {
		this.deposit2 = deposit2;
	}

	public double getMinimum() {
		return minimum;
	}

	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}

	public double getMaximum() {
		return maximum;
	}

	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}
}

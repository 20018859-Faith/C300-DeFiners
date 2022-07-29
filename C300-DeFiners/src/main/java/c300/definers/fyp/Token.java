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
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotEmpty(message = "Contract address cannot be empty!")
	private String address;
	
	@NotNull
	@NotEmpty(message = "Token name cannot be empty!")
	@Size(min = 2, max = 100, message = "Token name length must be between 2 and 100 charaters")
	private String name;
	
	@NotNull
	private double decimal;
	
	private String imgToken;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDecimal() {
		return decimal;
	}

	public void setDecimal(double decimal) {
		this.decimal = decimal;
	}

	public String getImgToken() {
		return imgToken;
	}

	public void setImgToken(String imgToken) {
		this.imgToken = imgToken;
	}
	
	
	
}


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
public class Chart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotEmpty(message = "Pool Hash Identifier cannot be empty!")
	@Size(max = 50, message = "Pool hash length must be less than 50 characters")
	private String PoolHashIdentifier;
	
	@NotNull
	@NotEmpty(message = "Pool name cannot be empty!")
	private String PoolName;
	
	@NotNull
	@NotEmpty(message = "Token0_id cannot be empty!")
	@Size(max = 50, message = "Token0_id length must be less than 50 characters")
	private String token0_id;
	
	@NotNull
	@NotEmpty(message = "Token1_id cannot be empty!")
	@Size(max = 50, message = "Token1_id length must be less than 50 characters")
	private String token1_id;
	
	@NotNull
	@DecimalMin(value = "0.00", inclusive = false, message = "Total Value Locked(TVL) cannot be empty!")
	private double TVL;
	
	@NotNull
	@DecimalMin(value = "0.00", inclusive = false, message = "VolumeUSD cannot be empty!")
	private double volumeUSD;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public String getPoolHashIdentifier() {
		return PoolHashIdentifier;
	}

	public void setPoolHashIdentifier(String poolHashIdentifier) {
		PoolHashIdentifier = poolHashIdentifier;
	}


	public String getPoolName() {
		return PoolName;
	}

	public void setPoolName(String poolName) {
		PoolName = poolName;
	}

	public String getToken0_id() {
		return token0_id;
	}

	public void setToken0_id(String token0_id) {
		this.token0_id = token0_id;
	}

	public String getToken1_id() {
		return token1_id;
	}

	public void setToken1_id(String token1_id) {
		this.token1_id = token1_id;
	}

	public double getTVL() {
		return TVL;
	}

	public void setTVL(double tVL) {
		TVL = tVL;
	}

	public double getVolumeUSD() {
		return volumeUSD;
	}

	public void setVolumeUSD(double volumeUSD) {
		this.volumeUSD = volumeUSD;
	}

}

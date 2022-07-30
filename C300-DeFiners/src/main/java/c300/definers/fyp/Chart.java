
package c300.definers.fyp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String PoolName;
	private String token0_id;
	private String token1_id;
	private String TVL;
	private String volumeUSD;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTVL() {
		return TVL;
	}

	public void setTVL(String tVL) {
		TVL = tVL;
	}

	public String getVolumeUSD() {
		return volumeUSD;
	}

	public void setVolumeUSD(String volumeUSD) {
		this.volumeUSD = volumeUSD;
	}

}

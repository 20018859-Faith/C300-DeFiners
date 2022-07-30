package c300.definers.fyp;

<<<<<<< HEAD

=======
import java.util.Set;
>>>>>>> branch 'master' of https://github.com/20018859-Faith/C300-DeFiners.git

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Token {

<<<<<<< HEAD
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
  private double deci;
  
  private String imgToken;
=======
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
	private double deci;

	private String imgToken;
>>>>>>> branch 'master' of https://github.com/20018859-Faith/C300-DeFiners.git

<<<<<<< HEAD
  public int getId() {
    return id;
  }
=======
//	@OneToMany(mappedBy = "token")
//	private Set<Pool> Pool;

	public int getId() {
		return id;
	}
>>>>>>> branch 'master' of https://github.com/20018859-Faith/C300-DeFiners.git

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

  public double getDeci() {
    return deci;
  }

  public void setDeci(double deci) {
    this.deci = deci;
  }

  public String getImgToken() {
    return imgToken;
  }

<<<<<<< HEAD
  public void setImgToken(String imgToken) {
    this.imgToken = imgToken;
  }
  
}
=======
	public void setImgToken(String imgToken) {
		this.imgToken = imgToken;
	}

}
>>>>>>> branch 'master' of https://github.com/20018859-Faith/C300-DeFiners.git

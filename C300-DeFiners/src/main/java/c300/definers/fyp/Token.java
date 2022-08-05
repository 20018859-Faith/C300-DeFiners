package c300.definers.fyp;

import java.util.Set;

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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Token {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull
  @NotEmpty(message = "Contract address cannot be empty!")
  @Pattern(regexp = "0x+[A-F,a-f,0-9]{40}")
  private String address;

  @NotNull
  @NotEmpty(message = "Token name cannot be empty!")
  @Size(min = 2, max = 100, message = "Token name length must be between 2 and 100 charaters")
  private String name;

  @NotNull
  private double deci;

  

  @OneToMany(mappedBy = "token")
  private Set<Pool> Pool;

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

  public double getDeci() {
    return deci;
  }

  public void setDeci(double deci) {
    this.deci = deci;
  }

 

}
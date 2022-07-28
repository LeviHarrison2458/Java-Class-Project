package addressbook;
import java.util.Objects;

public class Part1 {
  private String firstName;
  private String lastName;
  private String phone;
  private String email;
  
  
  public Part1(String firstName, String lastName, String phone, String email) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.phone = phone;
	    this.email = email;
	  }

	  public String getFirstName() {
	    return firstName;
	  }

	  public void setFirstName(String firstName) {
	    this.firstName = firstName;
	  }

	  public String getLastName() {
	    return lastName;
	  }

	  public void setLastName(String lastName) {
	    this.lastName = lastName;
	  }

	  public String getPhone() {
	    return phone;
	  }

	  public void setPhone(String phone) {
	    this.phone = phone;
	  }

	  public String getEmail() {
	    return email;
	  }

	  public void setEmail(String email) {
	    this.email = email;
	  }

	  @Override
	  public boolean equals(Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    Part1 entry = (Part1) o;
	    return Objects.equals(getEmail(), entry.getEmail());
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(getEmail());
	  }

	  @Override
	  public String toString() {
	    return "Entry{"
	        + "firstName='"
	        + firstName
	        + '\''
	        + ", lastName='"
	        + lastName
	        + '\''
	        + ", phone='"
	        + phone
	        + '\''
	        + ", email='"
	        + email
	        + '\''
	        + '}';
	  }
	}

  


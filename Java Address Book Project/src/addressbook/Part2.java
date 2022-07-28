package addressbook;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class Part2 {

	private List<Part1> info;

	  public Part2() {
	    this.info = new ArrayList<>();
	  }

	  public boolean addEntry(Part1 entry) {
	    if (this.info.contains(entry)) {
	      System.out.println("Another entry already present with same email address. Please try again\n");
	      return false;
	    }
	    this.info.add(entry);
	    System.out.println("Entry added successfully. You are good!\n");
	    return true;
	  }

	  public boolean removeEntry(String email) {
	    int index = getEntryIndexByEmail(email);

	    if (index == -1) {
	      System.out.println("No entry was found with given email. Please input different email.\n");
	      return false;
	    }

	    this.info.remove(index);
	    System.out.println("Entry deleted sorry to see you go\n");
	    return true;
	  }

	  public int getEntryIndexByEmail(String email) {
	    for (int i = 0; i < this.info.size(); i++) {
	      if (this.info.get(i).getEmail().equals(email)) {
	        return i;
	      }
	    }
	    return -1;
	  }

	  public List<Part1> searchForAnEntry(String searchType, String searchQuery) {
	    searchQuery = searchQuery.strip();
	    if (searchType.equals("firstName")) {
	      return searchByFirstName(searchQuery);
	    } else if (searchType.equals("lastName")) {
	      return searchByLastName(searchQuery);
	    } else if (searchType.equals("phone")) {
	      return searchByPhone(searchQuery);
	    } else {
	      return searchByEmail(searchQuery);
	    }
	  }

	  private List<Part1> searchByFirstName(String firstName) {
	    List<Part1> ans = new ArrayList<>();
	    for (Part1 entry : this.info) {
	      if (entry.getFirstName().contains(firstName)) {
	        ans.add(entry);
	      }
	    }
	    return ans;
	  }

	  private List<Part1> searchByLastName(String lastName) {
	    List<Part1> ans = new ArrayList<>();
	    for (Part1 entry : this.info) {
	      if (entry.getLastName().contains(lastName)) {
	        ans.add(entry);
	      }
	    }
	    return ans;
	  }

	  private List<Part1> searchByPhone(String phone) {
	    List<Part1> ans = new ArrayList<>();
	    for (Part1 entry : this.info) {
	      if (entry.getPhone().contains(phone)) {
	        ans.add(entry);
	      }
	    }
	    return ans;
	  }

	  private List<Part1> searchByEmail(String email) {
	    for (Part1 entry : this.info) {
	      if (entry.getEmail().equals(email)) {
	        return Arrays.asList(entry);
	      }
	    }
	    return new ArrayList<>();
	  }

	  public void printAddressBook() {
	    if (this.info.size() == 0) System.out.println("Address book is empty. Please add info into the system.");
	    else {
	      System.out.println("Printing Entries in Address Book:");
	      System.out.println(this.toString());
	    }
	    System.out.println();
	  }

	  public void deleteAddressBook() {
	    this.info.clear();
	    System.out.println("Address book deleted. Thank you for your time.\n");
	  }

	  @Override
	  public String toString() {
	    StringJoiner sj = new StringJoiner("\n");
	    for (Part1 entry : this.info) {
	      sj.add(entry.toString());
	    }
	    return sj.toString();
	  }
}
	


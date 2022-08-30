package addressbook;
import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class Main {
	public static Scanner sc;

	  public static void main(String[] args) {
	    sc = new Scanner(System.in);
	    int input = 0;

	    AddressBook addressBook = new AddressBook();
	    while (input != 6) {
	      printMenu();
	      input = getIntInput();
	      if (input < 1 || input > 6) {
	        System.out.println("Invalid input! Try Again");
	      } else {
	        switch (input) {
	          case 1:
	            addEntry(addressBook);
	            break;
	          case 2:
	            String email = askForInput("email");
	            addressBook.removeEntry(email);
	            break;
	          case 3:
	            searchForSpecificEntry(addressBook);
	            break;
	          case 4:
	            addressBook.printAddressBook();
	            break;
	          case 5:
	            addressBook.deleteAddressBook();
	            break;
	          default:
	            System.out.println("Exiting program. Have a nice day!");
	        }
	      }
	    }

	    sc.close();
	  }

	  public static int getIntInput() {
	    String ip = sc.nextLine();
	    while (ip.length() == 0) {
	      ip = sc.nextLine();
	    }
	    return Integer.parseInt(ip);
	  }

	  public static String askForInput(String inputName) {
	    System.out.println("Please enter " + inputName + ": ");
	    return sc.nextLine();
	  }

	  public static void addEntry(AddressBook addressBook) {
	    System.out.print("Enter first name: ");
	    String firstName = sc.nextLine();

	    System.out.print("Enter last name: ");
	    String lastName = sc.nextLine();

	    System.out.print("Enter phone number: ");
	    String phone = sc.nextLine();

	    System.out.print("Enter email: ");
	    String email = sc.next().strip();

	    Entry entry = new Entry(firstName, lastName, phone, email);
	    addressBook.addEntry(entry);
	  }

	  public static void printMenu() {
	    System.out.println("Please select an option:");
	    System.out.println("1. Add an entry");
	    System.out.println("2. Remove an entry");
	    System.out.println("3. Search for an specific entry");
	    System.out.println("4. Print the contents of the address book");
	    System.out.println("5. Delete the contents of the address book");
	    System.out.println("6. Quit the program");
	  }

	  public static void searchForSpecificEntry(AddressBook addressBook) {
	    System.out.println("Please select an option");
	    System.out.println("1. Search By First Name");
	    System.out.println("2. Search By Last Name");
	    System.out.println("3. Search By Phone");
	    System.out.println("4. Search By Email");

	    int input = getIntInput();

	    Map<Integer, String> searchMapping =
	        Map.of(1, "firstName", 2, "lastName", 3, "phone", 4, "email");
	    if (input < 0 || input > 4) {
	      System.out.println("Try again");
	    } else {
	      System.out.print("Enter your search query: ");
	      String searchQuery = sc.nextLine();
	      List<Entry> info = addressBook.searchForAnEntry(searchMapping.get(input), searchQuery);
	      System.out.println("Here are your search results:");
	      for (Entry entry : info) {
	        System.out.println(entry);
	      }
	    }
	    System.out.println();
	  }
}

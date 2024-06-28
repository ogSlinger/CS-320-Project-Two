import java.lang.String;
import java.util.Scanner;
import java.util.Vector;

public class ContactService {
	private String contactID = new String();
	private String firstName = new String();
	private String lastName = new String();
	private String phone = new String();
	private String address = new String();
	public Vector<Contact> contactVector = new Vector<Contact>();
	
	public ContactService() {
		this.contactID = "";
		this.firstName = "";
		this.lastName = "";
		this.phone = "";
		this.address = "";
	}
	
	public void addContact() {
		Scanner scn = new Scanner(System.in);
		
		//Read in Contact ID
		System.out.println("Please enter a unique ID (No longer than 10 characters): ");
		this.contactID = scn.nextLine();
		
		for (int i = 0; i < contactVector.size(); i++) {
			if (contactVector.get(i).getContactID().equals(this.contactID)) {
				System.out.println("ID is in use.");
				this.contactID = "";
				break;
			}
		}
		
		while (this.contactID.length() > 10 || this.contactID.length() <= 0) {
			System.out.println("Please enter a unique ID that is no longer than 10 characters: ");
			this.contactID = scn.nextLine();
			
			for (int i = 0; i < contactVector.size(); i++) {
				if (contactVector.get(i).getContactID().equals(this.contactID)) {
					System.out.println("ID is in use.");
					this.contactID = "";
					break;
				}
			}
		}
		
		//Read in Contact First Name
		System.out.println("Please enter the first name (10 Characters Max): ");
		this.firstName = scn.nextLine();
		
		while (this.firstName.length() > 10 || this.firstName.length() <= 0) {
			System.out.println("Please enter a first name that is no longer than 10 characters: ");
			this.firstName = scn.nextLine();
		}
		
		//Read in Contact Last Name
		System.out.println("Please enter the last name (10 Characters Max): ");
		this.lastName = scn.nextLine();
		
		while (this.lastName.length() > 10 || this.lastName.length() <= 0) {
			System.out.println("Please enter a last name that is no longer than 10 characters: ");
			this.lastName = scn.nextLine();
		}
		
		//Read in Contact Phone Number
		System.out.println("Please enter the phone number (10 Characters, No spaces/dashes): ");
		this.phone = scn.nextLine();
		
		while (this.phone.length() != 10) {
			System.out.println("Please enter a phone number that is exactly 10 Characters: ");
			this.phone = scn.nextLine();
		}
		
		//Read in Contact Last Name
		System.out.println("Please enter the address (30 Characters Max): ");
		this.address = scn.nextLine();
		
		while (this.address.length() > 30 || this.address.length() <= 0) {
			System.out.println("Please enter an address that is no longer than 30 characters: ");
			this.address = scn.nextLine();
		}
		scn.close();
		
		//Add the contact
		Contact newContact = new Contact();
		addContact(newContact);
		this.contactID = "";
		this.firstName = "";
		this.lastName = "";
		this.phone = "";
		this.address = "";
	}
	
	public boolean addContact(Contact newContact) {
		Scanner scn = new Scanner(System.in);
		
		//Check if ID is already in use
		for (int i = 0; i < contactVector.size(); i++) {
			if (contactVector.get(i).getContactID().equals(newContact.getContactID())) {
				System.out.println("ID is in use.");
				scn.close();
				return false;
			}
		}
		
		//Checking lengths of members
		if (newContact.getFirstName().length() > 10 || newContact.getFirstName().length() <= 0) {
			System.out.println("Invalid length of first name.");
			scn.close();
			return false;
		}
		
		if (newContact.getLastName().length() > 10 || newContact.getLastName().length() <= 0) {
			System.out.println("Invalid length of last name.");
			scn.close();
			return false;
		}
		
		if (newContact.getPhone().length() != 10) {
			System.out.println("Invalid length of phone number.");
			scn.close();
			return false;
		}
		
		if (newContact.getAddress().length() > 30 || newContact.getAddress().length() <= 0) {
			System.out.println("Invalid length of address.");
			scn.close();
			return false;
		}
		
		//Add contact to vector
		contactVector.add(newContact);
		scn.close();
		return true;
	}
	
	/**
	 * Method to update a contact member variable.
	 * @param id This is the contact ID
	 * @param field 0: First Name 1: Last Name 2: Phone 3: Address
	 * @param value String value to be passed into field param.
	 * @return
	 */
	public boolean updateInfo(String id, int field, String value) {
		//Check if ID exists
		int contactIndex = -1;
		for (int i = 0; i < contactVector.size(); i++) {
			if (contactVector.get(i).getContactID().equals(id)) {
				contactIndex = i;
				break;
			}
		}
		
		if (contactIndex == -1) {
			System.out.println("ID does not exist.");
			return false;
		}
		
		switch (field) {
		case 0:
			if (value.length() > 10 || value.length() <= 0) {
				System.out.println("Invalid value length");
				return false;
			}
			else {
				contactVector.get(contactIndex).setFirstName(value);
				return true;
			}
		case 1:
			if (value.length() > 10 || value.length() <= 0) {
				System.out.println("Invalid value length");
				return false;
			}
			else {
				contactVector.get(contactIndex).setLastName(value);
				return true;
			}
		case 2:
			if (value.length() != 10) {
				System.out.println("Invalid value length");
				return false;
			}
			else {
				contactVector.get(contactIndex).setPhone(value);
				return true;
			}
		case 3:
			if (value.length() > 30 || value.length() <= 0) {
				System.out.println("Invalid value length");
				return false;
			}
			else {
				contactVector.get(contactIndex).setAddress(value);
				return true;
			}
		default:
			System.out.println("Invalid choice");
			return false;
		}
	}
	
	//Method to delete a contact via ID arg
	public boolean deleteContact(String id) {
		for (int i = 0; i < contactVector.size(); i++) {
			if (contactVector.get(i).getContactID().equals(id)) {
				System.out.println("Deleting contact...");
				contactVector.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public int getContactIndex(String id) {
		for (int i = 0; i < contactVector.size(); i++) {
			if (contactVector.get(i).getContactID().equals(id)) {
				return i;
			}
		}
		return -1;
	}
}

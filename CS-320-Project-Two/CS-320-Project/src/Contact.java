import java.lang.String;

public class Contact {
	private String contactID = new String();
	private String firstName = new String();
	private String lastName = new String();
	private String phone = new String();
	private String address = new String();
	
	//Setters
	public void setContactID(String ID) { this.contactID = (ID.length() > 10 || ID.length() <= 0) ? "ERROR" : ID; }
	public void setFirstName(String name) { this.firstName = (name.length() > 10 || name.length() <= 0) ? "ERROR" : name; }
	public void setLastName(String name) { this.lastName = (name.length() > 10 || name.length() <= 0) ? "ERROR" : name; }
	public void setPhone(String phone) { this.phone = (phone.length() != 10) ? "ERROR" : phone; }
	public void setAddress(String address) { this.address = (address.length() > 30 || address.length() <= 0) ? "ERROR" : address; }
	
	//Getters
	public String getContactID() { return this.contactID; }
	public String getFirstName() { return this.firstName; }
	public String getLastName() { return this.lastName; }
	public String getPhone() { return this.phone; }
	public String getAddress() { return this.address; }
}

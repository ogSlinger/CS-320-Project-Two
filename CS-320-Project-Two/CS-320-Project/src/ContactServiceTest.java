import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import java.lang.String;

import org.junit.jupiter.api.Test;

class ContactServiceTest {
	static Contact goodContact = new Contact();
	static Contact duplicateGoodContact = new Contact();
	static String contactToDelete = new String();
	ContactService TestService = new ContactService();
	
	@BeforeAll
	static void setup() {
		goodContact.setContactID("Good");
		goodContact.setFirstName("John");
		goodContact.setLastName("Doe");
		goodContact.setPhone("9993334444");
		goodContact.setAddress("123 Fake Street");
		
		duplicateGoodContact.setContactID("Good");
		duplicateGoodContact.setFirstName("John");
		duplicateGoodContact.setLastName("Doe");
		duplicateGoodContact.setPhone("9993334444");
		duplicateGoodContact.setAddress("123 Fake Street");
		
		contactToDelete = "Good";
	}
	
	@Test
	void goodContactAddTest() {
		assertTrue(TestService.addContact(goodContact));
	}
	
	@Test
	void duplicateContactAddTest() {
		assertTrue(TestService.addContact(goodContact));
		assertFalse(TestService.addContact(duplicateGoodContact));
	}
	
	@Test
	void deleteContactTest() {
		assertTrue(TestService.addContact(goodContact));
		assertTrue(TestService.deleteContact(contactToDelete));
	}
	
	@Test
	void updateContactTest() {
		assertTrue(TestService.addContact(goodContact));
		assertTrue(TestService.updateInfo("Good", 0, "Berry"));
		assertTrue(TestService.updateInfo("Good", 1, "Stevens"));
		assertTrue(TestService.updateInfo("Good", 2, "3330009999"));
		assertTrue(TestService.updateInfo("Good", 3, "456 Also Fake St."));
		
		int index = TestService.getContactIndex("Good");
		assertNotEquals(index, -1);
		
		if (index != 1) {
			assertTrue(TestService.contactVector.get(index).getFirstName().equals("Berry"));
			assertTrue(TestService.contactVector.get(index).getLastName().equals("Stevens"));
			assertTrue(TestService.contactVector.get(index).getPhone().equals("3330009999"));
			assertTrue(TestService.contactVector.get(index).getAddress().equals("456 Also Fake St."));
		}
	}
	
}

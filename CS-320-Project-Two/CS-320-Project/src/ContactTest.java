import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ContactTest {
	static Contact goodContact = new Contact();
	static Contact badContactLarge = new Contact();
	static Contact badContactNull = new Contact();
	
	@BeforeAll
	static void setup() {
		goodContact.setContactID("Good");
		goodContact.setFirstName("John");
		goodContact.setLastName("Doe");
		goodContact.setPhone("9993334444");
		goodContact.setAddress("123 Fake Street");

		badContactLarge.setContactID("Good Contact");
		badContactLarge.setFirstName("SuperLargeNameOverTenChars");
		badContactLarge.setLastName("SuperLargeNameOverTenChars");
		badContactLarge.setPhone("123456789101112");
		badContactLarge.setAddress("SuperLargeAddressOverThirtyCharactersForTheTestToPass");
		
		badContactNull.setContactID("");
		badContactNull.setFirstName("");
		badContactNull.setLastName("");
		badContactNull.setPhone("");
		badContactNull.setAddress("");
	}
	
	@Test
	void goodContactTest() {
		assertTrue(goodContact.getContactID().equals("Good"));
		assertTrue(goodContact.getFirstName().equals("John"));
		assertTrue(goodContact.getLastName().equals("Doe"));
		assertTrue(goodContact.getPhone().equals("9993334444"));
		assertTrue(goodContact.getAddress().equals("123 Fake Street"));
	}
	
	@Test
	void badContactLargeTest() {
		assertTrue(badContactLarge.getContactID().equals("ERROR"));
		assertTrue(badContactLarge.getFirstName().equals("ERROR"));
		assertTrue(badContactLarge.getLastName().equals("ERROR"));
		assertTrue(badContactLarge.getPhone().equals("ERROR"));
		assertTrue(badContactLarge.getAddress().equals("ERROR"));
	}
	
	@Test
	void badContactNullTest() {
		assertTrue(badContactNull.getContactID().equals("ERROR"));
		assertTrue(badContactNull.getFirstName().equals("ERROR"));
		assertTrue(badContactNull.getLastName().equals("ERROR"));
		assertTrue(badContactNull.getPhone().equals("ERROR"));
		assertTrue(badContactNull.getAddress().equals("ERROR"));
	}
	
}

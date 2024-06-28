import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TaskTest {
	
	static private Task goodTask = new Task();
	static private Task overTask = new Task();
	static private Task nullTask = new Task();
	
	@BeforeAll
	static void setup() {
		goodTask.setId("Unique");
		goodTask.setName("Good Task");
		goodTask.setDescription("This is a test description");
		
		overTask.setId("LongerThanTenCharacters");
		overTask.setName("NameThatIsLongerThanTwentyCharactersTotal");
		overTask.setDescription("Description That Is Over Fifty Characters For The JUnit Test");
		
		nullTask.setId("");
		nullTask.setName("");
		nullTask.setDescription("");
	}

	@Test
	void testIDInBounds() {
		assertTrue(goodTask.getId().equals("Unique"));
		assertTrue(overTask.getId().equals("Default"));
		assertTrue(nullTask.getId().equals("Default"));
	}
	
	@Test
	void testNameInBounds() {
		assertTrue(goodTask.getName().equals("Good Task"));
		assertTrue(overTask.getName().equals("Default"));
		assertTrue(nullTask.getName().equals("Default"));
	}
	
	@Test
	void testDescriptionInBounds() {
		assertTrue(goodTask.getDescription().equals("This is a test description"));
		assertTrue(overTask.getDescription().equals("Default"));
		assertTrue(nullTask.getDescription().equals("Default"));
	}
	
}

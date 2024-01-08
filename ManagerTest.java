import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ManagerTest {
	Manager testMan;
	@BeforeEach
	void setUp() throws Exception {
		testMan = new Manager("test@cs200.com", "Final Project");
	}

	@Test
	void testManagerPrivateMemberString() {
		String email = testMan.getEmail();
		assertEquals("test@cs200.com", email);
		if (testMan.getEmail() != "test@cs200.com") {
			fail("Email stored did not match the email set");
		}
		
	}

	@Test
	void testAllReports() throws ClassNotFoundException, IOException {
		boolean reportsProcessed = testMan.AllReports();
		if (reportsProcessed) {
			System.out.println("All Reports were generated");
			assertEquals(reportsProcessed, true);
		}
		else {
			fail("At least one of the reports was not generated");
		}
		
	}
	@Test
	void testisManager() throws ClassNotFoundException, IOException {
		ManagerList manList = ManagerList.instance();
		manList.addManager(testMan);
		Manager newMan = new Manager(testMan.getEmail(),"wrong password");
		if (newMan.CompPass(newMan) == false) {
			assertFalse("newMan was not found in the list, because it was not added",newMan.CompPass(newMan));
		}
		else {
			fail("newMan was found, which so the test ");
		}
	}
}

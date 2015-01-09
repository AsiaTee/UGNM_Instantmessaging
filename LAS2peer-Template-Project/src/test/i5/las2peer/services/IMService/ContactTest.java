package i5.las2peer.services.IMService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import i5.las2peer.restMapper.data.Pair;
import i5.las2peer.webConnector.client.ClientResponse;
import i5.las2peer.webConnector.client.MiniClient;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ContactTest extends ServiceTest {

	@Before
	public void writeTestData() throws Exception {

		// DataBase Connection

		Connection conn = null;
		PreparedStatement stmnt = null;
		conn = dbm.getConnection();

		/**
		 * Create Profiles eve visibility = 0 adam visibility = 1 Create
		 * ContactRequest adam to eve Contacts adam and abel
		 */
		try {
			stmnt = conn.prepareStatement("INSERT INTO AccountProfile VALUES (\"" + getAdamName()
					+ "\", \"test@mail.de\", 2222, \"test\", \"NewNickName\", 1), (\"" + getEveName()
					+ "\", \"test\", 2222, \"test\", \"test\", 0), (\"" + getAbelName()
					+ "\", \"test@mail.de\", 2222, \"test\", \"NewNickName\", 1);");
			int rows = stmnt.executeUpdate();

			stmnt = conn.prepareStatement("INSERT INTO ContactRequest (Sender, Receiver) VALUES (\"" + getAdamName()
					+ "\", \"" + getEveName() + "\");");
			rows = stmnt.executeUpdate();

			stmnt = conn.prepareStatement("INSERT INTO Contact (FirstUser, SecondUser) VALUES (\"" + getAdamName()
					+ "\", \"" + getAbelName() + "\");");
			rows = stmnt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception: " + e);
		}

		if (stmnt != null) {
			stmnt.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

	/**
	 * Test POST Contact
	 * 
	 * test Create Contact Active Eve to Adam - 200 test Create Contact Active
	 * Eve to Abel - 400
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCreateContact() {
		MiniClient c = new MiniClient();
		c.setAddressPort(HTTP_ADDRESS, HTTP_PORT);

		try {
			c.setLogin(getEveID(), evePass);

			ClientResponse result = c.sendRequest("POST", mainPath + "profile/contact", "{\"username\":\""
					+ getAdamName() + "\"}", "application/json", "*/*", new Pair[] {});
			assertEquals(200, result.getHttpCode());

			ClientResponse result2 = c.sendRequest("POST", mainPath + "profile/contact", "{\"username\":\""
					+ getAbelName() + "\"}", "application/json", "*/*", new Pair[] {});
			assertEquals(200, result.getHttpCode());

			System.out.println("Result of 'testCreateContact': " + result.getResponse().trim());

		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception: " + e);
		}

	}

	/**
	 * Test GET Contact Get Contacts of Adam - 200 Abel
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetContact() {
		MiniClient c = new MiniClient();
		c.setAddressPort(HTTP_ADDRESS, HTTP_PORT);

		try {
			c.setLogin(getAdamID(), adamPass);
			ClientResponse result = c.sendRequest("GET", mainPath + "profile/contact", "", "*/*", "application/json",
					new Pair[] {});
			assertEquals(200, result.getHttpCode());
			assertTrue(result.getResponse().trim().contains(getAbelName()));
			System.out.println("Result of 'testCreateContact': " + result.getResponse().trim());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception: " + e);
		}

	}

	/**
	 * Test DELETE Contact adam delete abel from contacts
	 * 
	 * @throws Exception
	 */
	@Ignore
	public void testDeleteContact() {
		MiniClient c = new MiniClient();
		c.setAddressPort(HTTP_ADDRESS, HTTP_PORT);

		try {
			c.setLogin(getAdamID(), adamPass);
			ClientResponse result = c.sendRequest("DELETE", mainPath + "profile/contact", "{\"username\":\""
					+ getAbelName() + "\"}");
			assertEquals(200, result.getHttpCode());
			System.out.println("Result of 'testCreateContact': " + result.getResponse().trim());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception: " + e);
		}

	}

}
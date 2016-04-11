/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.neet.DiamondHunter.Manager.Content;

/**
 * @author james
 *
 */
public class ContentTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.neet.DiamondHunter.Manager.Content#load(java.lang.String, int, int)}.
	 */
	@Test
	public void testLoad() {
		assertTrue(Content.load("/HUD/font.gif", 8, 8) != null);
	}

}

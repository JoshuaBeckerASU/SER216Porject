package tests;

import com.neet.DiamondHunter.Entity.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.neet.DiamondHunter.Manager.Content;
import com.neet.DiamondHunter.Manager.JukeBox;
import com.neet.DiamondHunter.TileMap.TileMap;

/**
 * Class that performs unit tests on the Player class
 * @author trevorforrey, Joshua Becker
 *
 */
public class PlayerTileMapIntergraiontests {
	
	private Player player;
	private TileMap tileMap;
	private int width, height;

	/**
	 * Informs the tester that test object is being created
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Setting up Player test");
	}

	/**
	 * Informs tester that test object is being torn down
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Tearing down Player test");
	}

	/**
	 * Creates a new Player object and tileMap object for a unit test
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		width = 4;
		height = 4;
		tileMap = new TileMap(height*width);
		player = new Player(tileMap);
	}

	/**
	 * Sets player and tileMap object to null to "clear" objects before performing a new test
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		player = null;
		tileMap = null;
		width = 0;
		height = 0;
	}

	/**
	 * Tests collectedDiamond method of Player Class
	 * collectedDiamond performing properly (result of 10)
	 */
	@Test
	public void collectDiamondTest() {
		for (int i = 0; i < 10; i++) {
			player.collectedDiamond();
		}
		int expected = 10;
		int actual = player.numDiamonds();
		
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests collectedDiamond method of Player Class
	 * collectedDiamond performing properly (result of 1)
	 */
	@Test
	public void collectedDiamondTest2() {
		
		player.collectedDiamond();

		int expected = 1;
		int actual = player.numDiamonds();
		
		assertEquals(expected, actual);
	}
	/**
	 * Tests that the tile map was not altered in Player class and
	 * was correctly created.
	 */
	@Test
	public void TileMap()
	{
		Assert.assertNotEquals(tileMap, null);
		
		//Testing Tile size set correctly and has not changed
		Assert.assertEquals(tileMap.getTileSize(), 16);
		Assert.assertNotEquals(tileMap.getTileSize(), 25);
	}
}

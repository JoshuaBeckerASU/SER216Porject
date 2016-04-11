package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.neet.DiamondHunter.TileMap.TileMap;

public class TileMapCreationTest {
	private static TileMap m_TileMap;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		m_TileMap = new TileMap(10);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Assert.assertNotEquals(m_TileMap, null);
		Assert.assertNotEquals(m_TileMap.getHeight(), null);
		Assert.assertNotEquals(m_TileMap.getTileSize(), null);
		Assert.assertNotEquals(m_TileMap.getWidth(), null);
	}

}

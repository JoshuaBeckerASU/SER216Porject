package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.neet.DiamondHunter.TileMap.TileMap;

public class TileMapMethodsTest {

	private static TileMap m_TileMap;
	private final static int width = 4;
	private final static int height = 4;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		m_TileMap = new TileMap(width*height);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Loading maps");
		m_TileMap.loadTiles("/Tilesets/testtileset.gif");
		m_TileMap.loadMap("/Maps/testmap.map");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Assert.assertNotEquals(m_TileMap, null);
		
	}
	@Test
	public void testSize()
	{
		//Testing Tile size set correctly
		Assert.assertEquals(m_TileMap.getTileSize(), 16);
		Assert.assertNotEquals(m_TileMap.getTileSize(), 25);
	}
	
	@Test
	public void testLoad()
	{
		//Testing Tile Map was loaded properly
		Assert.assertEquals(m_TileMap.getWidth(), 640);
		Assert.assertEquals(m_TileMap.getHeight(), 640);
		Assert.assertNotEquals(m_TileMap.getWidth(), 630);
		Assert.assertNotEquals(m_TileMap.getHeight(), 630);
		
		//Further testing map loaded correctly
		Assert.assertNotEquals(m_TileMap.getIndex(3, 3), null);
		Assert.assertEquals(m_TileMap.getNumCols(), 40);
		Assert.assertEquals(m_TileMap.getNumRows(), 40);
		Assert.assertNotEquals(m_TileMap.getNumCols(), 80);
		Assert.assertNotEquals(m_TileMap.getNumRows(), 80);
	}
}

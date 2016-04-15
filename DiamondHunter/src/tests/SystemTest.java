package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@RunWith(Suite.class)
@SuiteClasses({ TileCreationTest.class, TileMethodsTest.class, TileMapMethodsTest.class,PlayerTest.class,DiamondTest.class,DataTest.class, ContentTest.class, AnimationTest.class})
public class SystemTest {
  @BeforeClass
  public void setUp()
  {
	 

  }
  @AfterClass
  public void tearDown()
  {
	  System.out.println("All System Tests Complete...");
  }
  @Test
  public void SystemTesting1() {
	  TileMapCreationTest test =  new TileMapCreationTest();
	  test.test();
	  System.out.println("Running System Tests...");
  }
}

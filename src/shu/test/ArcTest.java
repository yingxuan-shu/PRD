package shu.test;

import static org.junit.Assert.*;
import org.junit.*;

import shu.model.Arc;

/**
 * Test methods in class Arc
 * 
 * @author shuyingxuan
 *
 */
public class ArcTest {

	private static Arc arc;
	
	@BeforeClass
    public static void before()  
    {  
        System.out.println("Global");  
    }  
  
    @AfterClass  
    public static void after() {  
        System.out.println("Global destroy");  
    }  
	
	@Before  
    public void setUp() throws Exception {  
        System.out.println("A test start");  
        arc = new Arc(201, 10, 1, 39905.8, 1);
    }  
  
    @After  
    public void tearDown() throws Exception {  
        System.out.println("A test end");  
    }

	@Test
	public void testGetIdArc() {
		assertEquals(201, arc.getIdArc());
	}

	@Test
	public void testSetIdArc() {
		arc.setIdArc(3000);
		assertEquals(3000, arc.getIdArc());
	}

	@Test
	public void testGetDistance() {
		assertEquals(39905.8, arc.getDistance(), 0.0001F);
	}

	@Test
	public void testSetDistance() {
		arc.setDistance(45227.7);
		assertEquals(45227.7, arc.getDistance(), 0.0001F);
	}

	@Test
	public void testGetNoeud_start() {
		assertEquals(10, arc.getNoeud_start());
	}

	@Test
	public void testSetNoeud_start() {
		arc.setNoeud_start(22);
		assertEquals(22, arc.getNoeud_start());
	}

	@Test
	public void testGetNoeud_end() {
		assertEquals(1, arc.getNoeud_end());
	}

	@Test
	public void testSetNoeud_end() {
		arc.setNoeud_end(143);
		assertEquals(143, arc.getNoeud_end());
	}

	@Test
	public void testGetInsecurite() {
		assertEquals(1, arc.getInsecurite());
	}

	@Test
	public void testSetInsecurite() {
		arc.setInsecurite(1);
		assertEquals(1, arc.getInsecurite());
	}

}

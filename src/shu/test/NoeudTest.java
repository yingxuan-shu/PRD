package shu.test;

import static org.junit.Assert.*;
import org.junit.*;
import shu.model.Noeud;

/**
 * Test methods in class Noeud
 * 
 * @author shuyingxuan
 *
 */
public class NoeudTest {

	private static Noeud noeud;

	
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
        noeud = new Noeud(1,1,1,60);
    }  
  
    @After  
    public void tearDown() throws Exception {  
        System.out.println("A test end");  
    }
	
    @Test
   	public void testGetId() {
       	assertEquals(1, noeud.getId());
   	}
       
       @Test
   	public void testSetId() {
       	noeud.setId(5);
       	assertEquals(5, noeud.getId());
   	}
       
    @Test
   	public void testGetIsResto() {
       	assertEquals(1, noeud.getIsResto());
   	}
       
    @Test
   	public void testSetIsResto() {
       	noeud.setIsResto(0);
       	assertEquals(0, noeud.getIsResto());
   	}
    
    @Test
	public void testGetIsHotel() {
    	assertEquals(1, noeud.getIsHotel());
	}
    
    @Test
	public void testSetIsHotel() {
    	noeud.setIsHotel(0);
    	assertEquals(0, noeud.getIsHotel());
	}
	
    @Test
	public void testGetPrix() {
    	assertEquals(60, noeud.getPrix());
	}
    
    @Test
	public void testSetPrix() {
    	noeud.setId(60);
    	assertEquals(60, noeud.getPrix());
	}

}

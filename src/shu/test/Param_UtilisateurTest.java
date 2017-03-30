package shu.test;

import static org.junit.Assert.*;

import org.junit.*;

import shu.model.Param_Utilisateur;

/**
 * Test methods in class Param_Utilisateur
 * 
 * @author shuyingxuan
 *
 */
public class Param_UtilisateurTest {
	
	private static Param_Utilisateur param_Utilisateur;
	
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
        param_Utilisateur = new Param_Utilisateur(1439, 900, 1100, 1230,
        		200, 1900, 2030, 200, 2300);
    }  
  
    @After  
    public void tearDown() throws Exception {  
        System.out.println("A test end");  
    }

	@Test
	public void testGetNbjour() {
		assertEquals(1439, param_Utilisateur.getNbjour());
	}

	@Test
	public void testSetNbjour() {
		param_Utilisateur.setNbjour(130);
		assertEquals(130, param_Utilisateur.getNbjour());
	}

	@Test
	public void testGetHeure_depart() {
		assertEquals(900, param_Utilisateur.getHeure_depart());
	}

	@Test
	public void testSetHeure_depart() {
		param_Utilisateur.setHeure_depart(1000);;
		assertEquals(1000, param_Utilisateur.getHeure_depart());
	}

	@Test
	public void testGetHeure_min_resto_midi() {
		assertEquals(1100, param_Utilisateur.getHeure_min_resto_midi());
	}

	@Test
	public void testSetHeure_min_resto_midi() {
		param_Utilisateur.setHeure_min_resto_midi(1100);
		assertEquals(1100, param_Utilisateur.getHeure_min_resto_midi());
	}

	@Test
	public void testGetHeure_max_resto_midi() {
		assertEquals(1230, param_Utilisateur.getHeure_max_resto_midi());
	}

	@Test
	public void testSetHeure_max_resto_midi() {
		param_Utilisateur.setHeure_max_resto_midi(1400);
		assertEquals(1400, param_Utilisateur.getHeure_max_resto_midi());
	}

	@Test
	public void testGetHeure_resto_midi() {
		assertEquals(200, param_Utilisateur.getHeure_resto_midi());
	}

	@Test
	public void testSetHeure_resto_midi() {
		param_Utilisateur.setHeure_resto_midi(100);
		assertEquals(100, param_Utilisateur.getHeure_resto_midi());
	}

	@Test
	public void testGetHeure_min_resto_soir() {
		assertEquals(1900, param_Utilisateur.getHeure_min_resto_soir());
	}

	@Test
	public void testSetHeure_min_resto_soir() {
		param_Utilisateur.setHeure_min_resto_soir(1800);
		assertEquals(1800, param_Utilisateur.getHeure_min_resto_soir());
	}

	@Test
	public void testGetHeure_max_resto_soir() {
		assertEquals(2030, param_Utilisateur.getHeure_max_resto_soir());
	}

	@Test
	public void testSetHeure_max_resto_soir() {
		param_Utilisateur.setHeure_max_resto_soir(2130);
		assertEquals(2130, param_Utilisateur.getHeure_max_resto_soir());
	}

	@Test
	public void testGetHeure_resto_soir() {
		assertEquals(200, param_Utilisateur.getHeure_resto_soir());
	}

	@Test
	public void testSetHeure_resto_soir() {
		param_Utilisateur.setHeure_resto_soir(100);
		assertEquals(100, param_Utilisateur.getHeure_resto_soir());
	}

	@Test
	public void testGetHeure_max_hotel() {
		assertEquals(2300, param_Utilisateur.getHeure_max_hotel());
	}

	@Test
	public void testSetHeure_max_hotel() {
		param_Utilisateur.setHeure_max_hotel(2330);
		assertEquals(2330, param_Utilisateur.getHeure_max_hotel());
	}

}

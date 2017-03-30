package shu.test;

import static org.junit.Assert.*;
import org.junit.*;

import shu.dao.DAO;
import shu.model.Arc;
import shu.model.Graphe;
import shu.model.Noeud;

/**
 * Test methods in class Graphe
 *  
 * @author shuyingxuan
 *
 */
public class GrapheTest {
	
	private static Graphe graphe;
	
	@BeforeClass
    public static void before()  
    {  
        System.out.println("Global");  
        String filePath = "./data/jour3_noeud312.csv";
        graphe = new Graphe(DAO.readTxtFile(filePath));
    }  
  
    @AfterClass  
    public static void after() {  
        System.out.println("Global destroy");  
    }  
	
	@Before  
    public void setUp() throws Exception {  
        System.out.println("A test start"); 
    }  
  
    @After  
    public void tearDown() throws Exception {  
        System.out.println("A test end");  
    }

	@Test
	public void testGetNoeudById() {
		Noeud noeud = new Noeud(0,1,0,60);
		assertEquals(noeud.getId(), graphe.getNoeudById(0).getId());
//		assertSame(noeud, graphe.getNoeudById(0));
//		assertThat(noeud, is(graphe.getNoeudById(0).getId()));
	}

	@Test
	public void testGetArcById() {
		Arc arc = new Arc(0, 0, 1, 39905.8, 1);
		assertEquals(arc.getIdArc(), graphe.getArcById(0).getIdArc());
	}

	@Test
	public void testGetArcList() {
		assertNotNull(graphe.getArcList());
	}

	@Test
	public void testGetArcListSize() {
		assertEquals(97344, graphe.getArcListSize());
	}

	@Test
	public void testGetNbNoeud() {
		assertEquals(312, graphe.getNbNoeud());
	}

	@Test
	public void testGetNbjour() {
		assertEquals(3, graphe.getNbjour());
	}

	@Test
	public void testGetHeure_depart() {
		assertEquals(900, graphe.getHeure_depart());
	}

	@Test
	public void testGetHeure_min_resto_midi() {
		assertEquals(1100, graphe.getHeure_min_resto_midi());
	}

	@Test
	public void testGetHeure_max_resto_midi() {
		assertEquals(1230, graphe.getHeure_max_resto_midi());
	}

	@Test
	public void testGetHeure_resto_midi() {
		assertEquals(200, graphe.getHeure_resto_midi());
	}

	@Test
	public void testGetHeure_min_resto_soir() {
		assertEquals(1900, graphe.getHeure_min_resto_soir());
	}

	@Test
	public void testGetHeure_max_resto_soir() {
		assertEquals(2030, graphe.getHeure_max_resto_soir());
	}

	@Test
	public void testGetHeure_resto_soir() {
		assertEquals(200, graphe.getHeure_resto_soir());
	}

	@Test
	public void testGetHeure_max_hotel() {
		assertEquals(2300, graphe.getHeure_max_hotel());
	}

}

package shu.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import shu.dao.DAO;
import shu.model.Graphe;
import shu.solution.Solution;

/**
 * Test methods in class Solution
 * 
 * @author shuyingxuan
 *
 */
public class SolutionTest {
	
	static String filePath = "./data/jour3_noeud250.csv";
	private static Graphe graphe = new Graphe(DAO.readTxtFile(filePath));
	private static Solution solution = new Solution(graphe);
	

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
    }  
  
    @After  
    public void tearDown() throws Exception {  
        System.out.println("A test end");  
    }

	@Test
	public void testCalculerTempsArriver() {
		assertEquals(1406, solution.calculerTempsArriver(39000, 1130));
	}

	@Test
	public void testCalculer() {
		List<List<Integer>> listResultat = new ArrayList<>();
		listResultat = solution.calculer();
		assertNotNull(listResultat);
	}

}

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

/**
 * Test methods in class DAO
 * 
 * @author shuyingxuan
 *
 */
public class DAOTest {
	
	private static DAO dao = new DAO();
	

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
	public void testReadTxtFile() {
    	String filePath = "./data/jour3_noeud250.csv";
		List<List<String>> listFile = new ArrayList<>();
		listFile = dao.readTxtFile(filePath);
		assertNotNull(listFile);
	}

    @Test
	public void testGetOutputFileName() {
    	String filePath = "./data/jour3_noeud250.csv";
		String outputFileName = dao.getOutputFileName(filePath);
		assertNotNull(outputFileName);
	}
    
    
}

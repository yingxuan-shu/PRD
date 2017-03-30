package shu.controller;

import shu.dao.DAO;
import shu.model.Graphe;
import shu.solution.Solution;

/**
 * Run the program
 * @author shuyingxuan
 *
 */
public class Lancer {
	public static void main(String[] args) throws Exception {

		// The data for testing
//		String filePath = "./data/jour1_noeud312.csv";
//		String filePath = "./data/jour1_noeud1439.csv";
			
		
		String filePath = args[0];
		System.out.println("Le fichier: " + filePath);
		
		// Start the timer
		long start = System.currentTimeMillis();
					
		Graphe graphe = new Graphe(DAO.readTxtFile(filePath));
		// Print the entire graph
//		graphe.print();
		Solution solution = new Solution(graphe);
		
		// Calculate results and write these results in a file
		DAO.writeTxtFile(solution.calculer(), filePath);
		
		// Stop the timer
		long end = System.currentTimeMillis();
		// Get a formatted calculating time in second
        System.out.println("Le temps de calcule total -> " + (float)(end - start)/1000 + " s");
        
//		Graphe graphe2 = new Graphe(DAO.readTxtFile(filePath03));
//		DAO.writeTxtFile(graphe2.calculer(), filePath03);
	
	}
}

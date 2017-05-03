package shu.solution;

import java.util.List;

public interface CalculerResultatInterface {
	
	/**
	 * The node path is converted in sequence
	 * 
	 * @param listNoeudRoute Feasible node paths for each meal or each night
	 * @return Feasible node paths in order from start node to end node
	 */
	public List<Integer> ajouterResultatNoeud(List<Integer> listNoeudRoute);
	
	/**
	 * Match feasible node paths today with paths yesterday to get all feasible node paths for whole travel
	 * If the end node of yesterday is the starting node of today, like [7]
	 * then paths today [7,8,9,10] match paths yesterday [0,3,5,7], 
	 * write paths combined [0,3,5,7,8,9,10] in the list of temporary results
	 * 
	 * @param today The day number of today
	 * @param listNoeudRoute Feasible node paths for each meal or each night
	 * @param listResultatRoute A list of temporary results within all feasible node paths for whole travel
	 * @param listResultat A list of all feasible node paths for whole travel
	 */
	public void calculerResultat(int today, List<Integer> listNoeudRoute, List<List<Integer>> listResultatRoute,
			List<List<Integer>> listResultat);
	

}

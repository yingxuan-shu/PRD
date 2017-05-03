package shu.solution;

import java.util.ArrayList;
import java.util.List;


/**
 * Use the list data with node paths to calculate and treat for getting the results
 * 
 * @author shuyingxuan
 *
 */
public class CalculerResultat implements CalculerResultatInterface{

	/**
	 * The node path is converted in sequence
	 * 
	 * @param listNoeudRoute Feasible node paths for each meal or each night
	 * @return Feasible node paths in order from start node to end node
	 */
	public List<Integer> ajouterResultatNoeud(List<Integer> listNoeudRoute){
		//System.out.println("listNoeudRouteJour.size : " + listNoeudRouteJour.size());
		List<Integer> listResultatNoeud = new ArrayList<>(); 
		if(!listNoeudRoute.isEmpty()){
			for (int i = listNoeudRoute.size()-1; i >= 0; i--) {
				listResultatNoeud.add(listNoeudRoute.get(i));
			}
		}
		return listResultatNoeud;
	}
	
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
			List<List<Integer>> listResultat){
		// Feasible node paths for each meal or each night
		List<Integer> listResultatJour = new ArrayList<>(); 
		listResultatJour = ajouterResultatNoeud(listNoeudRoute);

		if(!listResultatJour.isEmpty()){
			if(today > 1){
				for (int i = 0; i < listResultat.size(); i++) {
					// If the end node of yesterday is the starting node of today, like [7]
					if(listResultat.get(i).get(listResultat.get(i).size()-1).equals(listResultatJour.get(0))){
						List<Integer>  listResultatTemps = new ArrayList<>(); 
						List<Integer> listTemps = new ArrayList<>(); 

						// then paths today [7,8,9,10] match paths yesterday [0,3,5,7]
						listTemps.addAll(listResultat.get(i));
						listTemps.remove(listTemps.size()-1);
						listTemps.addAll(listResultatJour);
						listResultatTemps.addAll(listTemps);

						// write paths combined [0,3,5,7,8,9,10] in the list of temporary results
						if(!listResultatRoute.contains(listResultatTemps)){
							listResultatRoute.add(listResultatTemps);		
						}
					}				
				}
			} else {
				listResultat.add(listResultatJour);
			}
		}
	}
}

package shu.solution;

import java.util.List;
import java.util.Map;

public interface NoeudRouteInterface {
	
	/**
	 * If today is the lastest day, calculate whether the rider arrives at the finish node before afternoon
	 * if yes, get feasible restaurant nodes, and write paths in listNoeudRouteMidi
	 * 
	 * @param today The day number of today
	 * @param nbjour The day number of whole travel
	 * @param mapArriverMidi The feasible lunch restaurant nodes with their arrive time
	 * @param listResultatRoute A list of temporary results connected within all feasible node paths for whole travel
	 * @param endNoeud The end node of whole nodes
	 * @param listResultat  A list of all feasible node paths for whole travel
	 */
	public void noeudRouteMidi(int today, int nbjour, Map<Integer, Integer> mapArriverMidi, 
			List<List<Integer>> listResultatRoute, int endNoeud, List<List<Integer>> listResultat);
	
	
	/**
	 * If today is the lastest day, calculate whether the rider arrives at the finish node before night
	 * if yes, get feasible restaurant nodes, and write paths in listNoeudRouteSoir
	 * 
	 * @param today The day number of today
	 * @param nbjour The day number of whole travel
	 * @param mapArriverMidi The feasible lunch restaurant nodes with their arrive time
	 * @param mapArriverSoir The feasible diner restaurant nodes with their arrive time
	 * @param listResultatRoute A list of temporary results connected within all feasible node paths for whole travel
	 * @param endNoeud The end node of whole nodes
	 * @param listResultat A list of all feasible node paths for whole travel
	 */
	public void noeudRouteSoir(int today, int nbjour, Map<Integer, Integer> mapArriverMidi, 
			Map<Integer, Integer> mapArriverSoir, List<List<Integer>> listResultatRoute, 
			int endNoeud, List<List<Integer>> listResultat);
	
	/**
	 * If today is the lastest day, calculate whether the rider arrives at the finish node this night
	 * if yes, get feasible hotel nodes, and write paths in listNoeudRouteNuit
	 * 
	 * @param today The day number of today
	 * @param nbjour The day number of whole travel
	 * @param mapArriverMidi The feasible lunch restaurant nodes with their arrive time
	 * @param mapArriverSoir The feasible diner restaurant nodes with their arrive time
	 * @param mapArriverNuit The feasible hotel nodes with their arrive time
	 * @param listResultatRoute A list of temporary results connected within all feasible node paths for whole travel
	 * @param endNoeud The end node of whole nodes
	 * @param listResultat A list of all feasible node paths for whole travel
	 */
	public void noeudRouteNuit(int today, int nbjour, Map<Integer, Integer> mapArriverMidi, 
			Map<Integer, Integer> mapArriverSoir, Map<Integer, Integer> mapArriverNuit, 
			List<List<Integer>> listResultatRoute, int endNoeud, List<List<Integer>> listResultat);
	
	/**
	 * If today isn't the lastest day, calculate today's feasible paths, and write paths in listNoeudRouteJour
	 * 
	 * @param today The day number of today
	 * @param mapArriverMidi The feasible lunch restaurant nodes with their arrive time
	 * @param mapArriverSoir The feasible diner restaurant nodes with their arrive time
	 * @param mapArriverNuit The feasible hotel nodes with their arrive time
	 * @param listResultatRoute A list of temporary results connected within all feasible node paths for whole travel
	 * @param listResultat A list of all feasible node paths for whole travel
	 * @param distance_max The maximum distance
	 * @param distance_min The minimum distance
	 * @param endNoeud The end node of whole nodes 
	 * @param nbjour The day number of whole travel
	 */
	public void noeudRouteJour(int today, Map<Integer, Integer> mapArriverMidi, 
			Map<Integer, Integer> mapArriverSoir, Map<Integer, Integer> mapArriverNuit, 
			List<List<Integer>> listResultatRoute, List<List<Integer>> listResultat, 
			double distance_max, double distance_min,  int endNoeud, int nbjour);

}

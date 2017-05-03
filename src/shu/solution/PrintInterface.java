package shu.solution;

import java.util.List;
import java.util.Map;

public interface PrintInterface {
	
	/**
	 * Print lists of live edges, lists of live nodes, and the time of departure 
	 * from the restaurant or the time of arrival at the hotel
	 * 
	 * @param mapArriver The live edges and arrive time map for each meal or each night
	 */
	public void printLiveList(Map<Integer, Integer> mapArriver);
	
	/**
	 * Print feasible node paths 
	 * 
	 * @param listNoeudRoute Feasible node paths for each meal or each night
	 */
	public void printNoeudRouteList(List<Integer> listNoeudRoute);
	
	/**
	 * Print all feasible node paths for whole travel
	 * 
	 * @param listResultat All feasible node paths for whole travel
	 */
	public void printResultatList(List<List<Integer>> listResultat);

}

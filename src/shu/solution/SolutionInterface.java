package shu.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import shu.model.Graphe;

public interface SolutionInterface {
//	Create a graph with nodes and edges
	Graphe graphe = new Graphe();
//	 A list of all feasible node paths for whole travel
	List<List<Integer>> listResultat = new ArrayList<>();

	/**
	 * Calculate arrive time with speed 15km/h
	 * 
	 * @param a This is the distance entre teo nodes
	 * @param b This is the departure time 
	 * @return The arrive time at restaurant or hotel
	 */
	int calculerTempsArriver(double a, double b);

	/**
	 * Calculate feasible lunch restaurant nodes, and add these nodes with their departure again time in Map Arriver Midi 
	 * 
	 * @param today The day number of today
	 * @param nbjour The day number of whole travel
	 * @param startNoeudMidi The start node this morning
	 * @param mapArriverMidi The feasible lunch restaurant nodes with their departure again time
	 * @param listResultatRoute A list of temporary results connected within all feasible node paths for whole travel
	 * @param listArcSize The size of all the edges
	 * @param nbNoeud The total number of nodes
	 * @param distance_max The maximum distance
	 * @param distance_min The minimum distance
	 * @param listNoeudArriverMidi A list of temporary feasible nodes every noon, each node can be arriver only one time every noon
	 */
	void calculerRestoMidi(int today, int nbjour, int startNoeudMidi, 
			Map<Integer, Integer> mapArriverMidi, List<List<Integer>> listResultatRoute, 
			int listArcSize, int nbNoeud, double distance_max, double distance_min, 
			List<Integer> listNoeudArriverMidi);
	
	/**
	 * Calculate feasible diner restaurant nodes, and add these nodes with their departure again time in Map Arriver Soir 
	 * 
	 * @param today The day number of today
	 * @param nbjour The day number of whole travel
	 * @param mapArriverMidi The feasible lunch restaurant nodes with their departure again time
	 * @param mapArriverSoir The feasible diner restaurant nodes with their departure again time
	 * @param listResultatRoute A list of temporary results connected within all feasible node paths for whole travel
	 * @param listArcSize The size of all the edges
	 * @param nbNoeud The total number of nodes
	 * @param distance_max The maximum distance
	 * @param distance_min The minimum distance
	 * @param listNoeudArriverSoir A list of temporary feasible nodes every afternoon, each node can be arriver only one time every afternoon
	 */
	public void calculerRestoSoir(int today, int nbjour, Map<Integer, Integer> mapArriverMidi, 
			Map<Integer, Integer> mapArriverSoir, List<List<Integer>> listResultatRoute, 
			int listArcSize, int nbNoeud, double distance_max, double distance_min, 
			List<Integer> listNoeudArriverSoir);
	
	
	/**
	 * Calculate feasible hotel nodes, and add these nodes with their arrive time in Map Arriver Nuit 
	 * 
	 * @param today The day number of today
	 * @param nbjour The day number of whole travel
	 * @param mapArriverMidi The feasible lunch restaurant nodes with their arrive time
	 * @param mapArriverSoir The feasible diner restaurant nodes with their arrive time
	 * @param mapArriverNuit The feasible hotel nodes with their arrive time
	 * @param listResultatRoute A list of temporary results connected within all feasible node paths for whole travel
	 * @param listArcSize The size of all the edges
	 * @param nbNoeud The total number of nodes
	 * @param distance_max The maximum distance
	 * @param distance_min The minimum distance
	 * @param listNoeudArriverNuit A list of temporary feasible nodes every night, each node can be arriver only one time every night
	 */
	public void calculerHotelNuit(int today, int nbjour, Map<Integer, Integer> mapArriverMidi, 
			Map<Integer, Integer> mapArriverSoir, Map<Integer, Integer> mapArriverNuit, 
			List<List<Integer>> listResultatRoute, int listArcSize, int nbNoeud, 
			double distance_max, double distance_min, List<Integer> listNoeudArriverNuit);
	
	/**
	 * Calculate feasible paths for whole travel
	 * 
	 * @return listResultat All feasible node paths for whole travel
	 */
	public List<List<Integer>> calculer();
	
	
}

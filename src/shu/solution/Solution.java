package shu.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import shu.model.Arc;
import shu.model.Graphe;
import shu.model.Noeud;

/**
 * Calculate the results with the graph
 * 
 * @author shuyingxuan
 *
 */
public class Solution {
//	Create a graph with nodes and edges
	Graphe graphe = new Graphe();
//	 A list of all feasible node paths for whole travel
	List<List<Integer>> listResultat = new ArrayList<>();
//	Choose better solutions using less price, more distance and less insecurity
	ChoisirSolution choisirSolution;
//	Calculate today's feasible paths, and write paths in a list
	NoeudRoute noeudRoute;
//	Print the information or the results
	Print print;
	
	/**
	 * Constructs a new Solution with graph
	 * 
	 * @param graphe A graph with nodes and edges from the file 
	 */
	public Solution(Graphe graphe) {
		super();
		this.graphe = graphe;
		choisirSolution = new ChoisirSolution(graphe);
		noeudRoute = new NoeudRoute(graphe);
		print = new Print(graphe);
	}

	/**
	 * Calculate arrive time with speed 15km/h
	 * 
	 * @param a This is the distance entre teo nodes
	 * @param b This is the departure time 
	 * @return The arrive time at restaurant or hotel
	 */
	public int calculerTempsArriver(double a, double b) {
		// 15km/h, m->km
		a = a/15000; 
		// Calculate an integer to get the hour
		double a1 = Math.floor(a); 
		 // Calculate a decimal number to get the minute
		double a2 = a - a1;
		// Calculate an integer to get the hour
		double b1 = Math.floor(b/100); 
		// Calculate a decimal number to get the minute
		double b2 = ((b/100 - b1)*100)/60; 
		double c = 0;

		// If the minute is more than an hour
		if((a2+b2)>=1){
			c = ((a2+b2-1)*60 + (a1+b1+1)*100);
		}
		else{
			c = ((a2+b2)*60 + (a1+b1)*100);
		}	
		return (int)c;
	}

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
	public void calculerRestoMidi(int today, int nbjour, int startNoeudMidi, 
			Map<Integer, Integer> mapArriverMidi, List<List<Integer>> listResultatRoute, 
			int listArcSize, int nbNoeud, double distance_max, double distance_min, 
			List<Integer> listNoeudArriverMidi){

		int tempsArriver = 0; 
		// If the start node isn't the finish node 
		if(startNoeudMidi >= 0 && startNoeudMidi < nbNoeud-1){
			// Calculate from the start node line 
			for(int i = startNoeudMidi * nbNoeud; i < listArcSize; i++){
				Arc arc = new Arc();
				arc = graphe.getArcById(i);

				if(arc.getDistance() > 0 
//						&& arc.getNoeud_end() > arc.getNoeud_start() 
						&& graphe.getArcById(startNoeudMidi*nbNoeud+nbNoeud-1).getDistance() <= distance_max*nbjour
						&& startNoeudMidi == arc.getNoeud_start()){
					// The arriver time
					tempsArriver = calculerTempsArriver(arc.getDistance(), graphe.getHeure_depart());
//					System.out.println("Heure d'arrivée midi : " + tempsArriver);
					Noeud arriverNoeudMidi = new Noeud();
					arriverNoeudMidi = graphe.getNoeudById(arc.getNoeud_end());

					if(tempsArriver <= graphe.getHeure_max_resto_midi()) {
//						if(today == nbjour){
//							if(arriverNoeudMidi.getId() == nbNoeud-1)
////									&& (arriverNoeudMidi.getIsResto() == 0 
////									&& arriverNoeudMidi.getIsHotel() == 0
//									{
////								mapArriverMidi.put(arc.getIdArc(), -1); // 到达终点，不出发了
//								
//								if(!listNoeudArriverMidi.contains(arc.getNoeud_end())){
////									int tempsPartir = tempsArriver + graphe.getHeure_resto_soir();
//									mapArriverMidi.put(arc.getIdArc(), -1);
//									listNoeudArriverMidi.add(arc.getNoeud_end());
////									System.out.println("!!! nbNoeud: " + nbNoeud);	
//								}
//								
//							}
//						}
						
						
						
						if((tempsArriver >= graphe.getHeure_min_resto_midi() 
								&& arriverNoeudMidi.getIsResto() == 1
								&& arc.getDistance() > distance_min/8.5*3.5)
//								 If this node is the end node, it has already arrived at the end node
								|| (today == nbjour && arriverNoeudMidi.getId() == nbNoeud-1)
								){

							if(!listNoeudArriverMidi.contains(arc.getNoeud_end())){
								int tempsPartir = tempsArriver + graphe.getHeure_resto_soir();
								mapArriverMidi.put(arc.getIdArc(), tempsPartir);
								listNoeudArriverMidi.add(arc.getNoeud_end());
							}
							
//							int flag = 1;
////							// time restart = lunch time + arrive time 
//							int tempsPartir = tempsArriver + graphe.getHeure_resto_midi();
//							if(mapArriverMidi.size() > 0 ){
//								Iterator<Map.Entry<Integer, Integer>> iterator = mapArriverMidi.entrySet().iterator();
//								while (iterator.hasNext()) {
//									Map.Entry<Integer, Integer> entry = iterator.next();
//									if(graphe.getArcById(entry.getKey()).getNoeud_end() == arc.getNoeud_end()){
//										if(entry.getValue() > tempsPartir){
//											flag = 2;
//											iterator.remove();
//										} else {
//											flag = -1;
//										}
//										
//									} else {
//										flag = 1;
//									}
//								}
//							}		
//							
//							// If flag is 1, map dosen't have this edge, add this edge and its tempsArriver
//							// If flag is 2, map already has this edge, but this new tempsArriver 
//							//  				is bettter than old tempsArriver, it need to replace 
//							// If flag is -1, map already has this edge, but this new tempsArriver 
//							//  				is worse than old tempsArriver, do nothing
//							if(flag == 1){
//								mapArriverMidi.put(arc.getIdArc(), tempsPartir);
//							} else if(flag == 2){
//								mapArriverMidi.put(arc.getIdArc(), tempsPartir);
//							}
//							System.out.println("!!! Midi count: " + count);	
						}
					}
				}
			}
		}

//		if(mapArriverMidi.size() > 0){
//			System.out.println("Arriver au restaurant à midi " + mapArriverMidi.size());
//		} 
//		Print lists of live edges, lists of live nodes, and the time of departure 
//		print.printLiveList(mapArriverMidi);
//		If today is the lastest day, print lists of live edges, lists of live nodes, and the time of departure 
		if(today == nbjour)
			noeudRoute.noeudRouteMidi(today, nbjour, mapArriverMidi, listResultatRoute, nbNoeud-1, listResultat);
//		System.out.println("\t");
	}


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
			List<Integer> listNoeudArriverSoir){

		int tempsArriver = 0; 

		if(mapArriverMidi.size() > 0 && mapArriverMidi.size() < 10000) {
			
			for (Map.Entry<Integer, Integer> entry: mapArriverMidi.entrySet()) {  
				// The start node this afternoon
				int startNoeudSoir = graphe.getArcById(entry.getKey()).getNoeud_end();
				int arcStart = graphe.getArcById(entry.getKey()).getNoeud_start();
				if(startNoeudSoir > 0 && startNoeudSoir < nbNoeud-1){
					// Calculate from the start node line, the start node is tne end node of each edge
					int temp = entry.getKey()+nbNoeud*(startNoeudSoir-arcStart)-startNoeudSoir;
					for(int i=temp; i<listArcSize; i++){
						Arc arc = new Arc();
						arc = graphe.getArcById(i);

						if(arc.getDistance() > 0 
//								&& arc.getNoeud_end() > arc.getNoeud_start()
								&& graphe.getArcById(startNoeudSoir*nbNoeud+nbNoeud-1).getDistance() <= distance_max*nbjour
								&& startNoeudSoir == arc.getNoeud_start()){
							tempsArriver = calculerTempsArriver(arc.getDistance(), entry.getValue());
//							System.out.println("Heure d'arrivée soir : " + tempsArriver);
							Noeud arriverNoeudSoir = new Noeud();
							arriverNoeudSoir = graphe.getNoeudById(arc.getNoeud_end());

							if(tempsArriver <= graphe.getHeure_max_resto_soir()-100){
//								if(today == nbjour){
//									if(arriverNoeudSoir.getId() == nbNoeud-1) 
////											&& (arriverNoeudMidi.getIsResto() == 0 
////											&& arriverNoeudMidi.getIsHotel() == 0
//											{
////										mapArriverMidi.put(arc.getIdArc(), -1); // 到达终点，不出发了
//										
//										if(!listNoeudArriverSoir.contains(arc.getNoeud_end())){
////											int tempsPartir = tempsArriver + graphe.getHeure_resto_soir();
//											mapArriverSoir.put(arc.getIdArc(), -1);
//											listNoeudArriverSoir.add(arc.getNoeud_end());
//										}
//										
//									}
//								}
								
								
								if((tempsArriver >= graphe.getHeure_min_resto_soir() 
										&& arriverNoeudSoir.getIsResto() == 1
										&& arc.getDistance() > distance_min/8.5*3.5)
										|| (today == nbjour && arriverNoeudSoir.getId() == nbNoeud-1)
										){
//									System.out.println("Heure d'arrivée soir : " + tempsArriver);
									
									if(!listNoeudArriverSoir.contains(arc.getNoeud_end())){
										int tempsPartir = tempsArriver + graphe.getHeure_resto_soir();
										mapArriverSoir.put(arc.getIdArc(), tempsPartir);
										listNoeudArriverSoir.add(arc.getNoeud_end());
									}
								}
							}
						}
					}
				}
			}
		}

//		if(mapArriverSoir.size() > 0){
//			System.out.println("Arriver au restaurant à soir " + mapArriverSoir.size());
//		} 
//		Print lists of live edges, lists of live nodes, and the time of departure 
//		print.printLiveList(mapArriverSoir);
//		If today is the lastest day, calculate whether the rider arrives at the finish node before night
		if(today == nbjour)
			noeudRoute.noeudRouteSoir(today, nbjour, mapArriverMidi, mapArriverSoir, listResultatRoute, nbNoeud-1, listResultat);
//		System.out.println("\t");
	}


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
			double distance_max, double distance_min, List<Integer> listNoeudArriverNuit){

		int tempsArriver = 0; 		

		if(mapArriverSoir.size() > 0  && mapArriverSoir.size() < 20000) {
			for (Map.Entry<Integer, Integer> entry: mapArriverSoir.entrySet()) {  
				// The start node this night
				int startNoeudNuit = graphe.getArcById(entry.getKey()).getNoeud_end();
				int arcStart = graphe.getArcById(entry.getKey()).getNoeud_start();
				if(startNoeudNuit > 0 && startNoeudNuit < nbNoeud-1){
					// Calculate from the start node line, the start node is the end node of each edge
					int temp = entry.getKey()+nbNoeud*(startNoeudNuit-arcStart)-startNoeudNuit;
					for(int i=temp; i<listArcSize; i++){
						
						Arc arc = new Arc();
						arc = graphe.getArcById(i);
						if(arc.getDistance() > 0 
//								&& arc.getNoeud_end() > arc.getNoeud_start()
								&& graphe.getArcById(startNoeudNuit*nbNoeud+nbNoeud-1).getDistance() <= distance_max*nbjour
								&& startNoeudNuit == arc.getNoeud_start()){
							
							tempsArriver = calculerTempsArriver(arc.getDistance(), entry.getValue());
//							System.out.println("!!!tempsArriver: " + tempsArriver);		
							Noeud arriverNoeudNuit = new Noeud();
							arriverNoeudNuit = graphe.getNoeudById(arc.getNoeud_end());

							if(tempsArriver <= graphe.getHeure_max_hotel()-100){
								
//								if(today == nbjour){
//									if(arriverNoeudNuit.getId() == nbNoeud-1) 
////											&& (arriverNoeudMidi.getIsResto() == 0 
////											&& arriverNoeudMidi.getIsHotel() == 0
//										{
////										mapArriverMidi.put(arc.getIdArc(), -1); // 到达终点，不出发了
//										
//										if(!listNoeudArriverNuit.contains(arc.getNoeud_end())){
////											int tempsPartir = tempsArriver + graphe.getHeure_resto_soir();
//											mapArriverNuit.put(arc.getIdArc(), -1);
//											listNoeudArriverNuit.add(arc.getNoeud_end());
//										}
//										
//									}
//								}
								
								if((arriverNoeudNuit.getIsHotel() == 1
										&& arc.getDistance() > distance_min/8.5*3.5) 
										|| ((today == nbjour) && (arriverNoeudNuit.getId() == nbNoeud-1))
										){

									if(!listNoeudArriverNuit.contains(arc.getNoeud_end())){
										mapArriverNuit.put(arc.getIdArc(), tempsArriver);
										listNoeudArriverNuit.add(arc.getNoeud_end());
									}	
								}
							}
						}
					}
				}	
			}
		}
		
//		if(mapArriverNuit.size() > 0){
//			System.out.println("Arriver à l'hotel à nuit " + mapArriverNuit.size());
//		} 
//		Print lists of live edges, lists of live nodes, and the time of departure 
//		print.printLiveList(mapArriverNuit);	
//		If today is the lastest day, calculate whether the rider arrives at the finish node this night
		if(today == nbjour)
			noeudRoute.noeudRouteNuit(today, nbjour, mapArriverMidi, mapArriverSoir, mapArriverNuit, 
					listResultatRoute, nbNoeud-1, listResultat);
//		System.out.println("\t");
	}


	/**
	 * Calculate feasible paths for whole travel
	 * 
	 * @return listResultat All feasible node paths for whole travel
	 */
	public List<List<Integer>> calculer() {
		// nbjour The day number of whole travel
		int nbjour = graphe.getNbjour();		
		// The size of all the edges
		int listArcSize = graphe.getArcListSize();
		// The total number of nodes
		int nbNoeud = graphe.getNbNoeud();
		
		// The maximum distance every day = 15km/h * 10h = 150km 150000m
		double distance_max = (graphe.getHeure_min_resto_midi()-graphe.getHeure_depart()
				+ graphe.getHeure_min_resto_soir()-(graphe.getHeure_min_resto_midi()+graphe.getHeure_resto_midi())
				+ graphe.getHeure_max_hotel()-(graphe.getHeure_min_resto_soir()+graphe.getHeure_resto_soir()))/100*15000;
		// The minimum distance every day = distance_total - (nbjour - 1)*distance_max
		double distance_min = graphe.getArcById(nbNoeud-1).getDistance() - (nbjour -1)*distance_max;
		if(distance_min < 0){
			distance_min = 0;
		}

		// A list of departure nodes id for everyday
		List<Integer> listNoeudPartir = new ArrayList<>(); 
		
		// today=i, The day number of today
		for(int i=1; i <= nbjour; i++){
			// A list of temporary results connected within all feasible node paths for whole travel
			List<List<Integer>> listResultatRoute = new ArrayList<>(); 
			List<Integer> listNoeudArriverMidi = new ArrayList<>();
			// A list of temporary feasible nodes every afternoon, each node can be arriver only one time every afternoon
			List<Integer> listNoeudArriverSoir = new ArrayList<>(); 
			// A list of temporary feasible nodes every night, each node can be arriver only one time every night
			List<Integer> listNoeudArriverNuit = new ArrayList<>(); 
			
			System.out.println( "Le " + i + " jour ");
			
			if(i == 1) {
				listNoeudPartir.add(0);
			} else if(listNoeudPartir.size() < 1){
				System.out.println("Le " + i + " jour" + " n'a pas noeud départ ! ");
			}
			
			for (int k = 0; k < listNoeudPartir.size(); k++) {
				// Map<idArc, tempsPartir／arrivertemps>; 
				// The feasible lunch restaurant nodes with their arrive time
				Map<Integer, Integer> mapArriverMidi = new HashMap<Integer, Integer>();
				// The feasible diner restaurant nodes with their arrive time
				Map<Integer, Integer> mapArriverSoir = new HashMap<Integer, Integer>();
				// The feasible hotel nodes with their arrive time
				Map<Integer, Integer> mapArriverNuit = new HashMap<Integer, Integer>();
//				
				int startNoeudMidi = listNoeudPartir.get(k);
//				System.out.println("Départ Noeud Midi : " + startNoeudMidi);

//				long startMidi = System.currentTimeMillis();
				calculerRestoMidi(i, nbjour, startNoeudMidi, mapArriverMidi, listResultatRoute, 
						listArcSize, nbNoeud, distance_max, distance_min, listNoeudArriverMidi);
//				long endMidi = System.currentTimeMillis();
//				System.out.println("Midi -> " + (endMidi - startMidi) + " ms");
				
//				long startSoir = System.currentTimeMillis();
				calculerRestoSoir(i, nbjour, mapArriverMidi, mapArriverSoir, listResultatRoute, 
						listArcSize, nbNoeud, distance_max, distance_min, listNoeudArriverSoir);
//				long endSoir = System.currentTimeMillis();
//				System.out.println("Soir -> " + (endSoir - startSoir) + " ms");
				
//				long startNuit = System.currentTimeMillis();
				calculerHotelNuit(i, nbjour, mapArriverMidi, mapArriverSoir, mapArriverNuit, 
						listResultatRoute, listArcSize, nbNoeud, distance_max, distance_min, listNoeudArriverNuit);
//		        long endNuit = System.currentTimeMillis();
//				System.out.println("Nuit -> " + (endNuit - startNuit) + " ms");

				
// 				System.out.println("Aujourd'hui ");
//				Calculate today's feasible paths, and write paths in listNoeudRouteJour
				noeudRoute.noeudRouteJour(i, mapArriverMidi, mapArriverSoir, mapArriverNuit, listResultatRoute, 
							listResultat, distance_max, distance_min, nbNoeud-1, nbjour);
			}
			// Get the list of results connected within all feasible node paths for whole travel
			if(i > 1){
				listResultat = listResultatRoute;
			}
			listNoeudPartir.clear();
			listNoeudPartir.addAll(listNoeudArriverNuit);
		}
		
		// Print all feasible node paths for whole travel
//		print.printResultatList(listResultat);
		System.out.println("Les chemins réalisables: " + listResultat.size());
		// Choose better solutions using price, distance and insecurity
		choisirSolution.choisirSolution(listResultat);
		return listResultat;
	}
}

package shu.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import shu.model.Graphe;

/**
 * Calculate today's feasible paths, and write paths in a list
 * 
 * @author shuyingxuan
 *
 */
public class NoeudRoute {
//	Create a graph with nodes and edges
	Graphe graphe = new Graphe();
//	Print the information or the results
	Print print;
//	Use the list data with node paths to calculate and treat for getting the results
	CalculerResultat calResultat;
	
	/**
	 *  Constructs a new Print with graph
	 * 
	 * @param graphe Create a graph with nodes and edges
	 */
	public NoeudRoute(Graphe graphe) {
		super();
		this.graphe = graphe;
		print = new Print(graphe);
		calResultat = new CalculerResultat();
	}


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
			List<List<Integer>> listResultatRoute, int endNoeud, List<List<Integer>> listResultat){

		if(mapArriverMidi.size() > 0) {
			for (Map.Entry<Integer, Integer> entry: mapArriverMidi.entrySet()) { 
				// Calculate whether the rider arrives at the finish node
				if(graphe.getArcById(entry.getKey()).getNoeud_end() == endNoeud){
					// A path list with the rider arrives at the finish node before afternoon
					List<Integer> listNoeudRouteMidi = new ArrayList<>(); 	
					listNoeudRouteMidi.add(graphe.getArcById(entry.getKey()).getNoeud_end());
					listNoeudRouteMidi.add(graphe.getArcById(entry.getKey()).getNoeud_start());

//					System.out.println("!!!endNoeud: " + endNoeud);	
					if(nbjour == today){						
//						print.printNoeudRouteList(listNoeudRouteMidi);
						calResultat.calculerResultat(today, listNoeudRouteMidi, listResultatRoute, listResultat);
					}		
				}
			}
		}		
	}
	

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
			int endNoeud, List<List<Integer>> listResultat){
		
		if(mapArriverSoir.size() > 0) {		
			for (Map.Entry<Integer, Integer> entry: mapArriverSoir.entrySet()) { 
				// 如果是最后的终点，则计算路径
				// Calculate whether the rider arrives at the finish node
				if(graphe.getArcById(entry.getKey()).getNoeud_end() == endNoeud){
					// A path list with the rider arrives at the finish node before afternoon
					List<Integer> listNoeudRouteSoir = new ArrayList<>();
		
					listNoeudRouteSoir.add(graphe.getArcById(entry.getKey()).getNoeud_end());
					int noeudRoute = graphe.getArcById(entry.getKey()).getNoeud_start();
					listNoeudRouteSoir.add(noeudRoute);

					if(mapArriverMidi.size() > 0) {
						for (Map.Entry<Integer, Integer> entryMidi: mapArriverMidi.entrySet()) { 
							if(graphe.getArcById(entryMidi.getKey()).getNoeud_end() == noeudRoute){
								listNoeudRouteSoir.add(graphe.getArcById(entryMidi.getKey()).getNoeud_start());
							}
						}
					}
					if(nbjour == today){						
//					print.printNoeudRouteList(listNoeudRouteSoir);
					calResultat.calculerResultat(today,listNoeudRouteSoir, listResultatRoute, listResultat);
					}
//					listNoeudRouteSoir.clear();
//					System.out.println("!!!endNoeud: " + endNoeud);	
				}
			}	
		}
	}


	
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
			List<List<Integer>> listResultatRoute, int endNoeud, List<List<Integer>> listResultat){
		
		if(mapArriverNuit.size() > 0) {			
			for (Map.Entry<Integer, Integer> entry: mapArriverNuit.entrySet()) { 
				// Calculate whether the rider arrives at the finish node
				if(graphe.getArcById(entry.getKey()).getNoeud_end() == endNoeud){
					int noeudRoute = graphe.getArcById(entry.getKey()).getNoeud_start();
					
					if(mapArriverSoir.size() > 0) {
						for (Map.Entry<Integer, Integer> entrySoir: mapArriverSoir.entrySet()) { 			
							if(graphe.getArcById(entrySoir.getKey()).getNoeud_end() == noeudRoute){		
								int noeudRoute2 = graphe.getArcById(entrySoir.getKey()).getNoeud_start();
								// A path list with the rider arrives at the finish node before afternoon
								List<Integer> listNoeudRouteNuit = new ArrayList<>(); 
								listNoeudRouteNuit.add(graphe.getArcById(entry.getKey()).getNoeud_end());
								listNoeudRouteNuit.add(noeudRoute);
								listNoeudRouteNuit.add(noeudRoute2);
															
								if(mapArriverMidi.size() > 0) {
									for (Map.Entry<Integer, Integer> entryMidi: mapArriverMidi.entrySet()) { 
										if(graphe.getArcById(entryMidi.getKey()).getNoeud_end() == noeudRoute2){
											listNoeudRouteNuit.add(graphe.getArcById(entryMidi.getKey()).getNoeud_start());
											
											if(nbjour == today){						
//												print.printNoeudRouteList(listNoeudRouteNuit);
												calResultat.calculerResultat(today, listNoeudRouteNuit, listResultatRoute, listResultat);
											}
//											listNoeudRouteNuit.clear();
										}
									}
								}
							}
						}
					}
					
					
				}	
			}
		}
	}


	/**
	 * If today isn't the lastest day, calculate today's feasible paths, and write paths in listNoeudRouteJour
	 * 
	 * @param today The day number of today
	 * @param mapArriverMidi The feasible lunch restaurant nodes with their arrive time
	 * @param mapArriverSoir The feasible diner restaurant nodes with their arrive time
	 * @param mapArriverNuit The feasible hotel nodes with their arrive time
	 * @param listResultatRoute A list of temporary results connected within all feasible node paths for whole travel
	 * @param listResultat All feasible node paths for whole travel
	 * @param distance_max The maximum distance
	 * @param distance_min The minimum distance
	 * @param listResultat A list of all feasible node paths for whole travel
	 */
	public void noeudRouteJour(int today, Map<Integer, Integer> mapArriverMidi, 
			Map<Integer, Integer> mapArriverSoir, Map<Integer, Integer> mapArriverNuit, 
			List<List<Integer>> listResultatRoute, List<List<Integer>> listResultat, 
			double distance_max, double distance_min,  int endNoeud, int nbjour){

		if(mapArriverNuit.size() > 0) {
			int noeudJour;
			int noeudRoute;
			
			for (Map.Entry<Integer, Integer> entry: mapArriverNuit.entrySet()) {
				// The start node of today's path
				noeudJour = graphe.getArcById(entry.getKey()).getNoeud_end();
				// The second node of today's path
				noeudRoute = graphe.getArcById(entry.getKey()).getNoeud_start();

				if(mapArriverSoir.size() > 0) {
					for (Map.Entry<Integer, Integer> entrySoir: mapArriverSoir.entrySet()) { 	
						int noeudJour2 = graphe.getArcById(entrySoir.getKey()).getNoeud_end();
						if(noeudJour2 == noeudRoute){
							int noeudRoute2 = graphe.getArcById(entrySoir.getKey()).getNoeud_start();
							// Feasible node paths for each meal or each night
							List<Integer> listNoeudRouteJour = new ArrayList<>(); 
							listNoeudRouteJour.add(noeudJour);
							listNoeudRouteJour.add(noeudRoute);
							listNoeudRouteJour.add(noeudRoute2);

							if(mapArriverMidi.size() > 0) {	
								for (Map.Entry<Integer, Integer> entryMidi: mapArriverMidi.entrySet()) { 	
									noeudJour2 = graphe.getArcById(entryMidi.getKey()).getNoeud_end();
									// Calculate distance everyday
									double distanceJour = graphe.getArcById(entry.getKey()).getDistance() 
											+ graphe.getArcById(entrySoir.getKey()).getDistance()
											+ graphe.getArcById(entryMidi.getKey()).getDistance();
									
//									if(noeudJour2 == noeudRoute2){
									if(noeudJour2 == noeudRoute2 && distanceJour >= distance_min
											&& distanceJour <= distance_max){

										if(today < nbjour){

											listNoeudRouteJour.add(graphe.getArcById(entryMidi.getKey()).getNoeud_start());
											calResultat.calculerResultat(today, listNoeudRouteJour, listResultatRoute, listResultat);	
//											print.printNoeudRouteList(listNoeudRouteJour);
										} else if(graphe.getArcById(entry.getKey()).getNoeud_end() == endNoeud
												&& today == nbjour) {
											listNoeudRouteJour.add(graphe.getArcById(entryMidi.getKey()).getNoeud_start());
											calResultat.calculerResultat(today, listNoeudRouteJour, listResultatRoute, listResultat);	
//											print.printNoeudRouteList(listNoeudRouteJour);
										} 

									}
								}
							}
						}
					} 
				}
			}	
		}
	}

}

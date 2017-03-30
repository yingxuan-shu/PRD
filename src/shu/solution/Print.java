package shu.solution;

import java.util.List;
import java.util.Map;

import shu.model.Graphe;

/**
 * Print the information or the results
 * 
 * @author shuyingxuan
 *
 */
public class Print {
//	Create a graph with nodes and edges
	Graphe graphe = new Graphe();

	/**
	 * Constructs a new Print with graph 
	 * 
	 * @param graphe Create a graph with nodes and edges
	 */
	public Print(Graphe graphe) {
		super();
		this.graphe = graphe;
	}

	/**
	 * Print lists of live edges, lists of live nodes, and the time of departure 
	 * from the restaurant or the time of arrival at the hotel
	 * 
	 * @param mapArriver The live edges and arrive time map for each meal or each night
	 */
	public void printLiveList(Map<Integer, Integer> mapArriver){
		
		if(mapArriver.size() > 0) {
//			System.out.println("Liste des arcs vivants arrivant au restaurant／hôtel");
			for (Map.Entry<Integer, Integer> entry: mapArriver.entrySet()) { 
				System.out.print("Les arcs vivants: ");
				graphe.getArcById(entry.getKey()).printArcAll();
				System.out.print("Les nœuds vivants: ");
			    graphe.getNoeudById(graphe.getArcById(entry.getKey()).getNoeud_end()).printNoeudAll();
			    System.out.print("Les heures départs: ");
			    System.out.println(entry.getValue());
			}
		}
	}
	
	/**
	 * Print feasible node paths 
	 * 
	 * @param listNoeudRoute Feasible node paths for each meal or each night
	 */
	public void printNoeudRouteList(List<Integer> listNoeudRoute){
		//System.out.println("listNoeudRoute.size : " + listNoeudRoute.size());
		if(listNoeudRoute.size() > 0){
			System.out.println("La liste de chemins de nœuds réalisable : ");
			for (int i = listNoeudRoute.size()-1; i >= 0; i--) {
				System.out.print(listNoeudRoute.get(i) + " ");
			}
			System.out.println("\t");
		}
	}
	
	/**
	 * Print all feasible node paths for whole travel
	 * 
	 * @param listResultat All feasible node paths for whole travel
	 */
	public void printResultatList(List<List<Integer>> listResultat){
		//System.out.println("listNoeudRouteJour.size : " + listNoeudRouteJour.size());
		if(listResultat.size() > 0){
			System.out.println("Les résultats réalisable : ");
			for (int i = 0; i < listResultat.size(); i++) {
				if(listResultat.get(i).size() > 0){
					System.out.println(listResultat.get(i));
				}
			}
		} else{
			System.out.println("Le résultat réalisable n'existe pas! ");
		}
	}
}

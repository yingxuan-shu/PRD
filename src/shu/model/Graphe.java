package shu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Create a graph with nodes and edges
 * @author shuyingxuan
 *
 */
public class Graphe {
	
	static Param_Utilisateur param;
	// List of nodes
	List<Noeud> listNoeud = new ArrayList<>();
	// List of edges
	List<Arc> listArc = new ArrayList<>();

	public Graphe() {
		// TODO Auto-generated constructor stub
	}

	public Graphe(List<List<String>> data) {
		// List of parameters without separate from data file
		List<String> paramList_r = new ArrayList<>();
		// List of parameters separated
		List<String> paramList_w = new ArrayList<>();
		
		// Read a list of parameters from the 1st line of data list
		paramList_r = data.get(0);
		String[] param_s = paramList_r.get(0).split(",");
		for(int i = 0 ; i < param_s.length; i++){
			paramList_w.add(param_s[i]);
		}
		param = new Param_Utilisateur(paramList_w);

		// Read a list of nodes from the 2nd line of data list
		List<String> node = data.get(1);
		String[] node_r = node.get(0).split(",");
		String[] node_h = node.get(1).split(",");
		try{
			if(node_r.length == node_h.length){
				for(int i = 0 ; i < node_h.length; i++){
					// Randomly generate the cout between 40-100
					Random random = new Random();
			        int prix = random.nextInt(61)+40;
					listNoeud.add(new Noeud(i, Integer.parseInt(node_r[i]), Integer.parseInt(node_h[i]), prix));
				}
			}else{
				listNoeud.clear();
				System.out.println("Lire des noeuds erreur : le nombre de noeuds erreur !");
			}
		} catch(NumberFormatException e){
			System.out.println("Lire des noeuds erreur : il existe invalide symbole !");
			listNoeud.clear();
		}

		// Read a list edges from the 3rd line of data list
		List<String> arc = data.get(2);
		int arc_length = 0;
		try{
			for(int i = 0; i < arc.size(); i++){
				String[] arc_i = arc.get(i).split(",");
				arc_length = arc_i.length;
				if(arc_length == node_h.length){
					for(int j = 0; j < arc_length; j++){
						// Randomly generate the insecurite between 0-5
						Random random = new Random();
				        int insecurite = random.nextInt(6);
						listArc.add(new Arc(i*arc_length+j, i, j, Double.parseDouble(arc_i[j]), insecurite));
					}
				} else{
					listArc.clear();
					System.out.println("Lire des arcs erreur : le nombre de arcs erreur !");
					break;
				}
			}
		} catch(NumberFormatException e){
			System.out.println("Lire des arcs erreur : il existe invalide symbole !");
			listArc.clear();
		}

	}

	/**
	 * Get a node by the node'Id
	 * 
	 * @param id This node'Id
	 * @return This node
	 */
	public Noeud getNoeudById(int id){
		return listNoeud.get(id);
	}

	/**
	 * Get a edge by the edge'Id
	 * 
	 * @param id This edge'Id
	 * @return This edge
	 */
	public Arc getArcById(int id){
		return listArc.get(id);
	}
	
	/**
	 * Get the list of all the edges
	 * 
	 * @return A list of all the edges
	 */
	public List<Arc> getArcList(){
		return listArc;
	}
	
	/**
	 * Get the list size of all the edges
	 * 
	 * @return The size of all the edges
	 */
	public int getArcListSize(){
		return listArc.size();
	}
	
	/**
	 * Get the total number of nodes
	 * 
	 * @return The total number of nodes
	 */
	public int getNbNoeud(){
		return listNoeud.size();
	}

	public int getNbjour(){
		return param.getNbjour();
	}
	
	public int getHeure_depart(){
		return param.getHeure_depart();
	}
	
	public int getHeure_min_resto_midi() {
		return param.getHeure_min_resto_midi();
	}
	
	public int getHeure_max_resto_midi() {
		return param.getHeure_max_resto_midi();
	}
	
	public int getHeure_resto_midi() {
		return param.getHeure_resto_midi();
	}

	public int getHeure_min_resto_soir() {
		return param.getHeure_min_resto_soir();
	}

	public int getHeure_max_resto_soir() {
		return param.getHeure_max_resto_soir();
	}

	public int getHeure_resto_soir() {
		return param.getHeure_resto_soir();
	}

	public int getHeure_max_hotel() {
		return param.getHeure_max_hotel();
	}

	/**
	 * Print all the information of the graph
	 */
	public void print() {
		param.printParam_Utilisateur();

		for(Noeud noeud: listNoeud){
			noeud.printNoeudAll();;
		}
		System.out.println("\t");
		for(Arc arc: listArc){
			arc.printArcAll();
		}
		System.out.println("\t");
	}
}

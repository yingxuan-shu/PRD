package shu.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import shu.model.Graphe;

/**
 * Choose better solutions using less price, more distance and less insecurity
 * 
 * @author shuyingxuan
 *
 */
public class ChoisirSolution implements ChoisirSolutionInterface{
	
//	Create a graph with nodes and edges
	Graphe graphe = new Graphe();
	
	
	/**
	 *  Constructs a new Print with graph 
	 * 
	 * @param graphe Create a graph with nodes and edges
	 */
	public ChoisirSolution(Graphe graphe) {
		super();
		this.graphe = graphe;
	}

	/**
	 * Choose better solutions using less price, more distance and less insecurity
	 * 
	 * @param listResultat All feasible node paths for whole travel
	 */
	public void choisirSolution(List<List<Integer>> listResultat){
		if(!listResultat.isEmpty()){
			List<Integer> listPrix = new ArrayList<>(); 
			List<Integer> listInSecurite = new ArrayList<>(); 
			List<Double> listDistance = new ArrayList<>(); 

			for (int i = 0; i < listResultat.size(); i++) {
				int prix = 0;
				int inSecurite = 0;
				double distance = 0;

				for (int j = 0; j < listResultat.get(i).size()-1; j++) {
					int noeudId = listResultat.get(i).get(j);
					int noeudIdNext = listResultat.get(i).get(j+1);
					int arcId = noeudId * graphe.getNbNoeud() + noeudIdNext;

					prix =+ graphe.getNoeudById(listResultat.get(i).get(j+1)).getPrix();
					inSecurite =+ graphe.getArcById(arcId).getInsecurite();
					distance =+ graphe.getArcById(arcId).getDistance();
				}
				listPrix.add(prix);
				listInSecurite.add(inSecurite);
				listDistance.add(distance);
			}

			// better solutions using less price, more distance and less insecurity
			// map<BetterSolution ID, worseSolution ID List>
			Map<Integer, List<Integer>> mapBetterSolution = new HashMap<Integer, List<Integer>>();
			// If Solution m is better than Solution k, add m's id in Better Solution Set
			Set<Integer> setBetterSolutionId = new HashSet<>(); 
			mapBetterSolution.put(0, null);
			setBetterSolutionId.addAll(mapBetterSolution.keySet());
			for (int k = 0; k < listInSecurite.size(); k++) {
				
				for(Integer BetterSolutionM : setBetterSolutionId){
					// Solution k is better than Solution m
					if(listPrix.get(k) <= listPrix.get(BetterSolutionM) 
							&& listInSecurite.get(k) <= listInSecurite.get(BetterSolutionM) 
							&& listDistance.get(k) >= listDistance.get(BetterSolutionM)) {
						// If it doesn't have a solution better than Solution m, put Solution k in map directly
						if(!mapBetterSolution.values().contains(BetterSolutionM)){
							List<Integer> listWorseSolutionTemp = new ArrayList<>(); 
							listWorseSolutionTemp.add(k);
							mapBetterSolution.put(k, listWorseSolutionTemp);
						} else {
							// define a map temp
							Map<Integer, List<Integer>> mapBetterSolutionTemp = new HashMap<Integer, List<Integer>>();
							mapBetterSolutionTemp.putAll(mapBetterSolution);
							for (Map.Entry<Integer, List<Integer>> entry: mapBetterSolution.entrySet()) { 
								// If it has a Solution entry better than Solution m, 
								if(entry.getValue().equals(BetterSolutionM)){
									List<Integer> listWorseSolution = new ArrayList<>();
									// Compare Solution entry(m) and Solution k
									if(listPrix.get(k) <= listPrix.get(entry.getKey()) 
											&& listInSecurite.get(k) <= listInSecurite.get(entry.getKey()) 
											&& listDistance.get(k) >= listDistance.get(entry.getKey())) {
										// If Solution k is better than Solution entry(m)
										listWorseSolution.addAll(entry.getValue());
										listWorseSolution.add(entry.getKey());
										mapBetterSolutionTemp.put(k, listWorseSolution);
										mapBetterSolutionTemp.remove(entry.getKey());
									} else {
										// Solution k, Solution entry(m) can't compare, 
										// Can't get better solution between Solution k, Solution entry(m)
										listWorseSolution.add(BetterSolutionM);
										mapBetterSolutionTemp.put(k, listWorseSolution);
									}
								}
							}
							mapBetterSolution.clear();
							mapBetterSolution.putAll(mapBetterSolutionTemp);
						}
					} else if(listPrix.get(k) > listPrix.get(BetterSolutionM) 
							&& listInSecurite.get(k) > listInSecurite.get(BetterSolutionM) 
							&& listDistance.get(k) < listDistance.get(BetterSolutionM)) {
						// Solution m is better than Solution k
						List<Integer> listWorseSolution = new ArrayList<>();
						listWorseSolution.addAll(mapBetterSolution.get(BetterSolutionM));
						listWorseSolution.add(BetterSolutionM);
						mapBetterSolution.put(k, listWorseSolution);
					}
				}
			}

			List<List<Integer>> meilleureSolution = new ArrayList<List<Integer>>();
			if(!mapBetterSolution.isEmpty()) {
				for(Map.Entry<Integer, List<Integer>> entry: mapBetterSolution.entrySet()) { 
					meilleureSolution.add(listResultat.get(entry.getKey()));
				}
				System.out.println("Les meilleures solutions: " + meilleureSolution.size());
//				System.out.println("Les meilleures solutions: " + meilleureSolution);
				List<Integer> blankline = new ArrayList<Integer>();
				// Write in result file, [null, listResultat.size(), meilleureSolution.size()]
				// Between listResultat and meilleureSolution
				blankline.add(null);
				blankline.add(listResultat.size());
				blankline.add(meilleureSolution.size());
				listResultat.add(blankline);
				listResultat.addAll(meilleureSolution);
			} else {
				System.out.println("La meilleure solution n'existe pas !");
			}
		}
	}

}

package shu.solution;

import java.util.List;

public interface ChoisirSolutionInterface {

	/**
	 * Choose better solutions using less price, more distance and less insecurity
	 * 
	 * @param listResultat All feasible node paths for whole travel
	 */
	public void choisirSolution(List<List<Integer>> listResultat);
}

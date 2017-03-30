package shu.model;

/**
 * A single edge between two nodes in the graph
 * @author shuyingxuan
 *
 */
public class Arc {
	
	private int idArc;
	private int noeud_start;
	private int noeud_end;
	private double distance;
	private int insecurite;
	
	public Arc() {
		super();
	}

	/**
	 * Constructs a new edge
	 * 
	 * @param idArc This edge's id
	 * @param noeud_start The start node of this edge
	 * @param noeud_end The end node of this edge
	 * @param distance The distance between the start node and the end node
	 * @param insecurite The degree of insecurity (Randomly generated between 0-5)
	 */
	public Arc(int idArc, int noeud_start, int noeud_end, double distance, int insecurite) {
		super();
		this.idArc = idArc;
		this.noeud_start = noeud_start;
		this.noeud_end = noeud_end;
		this.distance = distance;
		this.insecurite = insecurite;
	}

	public int getIdArc() {
		return idArc;
	}

	public void setIdArc(int idArc) {
		this.idArc = idArc;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getNoeud_start() {
		return noeud_start;
	}

	public void setNoeud_start(int noeud_start) {
		this.noeud_start = noeud_start;
	}

	public int getNoeud_end() {
		return noeud_end;
	}

	public void setNoeud_end(int noeud_end) {
		this.noeud_end = noeud_end;
	}

	public int getInsecurite() {
		return insecurite;
	}

	public void setInsecurite(int insecurite) {
		this.insecurite = insecurite;
	}

	/**
	 * Print all the information of the edge
	 */
	public void printArcAll() {
		System.out.println("Arc [idArc=" + idArc + ", noeud_start=" + noeud_start + ", noeud_end=" 
				+ noeud_end + ", distance=" + distance + ", insecurite=" + insecurite + "]");
	}
	
}

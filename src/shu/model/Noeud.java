package shu.model;

/**
 * A single node in the graph
 * @author shuyingxuan
 *
 */
public class Noeud {
	
	private int id;
	private int isHotel;
	private int isResto;
	private int prix;
	
	public Noeud() {
		super();
	}
	
	/**
	 * Constructs a new Node
	 * 
	 * @param id This node's id
	 * @param isResto If this node is restaurant, this param will be 1
	 * @param isHotel If this node is hotel, this param will be 1
	 */
	public Noeud(int id, int isHotel, int isResto) {
		super();
		this.id = id;
		this.isHotel = isHotel;
		this.isResto = isResto;
	}

	/**
	 * Constructs a new Node
	 * 
	 * @param id This node's id
	 * @param isResto If this node is restaurant, this param will be 1
	 * @param isHotel If this node is hotel, this param will be 1
	 * @param prix The cost of this node (Randomly generated between 40-100)
	 */
	public Noeud(int id, int isResto, int isHotel, int prix) {
		super();
		this.id = id;
		this.isHotel = isHotel;
		this.isResto = isResto;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsHotel() {
		return isHotel;
	}

	public void setIsHotel(int isHotel) {
		this.isHotel = isHotel;
	}

	public int getIsResto() {
		return isResto;
	}

	public void setIsResto(int isResto) {
		this.isResto = isResto;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	/**
	 * Print all the information of the node
	 */
	public void printNoeudAll() {
		System.out.println("Noeud [id=" + id + ", isHotel=" + isHotel + ", isResto=" + isResto 
				+ ", prix=" + prix + "]");
	}
	
}

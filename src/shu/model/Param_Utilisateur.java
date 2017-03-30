package shu.model;

import java.util.List;

/**
 * Some parameters of a rider, restaurants and hotels
 * @author shuyingxuan
 *
 */
public class Param_Utilisateur {
	private int nbjour;
	private int heure_depart;
	
	private int heure_min_resto_midi;
	private int heure_max_resto_midi;
	private int heure_resto_midi;
	
	private int heure_min_resto_soir;
	private int heure_max_resto_soir;
	private int heure_resto_soir;
	
	private int heure_max_hotel;
//	private int distance_max;

	/**
	 * Constructs these parameters in a list
	 * 
	 * @param list A list of parameters set in the 1st line of data list
	 */
	public Param_Utilisateur(List<String> list) {
		this.nbjour = Integer.parseInt(list.get(0));
		this.heure_depart = Integer.parseInt(list.get(1));
		this.heure_min_resto_midi = Integer.parseInt(list.get(2));
		this.heure_max_resto_midi = Integer.parseInt(list.get(3));
		this.heure_resto_midi = Integer.parseInt(list.get(4));
		this.heure_min_resto_soir = Integer.parseInt(list.get(5));
		this.heure_max_resto_soir = Integer.parseInt(list.get(6));
		this.heure_resto_soir = Integer.parseInt(list.get(7));
		this.heure_max_hotel = Integer.parseInt(list.get(8));
	}
	
	/**
	 * Constructs these parameters
	 * 
	 * @param nbjour The number of travel days
	 * @param heure_depart The hours of the rider's begin time every morning
	 * @param heure_min_resto_midi The earliest business hours of restaurants at noon every day
	 * @param heure_max_resto_midi The latest business hours of restaurants at noon every day
	 * @param heure_resto_midi The hours of the rider's lunch time at noon every day
	 * @param heure_min_resto_soir The earliest business hours of restaurants every night
	 * @param heure_max_resto_soir The latest business hours of restaurants every night
	 * @param heure_resto_soir The hours of the rider's diner time every night
	 * @param heure_max_hotel The latest business hours of the hotel every night
	 */
	public Param_Utilisateur(int nbjour, int heure_depart, int heure_min_resto_midi, int heure_max_resto_midi,
			int heure_resto_midi, int heure_min_resto_soir, int heure_max_resto_soir, int heure_resto_soir,
			int heure_max_hotel) {
		super();
		this.nbjour = nbjour;
		this.heure_depart = heure_depart;
		this.heure_min_resto_midi = heure_min_resto_midi;
		this.heure_max_resto_midi = heure_max_resto_midi;
		this.heure_resto_midi = heure_resto_midi;
		this.heure_min_resto_soir = heure_min_resto_soir;
		this.heure_max_resto_soir = heure_max_resto_soir;
		this.heure_resto_soir = heure_resto_soir;
		this.heure_max_hotel = heure_max_hotel;
	}

	public int getNbjour() {
		return nbjour;
	}

	public void setNbjour(int nbjour) {
		this.nbjour = nbjour;
	}

	public int getHeure_depart() {
		return heure_depart;
	}

	public void setHeure_depart(int heure_depart) {
		this.heure_depart = heure_depart;
	}

	public int getHeure_min_resto_midi() {
		return heure_min_resto_midi;
	}

	public void setHeure_min_resto_midi(int heure_min_resto_midi) {
		this.heure_min_resto_midi = heure_min_resto_midi;
	}

	public int getHeure_max_resto_midi() {
		return heure_max_resto_midi;
	}

	public void setHeure_max_resto_midi(int heure_max_resto_midi) {
		this.heure_max_resto_midi = heure_max_resto_midi;
	}

	public int getHeure_resto_midi() {
		return heure_resto_midi;
	}

	public void setHeure_resto_midi(int heure_resto_midi) {
		this.heure_resto_midi = heure_resto_midi;
	}

	public int getHeure_min_resto_soir() {
		return heure_min_resto_soir;
	}

	public void setHeure_min_resto_soir(int heure_min_resto_soir) {
		this.heure_min_resto_soir = heure_min_resto_soir;
	}

	public int getHeure_max_resto_soir() {
		return heure_max_resto_soir;
	}

	public void setHeure_max_resto_soir(int heure_max_resto_soir) {
		this.heure_max_resto_soir = heure_max_resto_soir;
	}

	public int getHeure_resto_soir() {
		return heure_resto_soir;
	}

	public void setHeure_resto_soir(int heure_resto_soir) {
		this.heure_resto_soir = heure_resto_soir;
	}

	public int getHeure_max_hotel() {
		return heure_max_hotel;
	}

	public void setHeure_max_hotel(int heure_max_hotel) {
		this.heure_max_hotel = heure_max_hotel;
	}

	/**
	 * Print all the information of these parameters
	 */
	public void printParam_Utilisateur() {
		System.out.println("Param_Utilisateur : \n nombre_de_jour=" + nbjour 
				+ "\n heure_depart=" + heure_depart 
				+ "\n heure_min_resto_midi=" + heure_min_resto_midi 
				+ "\n heure_max_resto_midi=" + heure_max_resto_midi 
				+ "\n heure_resto_midi=" + heure_resto_midi
				+ "\n heure_min_resto_soir=" + heure_min_resto_soir 
				+ "\n heure_max_resto_soir=" + heure_max_resto_soir
				+ "\n heure_resto_soir=" + heure_resto_soir
				+ "\n heure_max_hotel=" + heure_max_hotel
//				+ ", distance_max=" + distance_max
				);
		System.out.println("\t");
	}
	
}

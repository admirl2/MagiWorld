package com.magiworld.classes;

/**
 * cette classe représente les joueurs
 * 
 * @author Adelain EUGENE
 * @version 1.0
 *
 */
public class Joueur extends Personnage {
	/**
	 * Le attributs du joueur en question
	 */
	private int numero;
	private String nom;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}

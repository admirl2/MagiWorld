package com.magiworld.interfaces;

/**
 * 
 * @author Adelain EUGENE
 * @version 1.0
 *
 */
public interface IService {
	/**
	 * Création du personnage
	 */
	void creationPersonnage();

	/**
	 * Distinction des personnages
	 * 
	 * @param numeroPersonnage
	 *            numero du Joueur
	 * @return personnage
	 */
	String distinguerPersonnage(int numeroPersonnage);

	/**
	 * Le deroulement des attaques par les différents joueur
	 */
	void leJeu();
}

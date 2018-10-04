package com.magiworld.interfaces;

import java.util.HashMap;

/**
 * Les differentes attaques
 * 
 * @author Adelain EUGENE
 * @version 1.0
 *
 */
public interface Attaque {
	/**
	 * Attaque spéciale
	 * 
	 * @param joueurAdverse
	 *            , joueur qui subit l'attaque
	 * @param tab
	 *            tableau qui contient les joueurs
	 * @param joueur
	 *            , joueur qui attaque
	 * @return vitalite
	 */
	int attaqueSpeciale(String joueurAdverse, HashMap tab, String joueur);

	/**
	 * Attaque Basique
	 * 
	 * @param joueurAdverse
	 *            , joueur qui subit l'attaque
	 * @param tab
	 *            tableau qui contient les joueurs
	 * @param joueur
	 *            , joueur qui attaque
	 * @return vitalite
	 */
	int attaqueBasique(String joueurAdverse, HashMap tab, String joueur);
}

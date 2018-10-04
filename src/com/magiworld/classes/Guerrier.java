package com.magiworld.classes;

import java.util.HashMap;

import com.magiworld.interfaces.Attaque;

/**
 * 
 * @author Adelain EUGENE
 * @version 1.0
 *
 */
public class Guerrier implements Attaque {
	/**
	 * Attaque spéciale du personnage Guerrier
	 * 
	 * @param joueurAdverse
	 *            Joueur qui subit l'attaque
	 * @param tab
	 *            tabeau qui contient les joueurs
	 * @param joueur
	 *            Joueur qui fait l'attaque
	 * @return la vitalité du joueur qui subit l'attaque
	 */
	@Override
	public int attaqueSpeciale(String joueurAdverse, HashMap tab, String joueur) {
		// TODO Auto-generated method stub
		int vitalite = 0;
		int vitalitePerdue = 0;
		Joueur joueurAdverse1 = (Joueur) tab.get(joueurAdverse);
		Joueur joueur1 = (Joueur) tab.get(joueur);
		vitalite = joueurAdverse1.getVie() - (2 * joueur1.getForce());
		joueurAdverse1.setVie(vitalite);
		vitalitePerdue = joueur1.getForce() / 2;
		joueur1.setVie(joueur1.getVie() - vitalitePerdue);
		tab.put(joueurAdverse, joueurAdverse1);
		tab.put(joueur, joueur1);
		if (joueurAdverse1.getVie() > 0 && joueur1.getVie() > 0) {
			System.out.println("Joueur " + joueur1.getNumero()
					+ " utilise Coup de Rage et inflige "
					+ (2 * joueur1.getForce()) + " domages.");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " perd " + (2 * joueur1.getForce()) + " points de vie");

			System.out.println("Joueur " + joueur1.getNumero() + " perd "
					+ vitalitePerdue + " points de vie");
		} else {
			System.out.println("Joueur " + joueur1.getNumero()
					+ " utilise Coup de Rage et inflige "
					+ (2 * joueur1.getForce()) + " domages.");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " perd " + (2 * joueur1.getForce()) + " points de vie");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " est mort");

			System.out.println("Joueur " + joueur1.getNumero() + " perd "
					+ vitalitePerdue + " points de vie");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " a perdu!");
		}
		return vitalite;

	}

	/**
	 * Attaque basique du personnage Guerrier
	 * 
	 * @param joueurAdverse
	 *            , tab, joueur
	 * @return la vitalité du joueur qui subit l'attaque
	 */
	@Override
	public int attaqueBasique(String joueurAdverse, HashMap tab, String joueur) {
		// TODO Auto-generated method stub
		Joueur joueurAdverse1 = (Joueur) tab.get(joueurAdverse);
		Joueur joueur1 = (Joueur) tab.get(joueur);
		int vitalite = 0;
		vitalite = (joueurAdverse1.getVie() - joueur1.getForce());
		joueurAdverse1.setVie(vitalite);
		tab.put(joueurAdverse, joueurAdverse1);
		if (joueurAdverse1.getVie() > 0) {
			System.out.println("Joueur " + joueur1.getNumero()
					+ " utilise Coup d'Épée et inflige " + joueur1.getForce()
					+ " domages.");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " perd " + joueur1.getForce() + " points de vie");
		} else {
			System.out.println("Joueur " + joueur1.getNumero()
					+ " utilise Coup d'Épée et inflige " + joueur1.getForce()
					+ " domages.");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " perd " + joueur1.getForce() + " points de vie");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " est mort");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " a perdu!");
		}
		return vitalite;

	}

}

package com.magiworld.classes;

import java.util.HashMap;

import com.magiworld.interfaces.Attaque;

public class Mage implements Attaque {

	public int attaqueSpeciale(HashMap tab, String joueur) {
		// TODO Auto-generated method stub
		int vitalite = 0;
		Joueur joueur1 = (Joueur) tab.get(joueur);
		vitalite = joueur1.getVie() + (2 * joueur1.getIntelligence());
		joueur1.setVie(vitalite);
		tab.put(joueur, joueur1);
		System.out.println("Joueur " + joueur1.getNumero()
				+ " utilise Soin et gagne " + (2 * joueur1.getIntelligence())
				+ " en vitalité.");
		return vitalite;
	}

	@Override
	public int attaqueBasique(String joueurAdverse, HashMap tab, String joueur) {
		// TODO Auto-generated method stub
		Joueur joueurAdverse1 = (Joueur) tab.get(joueurAdverse);
		Joueur joueur1 = (Joueur) tab.get(joueur);
		int vitalite = 0;
		vitalite = (joueurAdverse1.getVie() - joueur1.getIntelligence());
		joueurAdverse1.setVie(vitalite);
		tab.put(joueurAdverse, joueurAdverse1);
		if (joueurAdverse1.getVie() > 0) {
			System.out.println("Joueur " + joueur1.getNumero()
					+ " utilise Boule de Feu et inflige "
					+ joueur1.getIntelligence() + " domages.");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " perd " + joueur1.getIntelligence() + " points de vie");
		} else {
			System.out.println("Joueur " + joueur1.getNumero()
					+ " utilise Boule de Feu et inflige "
					+ joueur1.getIntelligence() + " domages.");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " perd " + joueur1.getIntelligence() + " points de vie");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " est mort");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " a perdu!");
		}
		return vitalite;
	}

	@Override
	public int attaqueSpeciale(String joueurAdverse, HashMap tab, String joueur) {
		// TODO Auto-generated method stub
		return 0;
	}

}

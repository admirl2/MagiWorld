package com.magiworld.classes;

import java.util.HashMap;

import com.magiworld.interfaces.Attaque;

public class Rodeur implements Attaque {

	public int attaqueSpeciale(HashMap tab, String joueur) {
		// TODO Auto-generated method stub
		int vitalite = 0;
		Joueur joueur1 = (Joueur) tab.get(joueur);
		vitalite = joueur1.getVie() + (joueur1.getAgilite() / 2);
		joueur1.setVie(vitalite);
		tab.put(joueur, joueur1);
		System.out
				.println("Joueur "
						+ joueur1.getNumero()
						+ " utilise Concentration et gagne "
						+ (joueur1.getVie() + (joueur1.getAgilite() / 2) + " en vitalité."));
		return vitalite;

	}

	@Override
	public int attaqueBasique(String joueurAdverse, HashMap tab, String joueur) {
		// TODO Auto-generated method stub
		int vitalite = 0;
		Joueur joueurAdverse1 = (Joueur) tab.get(joueurAdverse);
		Joueur joueur1 = (Joueur) tab.get(joueur);

		vitalite = (joueurAdverse1.getVie() - joueurAdverse1.getAgilite());
		joueurAdverse1.setVie(vitalite);
		tab.put(joueurAdverse, joueurAdverse1);
		if (joueurAdverse1.getVie() > 0) {
			System.out.println("Joueur " + joueur1.getNumero()
					+ " utilise Tir à l'Arc et inflige " + joueur1.getAgilite()
					+ " domages.");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " perd " + joueur1.getAgilite() + " points de vie");
		} else {
			System.out.println("Joueur " + joueur1.getNumero()
					+ " utilise Tir à l'Arc et inflige " + joueur1.getAgilite()
					+ " domages.");

			System.out.println("Joueur " + joueurAdverse1.getNumero()
					+ " perd " + joueur1.getAgilite() + " points de vie");

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

package com.magiworld.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.magiworld.classes.Guerrier;
import com.magiworld.classes.Joueur;
import com.magiworld.classes.Mage;
import com.magiworld.classes.Personnage;
import com.magiworld.classes.Rodeur;
import com.magiworld.interfaces.IService;

public class Service implements IService {
	public static HashMap<String, Joueur> joueurs = new HashMap();

	/**
	 * La fonction de creation de personnages
	 * 
	 * @see creationPersonnage()
	 */
	@Override
	public void creationPersonnage() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String nomJoueur = "Woarg";
		for (int i = 1; i < 3; i++) {
			Joueur joueur = new Joueur();
			joueur.setAgilite(0);
			joueur.setIntelligence(0);
			joueur.setNumero(i);
			joueur.setNom(nomJoueur);
			int niveau = 0;
			int classe = 0;
			System.out.println("Création du personnage du joueur " + i);

			do {
				System.out
						.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2: Rodeur, 3 : Mage)");
				classe = scanner.nextInt();
				joueur.setClasse(distinguerPersonnage(classe));

			} while (classe < 0 || classe > 4);

			do {
				System.out.println("Niveau du personnage");
				niveau = scanner.nextInt();
				joueur.setNiveau(niveau);
				joueur.setVie(niveau * 5);

			} while (joueur.getNiveau() < 1 || joueur.getNiveau() > 100);

			do {
				System.out.println("Force du personnage");
				joueur.setForce(scanner.nextInt());
			} while (joueur.getForce() < 0 || joueur.getForce() > 100);

			do {
				System.out.println("Agilité du personnage");
				joueur.setAgilite(scanner.nextInt());
			} while (joueur.getAgilite() < 0
					|| !totalForceAgiliteIntelligence(joueur));

			do {
				System.out.println("Intelligence du personnage");
				joueur.setIntelligence(scanner.nextInt());
			} while (joueur.getIntelligence() < 0
					|| !totalForceAgiliteIntelligence(joueur));
			System.out.println(nomJoueur + " je suis le " + joueur.getClasse()
					+ " joueur " + i + " niveau " + joueur.getNiveau()
					+ " je possède " + joueur.getVie() + " de vitalité, "
					+ joueur.getForce() + " de force, " + joueur.getAgilite()
					+ " d'agilité et " + joueur.getIntelligence()
					+ " d'intelligence!");

			joueurs.put(nomJoueur, joueur);
			nomJoueur = "Abracadabra";
		}
	}

	@Override
	public String distinguerPersonnage(int numeroPersonnage) {
		// TODO Auto-generated method stub
		String personnage = null;
		if (numeroPersonnage > 0 || numeroPersonnage < 4) {
			if (numeroPersonnage == 1) {
				personnage = "Guerrier";
			}
			if (numeroPersonnage == 2) {
				personnage = "Rodeur";
			}
			if (numeroPersonnage == 3) {
				personnage = "Mage";
			}
		}
		return personnage;
	}

	private boolean totalForceAgiliteIntelligence(Personnage personnage) {
		boolean validation = false;
		if (personnage.getNiveau() >= (personnage.getForce()
				+ personnage.getAgilite() + personnage.getIntelligence())) {
			validation = true;
		}
		return validation;

	}

	public void leJeu() {
		Scanner scanner = new Scanner(System.in);
		List<Joueur> liste = new ArrayList();
		int numeroClasse = 0;
		for (Map.Entry entree : joueurs.entrySet()) {
			Joueur joueur = (Joueur) entree.getValue();
			liste.add(joueur);
		}

		int vitalite = -1;
		int vitalite1 = 1;

		while (vitalite == -1 || vitalite1 > 0) {
			int premierJoueur = 1;
			int deuxiemeJoueur = 0;
			while (premierJoueur >= 0 && deuxiemeJoueur <= 1) {
				vitalite1 = liste.get(premierJoueur).getVie();
				if (vitalite1 == 0 || vitalite1 < 0)
					break;
				System.out
						.println("Joueur "
								+ liste.get(premierJoueur).getNumero()
								+ " ("
								+ liste.get(premierJoueur).getVie()
								+ ")"
								+ " Veuillez choisir votre action(1: Attaque Basique, 2: Attaque Spéciale)");
				numeroClasse = scanner.nextInt();
				if (liste.get(premierJoueur).getClasse().equals("Guerrier")) {
					Guerrier guerrier = new Guerrier();
					if (numeroClasse == 1) {
						guerrier.attaqueBasique(liste.get(deuxiemeJoueur)
								.getNom(), joueurs, liste.get(premierJoueur)
								.getNom());
					}
					if (numeroClasse == 2) {
						guerrier.attaqueSpeciale(liste.get(deuxiemeJoueur)
								.getNom(), joueurs, liste.get(premierJoueur)
								.getNom());
					}
				}
				if (liste.get(premierJoueur).getClasse().equals("Rodeur")) {
					if (numeroClasse == 1) {
						Rodeur rodeur = new Rodeur();
						vitalite = rodeur.attaqueBasique(
								liste.get(deuxiemeJoueur).getNom(), joueurs,
								liste.get(premierJoueur).getNom());
					}
					if (numeroClasse == 2) {
						Rodeur rodeur = new Rodeur();
						vitalite = rodeur.attaqueSpeciale(joueurs,
								liste.get(premierJoueur).getNom());
					}

				}
				if (liste.get(premierJoueur).getClasse().equals("Mage")) {
					Mage mage = new Mage();
					if (numeroClasse == 1) {
						vitalite = mage.attaqueBasique(liste
								.get(deuxiemeJoueur).getNom(), joueurs, liste
								.get(premierJoueur).getNom());
					}
					if (numeroClasse == 2) {
						vitalite = mage.attaqueSpeciale(joueurs,
								liste.get(premierJoueur).getNom());
					}
				}

				deuxiemeJoueur++;
				premierJoueur--;
			}
		}

	}

	// public void lesAttaquesGuerrier(int premierJoueur, int deuxiemeJoueur,
	// int numeroClasse) {
	// // List<Joueur> liste = new ArrayList();
	// for (Map.Entry entree : joueurs.entrySet()) {
	// Joueur joueur = (Joueur) entree.getValue();
	// liste.add(joueur);
	// }
	//
	// }
	//
	// public void lesAttaquesMage(int premierJoueur, int deuxiemeJoueur,
	// int numeroClasse) {
	// for (Map.Entry entree : joueurs.entrySet()) {
	// Joueur joueur = (Joueur) entree.getValue();
	// liste.add(joueur);
	// }
	//
	// }
}

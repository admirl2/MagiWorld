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
	public List code = new ArrayList();

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
		int vitalite = 0;
		do {
			for (Map.Entry joueur : joueurs.entrySet()) {
				Joueur joueurss = (Joueur) joueur.getValue();
				System.out
						.println("Joueur "
								+ joueurss.getNumero()
								+ " ("
								+ joueurss.getVie()
								+ ")"
								+ " Veuillez choisir votre action(1: Attaque Basique, 2: Attaque Spéciale)");
				int action = scanner.nextInt();
				if (action == 1) {
					if (joueurss.getClasse().equals("Guerrier")) {
						Guerrier guerrier = new Guerrier();
						vitalite = guerrier.attaqueBasique("Abracadabra",
								joueurs, "Woarg");
						System.out.println("Valeur action : Guerrier");
						System.out.println("Vitalite: " + vitalite);
					}
					if (joueurss.getClasse().equals("Rodeur")) {
						Rodeur rodeur = new Rodeur();
						vitalite = rodeur.attaqueBasique("Abracadabra",
								joueurs, "Woarg");
						System.out.println("Valeur action : Rodeur");
						System.out.println("Vitalite: " + vitalite);
					}
					if (joueurss.getClasse().equals("Mage")) {
						Mage mage = new Mage();
						vitalite = mage.attaqueBasique("Abracadabra", joueurs,
								"Woarg");
						System.out.println("Valeur action : Mage");
						System.out.println("Vitalite: " + vitalite);
					}

				}
			}
		} while (vitalite > 0 || vitalite != 0);

	}

	// private int nouvelleVitalite(String cle) {
	// int vitalite = 0;
	// Personnage personnage = joueur.get(cle);
	// if (personnage != null) {
	// // personnage.setVie(vie);
	// }
	// return vitalite;
	// }

	public void listing() {
		Scanner scanner = new Scanner(System.in);
		List<Joueur> liste = new ArrayList();
		int numeroClasse = 0;
		for (Map.Entry entree : joueurs.entrySet()) {
			Joueur joueur = (Joueur) entree.getValue();
			// System.out.println("Numero" + joueur.getNumero());
			// a = scanner.nextInt();
			liste.add(joueur);

		}

		int vitalite = -1;
		// boolean vitaliteNull = false;

		while (vitalite == -1 || vitalite > 0) {
			System.out.println("Vitalite premier while " + vitalite);
			int i = 1;
			int y = 0;
			while (i >= 0 && y <= 1) {

				System.out
						.println("Joueur "
								+ liste.get(i).getNumero()
								+ " ("
								+ liste.get(i).getVie()
								+ ")"
								+ " Veuillez choisir votre action(1: Attaque Basique, 2: Attaque Spéciale)");
				// System.out.println("Classe:   " + liste.get(i).getClasse());
				numeroClasse = scanner.nextInt();
				if (liste.get(i).getClasse().equals("Guerrier")) {
					// System.out.println("Classe:   " +
					// liste.get(i).getClasse());
					Guerrier guerrier = new Guerrier();
					if (numeroClasse == 1) {
						vitalite = guerrier.attaqueBasique(liste.get(y)
								.getNom(), joueurs, liste.get(i).getNom());
					}
					if (numeroClasse == 2) {
						vitalite = guerrier.attaqueSpeciale(liste.get(y)
								.getNom(), joueurs, liste.get(i).getNom());
					}

				}
				if (liste.get(i).getClasse().equals("Rodeur")) {
					// System.out.println("Classe:   " +
					// liste.get(i).getClasse());
					if (numeroClasse == 1) {
						Rodeur rodeur = new Rodeur();
						vitalite = rodeur.attaqueBasique(liste.get(y).getNom(),
								joueurs, liste.get(i).getNom());
					}
					if (numeroClasse == 2) {
						Rodeur rodeur = new Rodeur();
						vitalite = rodeur.attaqueSpeciale(joueurs, liste.get(i)
								.getNom());
					}

				}
				if (liste.get(i).getClasse().equals("Mage")) {
					// System.out.println("Classe:   " +
					// liste.get(i).getClasse());
					Mage mage = new Mage();
					if (numeroClasse == 1) {
						vitalite = mage.attaqueBasique(liste.get(y).getNom(),
								joueurs, liste.get(i).getNom());
					}
					if (numeroClasse == 2) {
						mage = new Mage();
						vitalite = mage.attaqueSpeciale(joueurs, liste.get(i)
								.getNom());
					}
				}

				y++;
				i--;
				// System.out.println("Joueur"+);
			}
		}

	}
}

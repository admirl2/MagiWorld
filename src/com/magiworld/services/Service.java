package com.magiworld.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.magiworld.classes.Guerrier;
import com.magiworld.classes.Mage;
import com.magiworld.classes.Personnage;
import com.magiworld.classes.Rodeur;
import com.magiworld.interfaces.IService;

public class Service implements IService {
	public static HashMap<String, Personnage> joueur = new HashMap();
	public List code = new ArrayList();

	@Override
	public void creationPersonnage() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String nomJoueur = "Woarg";
		for (int i = 1; i < 3; i++) {
			Personnage personnage = new Personnage();
			personnage.setAgilite(0);
			personnage.setIntelligence(0);
			int niveau = 0;
			int classe = 0;
			System.out.println("Création du personnage du joueur " + i);

			do {
				System.out
						.println("Veuillez choisir la clsse de votre personnage (1 : Guerrier, 2: Rodeur, 3 : Mage)");
				classe = scanner.nextInt();
				personnage.setClasse(distinguerPersonnage(classe));

			} while (classe < 0 || classe > 4);

			do {
				System.out.println("Niveau du personnage");
				niveau = scanner.nextInt();
				personnage.setNiveau(niveau);
				personnage.setVie(niveau * 5);

			} while (personnage.getNiveau() < 1 || personnage.getNiveau() > 100);

			do {
				System.out.println("Force du personnage");
				personnage.setForce(scanner.nextInt());
			} while (personnage.getForce() < 0 || personnage.getForce() > 100);

			do {
				System.out.println("Agilité du personnage");
				personnage.setAgilite(scanner.nextInt());
			} while (personnage.getAgilite() < 0
					|| !totalForceAgiliteIntelligence(personnage));

			do {
				System.out.println("Intelligence du personnage");
				personnage.setIntelligence(scanner.nextInt());
			} while (personnage.getIntelligence() < 0
					|| !totalForceAgiliteIntelligence(personnage));
			System.out.println(nomJoueur + " je suis le "
					+ personnage.getClasse() + " joueur " + i + " niveau "
					+ personnage.getNiveau() + " je possède "
					+ personnage.getVie() + " de vitalité, "
					+ personnage.getForce() + " de force, "
					+ personnage.getAgilite() + " d'agilité et "
					+ personnage.getIntelligence() + " d'intelligence!");

			joueur.put(nomJoueur, personnage);
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
			for (int i = 0; i < joueur.size(); i++) {
				Personnage personnage = (Personnage) joueur.values();
				System.out
						.println("Joueur "
								+ (i + 1)
								+ " ("
								+ personnage.getVie()
								+ ")"
								+ " Veuillez choisir votre action(1: Attaque Basique, 2: Attaque Spéciale)");
				int action = scanner.nextInt();
				if (action == 1) {
					if (personnage.getClasse().equals("Guerrier")) {
						Guerrier guerrier = new Guerrier();
						vitalite = guerrier.attaqueBasique("Abracadabra",
								joueur, "Woarg");
						System.out.println("Valeur action : Guerrier");
						System.out.println("Vitalite: " + vitalite);
					}
					if (personnage.getClasse().equals("Rodeur")) {
						Rodeur rodeur = new Rodeur();
						vitalite = rodeur.attaqueBasique("Abracadabra", joueur,
								"Woarg");
						System.out.println("Valeur action : Rodeur");
						System.out.println("Vitalite: " + vitalite);
					}
					if (personnage.getClasse().equals("Mage")) {
						Mage mage = new Mage();
						vitalite = mage.attaqueBasique("Abracadabra", joueur,
								"Woarg");
						System.out.println("Valeur action : Mage");
						System.out.println("Vitalite: " + vitalite);
					}

				}
			}
		} while (vitalite > 0 || vitalite != 0);

	}

	private int nouvelleVitalite(String cle) {
		int vitalite = 0;
		Personnage personnage = joueur.get(cle);
		if (personnage != null) {
			// personnage.setVie(vie);
		}
		return vitalite;
	}

}

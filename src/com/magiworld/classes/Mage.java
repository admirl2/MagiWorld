package com.magiworld.classes;

import java.util.HashMap;

import com.magiworld.interfaces.Attaque;

public class Mage implements Attaque {

	@Override
	public void attaqueSpecial() {
		// TODO Auto-generated method stub

	}

	@Override
	public int attaqueBasique(String joueurAdverse, HashMap tab, String joueur) {
		// TODO Auto-generated method stub
		Personnage personnage1 = (Personnage) tab.get(joueurAdverse);
		Personnage personnage = (Personnage) tab.get(joueur);
		int vitalite = 0;
		vitalite = (personnage1.getVie() - personnage.getIntelligence());
		personnage1.setVie(vitalite);
		tab.put(joueurAdverse, personnage1);
		System.out.println("Vitalite :" + vitalite);
		return vitalite;
	}

}

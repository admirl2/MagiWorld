package com.magiworld.interfaces;

import java.util.HashMap;

public interface Attaque {
	void attaqueSpecial();

	int attaqueBasique(String joueur, HashMap tab, String cle);
}

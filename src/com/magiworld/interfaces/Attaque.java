package com.magiworld.interfaces;

import java.util.HashMap;

public interface Attaque {
	int attaqueSpeciale(String joueurAdverse, HashMap tab, String joueur);

	int attaqueBasique(String joueurAdverse, HashMap tab, String joueur);
}

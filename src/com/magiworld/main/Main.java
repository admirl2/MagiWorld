package com.magiworld.main;

import com.magiworld.services.Service;

/**
 * La porte d'entrée du programme
 * 
 * @author Adelain EUGENE
 * @version 1.0
 *
 */
public class Main {
	/**
	 * Porte d'entrée
	 * 
	 * @param arg
	 *            main
	 */
	public static void main(String[] arg) {
		Service service = new Service();
		service.creationPersonnage();
		service.leJeu();
	}

}

package cz.uhk.pro2.spyhunter.service;

import java.io.FileNotFoundException;

public class GameBoardLoadingException extends RuntimeException {
	// tahle vyjimka nastala z duvodu jine vyjimky Throwable predek vsech vyjimek
	// uvideme to pak v tom vypisu chyb, ze nastala tato vyjimka
	public GameBoardLoadingException(Throwable e) {
		super(e);
	}

}

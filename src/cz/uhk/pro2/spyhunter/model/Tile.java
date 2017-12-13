package cz.uhk.pro2.spyhunter.model;

import java.awt.Graphics;
/**
 * Interface
 * Dlazdice, ktera tvori cast herni plochy
 * Umi se vykreslit na platno
 * @author stand
 *
 */
public interface Tile {
	/**
	 * Vykresli dlazdici na platno
	 * @param g plano, na ktere se dlazdice vykreli
	 * @param x souradnice leveho horniho rohu
	 * @param y souradnice leveho horniho rohu
	 */
	public static final int SIZE=16;
	
	public void draw(Graphics g, int x, int y);
	/**
	 * Urcuje, zda je dana dlazdice po najeti na ni smrtici
	 * @return
	 */
	public Boolean isLethal();
	
}

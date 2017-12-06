package cz.uhk.pro2.spyhunter.model;

import java.awt.Graphics;

public class GameBoard {
	private Car car = new Car();
	private int elapsedY = 0;// kolik casu ubehlo, o kolik pixelu ubehlo
	private int pixelHeight = 300;// vyska okna
	

	private Tile[][] tiles;

	/**
	 * prvni souradnice radek druha sloupec plochu delam jako matici(rozdelim na
	 * cverce)
	 * 
	 * otoceny vzhuru nohama
	 * 
	 * private Tile[][] tiles = new Tile[][] { { new NonRoadTile(), new RoadTile()
	 * }, { new RoadTile(), new NonRoadTile() }, { new RoadTile(), new NonRoadTile()
	 * }
	 * 
	 * };
	 */

	/**
	 * 
	 * pomoci cyklu vykreslim dlazdice
	 * 
	 * @param g
	 */

	public GameBoard(Tile[][] tiles) {
		this.tiles = tiles;
		car.setScreenHeight(pixelHeight);
		car.setScreenWidth(tiles[0].length*Tile.SIZE);
	}

	// kreslime jen viditelnou plochu
	// %3 ... nejdriv byla vyska 3 bunky
	// kreslim to obracene 0:0 je dole v rohu
	public void draw(Graphics g) {
		// radky pod obrazovkou se nekresli, %10, 8/10= 0 , 9/10= 0
		int firstVisibleRow = elapsedY / Tile.SIZE;
		// (prevod z pixelu na dlazdice)
		int lastVisibleRow = (pixelHeight + elapsedY) / Tile.SIZE;
		for (int i = firstVisibleRow; i <= lastVisibleRow; i++) {
			// opakuje se to po vysce matice zajistuje to modulo
			for (int j = 0; j < tiles[i % tiles.length].length; j++) {
				int x = j * Tile.SIZE;
				// mame od spoda normalne i* vyska dlazdice
				int y = pixelHeight - i * Tile.SIZE - Tile.SIZE;

				// dlazdice je velka 10x10
				// opakuje se to po vysce matice zajistuje to modulo
				Tile tile = tiles[i % tiles.length][j];
				tile.draw(g, x, y + elapsedY);
				//otestovat kolizi autem, pokud se nejedna o RoadTile
				if(tile.isLethal())
				{
					if(car.collidesWithRect(x,y+elapsedY,Tile.SIZE,Tile.SIZE))
					{
						//auto koliduje se smrtici dlazdici
						System.out.println("GameOver");
					}
				}
			}

		}
		car.draw(g);

	}

	public void tick() {
		// elapsedY+=2; //zrychleni
		elapsedY++;// pri kazdym tick to posunu o jeden pixel, taky rikam, jak rychle to jede
	}

	public int getPixelHeight() {

		return pixelHeight;
	}

	public void rideLeft() {
	 car.setX(car.getX()-1);

	}

	public void rideRight() {
		car.setX(car.getX()+1);
	}

}

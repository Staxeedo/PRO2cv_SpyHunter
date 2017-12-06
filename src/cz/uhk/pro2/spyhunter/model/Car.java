package cz.uhk.pro2.spyhunter.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Car {
	// y se nemeni, protoze auto je porad dole
	private int x;
	private int y;
	private static int HEIGHT = 30;
	private static int WIDTH = 20;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y,WIDTH,HEIGHT);
	}

	public void setScreenHeight(int screenHeight) {
		y=screenHeight-HEIGHT;

	}

	public void setScreenWidth(int screenWidth) {
		x=screenWidth/2 -WIDTH/2 ;
		
	}

	public boolean collidesWithRect(int x, int y, int width, int height) {
		// overime zda coliduje obdelnik auta s obdelnikem dlazdice
		Rectangle carRect = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
		Rectangle tileRect = new Rectangle(x, y, width, height);
		return carRect.intersects(tileRect);
	}

}

package cz.uhk.pro2.spyhunter.model;

import java.awt.Graphics;
import java.awt.Image;



public abstract class AbstractTile implements Tile{
	
	protected java.awt.Image image;

	public AbstractTile(Image image) {
		this.image=image;
	}
	@Override
	public void draw(Graphics g, int x, int y) {
		g.drawImage(this.image,x,y,null);
		
	}
	
	

}

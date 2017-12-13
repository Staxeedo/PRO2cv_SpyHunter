package cz.uhk.pro2.spyhunter.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class BonusTile extends AbstractTile{
	public BonusTile(Image image) {
		super(image);
		// TODO Auto-generated constructor stub
	}
	private boolean active = true;
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public void draw(Graphics g, int x, int y) {
		if(active) {
		super.draw(g,x,y);}
		else {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 10, 10);
		}
		
		
	}
	@Override
	public Boolean isLethal() {
	
		return false;
	}
	

}

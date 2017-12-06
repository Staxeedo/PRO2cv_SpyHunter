package cz.uhk.pro2.spyhunter.model;

import java.awt.Color;
import java.awt.Graphics;

public class NonRoadTile implements Tile {
	private int type = 0;
	public NonRoadTile() {
	
	}
	public NonRoadTile(int type) {
		this.type=type;
	}
	
	@Override
	public void draw(Graphics g, int x, int y) {
		if(type==1)
			g.setColor(Color.YELLOW);
	    else
		g.setColor(Color.GREEN);
		
		
		
		g.fillRect(x, y, 10, 10);
		
	}
	@Override
	public Boolean isLethal() {
		
		return true;
	}

}

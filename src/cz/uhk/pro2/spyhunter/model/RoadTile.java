package cz.uhk.pro2.spyhunter.model;

import java.awt.Color;
import java.awt.Graphics;

public class RoadTile implements Tile{
@Override
public void draw(Graphics g, int x, int y) {
	g.setColor(Color.BLACK);
   g.fillRect(x,y,10,10);
	
}
@Override
	public Boolean isLethal() {
		return false;
	}

}

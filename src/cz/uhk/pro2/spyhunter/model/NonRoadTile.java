package cz.uhk.pro2.spyhunter.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class NonRoadTile extends AbstractTile {

	public NonRoadTile(Image image) {
		super(image);
	}
	
	
	
	
	@Override
	public Boolean isLethal() {
		
		return true;
	}

}

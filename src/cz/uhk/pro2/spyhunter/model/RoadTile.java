package cz.uhk.pro2.spyhunter.model;


import java.awt.Image;

public class RoadTile extends AbstractTile{

	public RoadTile(Image image) {
		super(image);
	}

@Override
	public Boolean isLethal() {
		return false;
	}

}

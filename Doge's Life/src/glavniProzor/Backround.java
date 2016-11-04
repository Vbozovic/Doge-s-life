package glavniProzor;

import java.awt.image.BufferedImage;

import rafgfxlib.Util;

public class Backround {

	private BufferedImage backround;

	public Backround(String path){
		
		backround = Util.loadImage(path);
		
	}
	
	
	public BufferedImage getBackround() {
		return backround;
	}

	public void setBackround(BufferedImage backround) {
		this.backround = backround;
	}
	
	
	
	
	
	
}

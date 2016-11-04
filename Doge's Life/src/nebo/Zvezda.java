package nebo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import glavniProzor.DogeFrame;
import rafgfxlib.Util;

public class Zvezda {

	
	private Image image;
	private double duzina;
	private int drawLength;
	private int posX;
	private int posY;
	private AffineTransform transImage;
	private double rotate=1;
	private int scale=5;
	
	
	
	public Zvezda(int posX,int posY,int scale,double rotate){
		this.posX = posX;
		this.posY = posY;
		//this.duzina = duzina;
		this.scale=scale;
		this.rotate = rotate;
		transImage = new AffineTransform();
		BufferedImage pom = Util.loadImage("slike/star.png");
		image = pom.getScaledInstance(pom.getWidth()/scale, pom.getHeight()/scale, Image.SCALE_SMOOTH);
		
		//skejlujemo sliku
		
		
		
		
	}
	
	public void update(){
		
	}
	
	
	public void render(Graphics2D g){
		
		int a=-10;
		
		//double drawTo1 = Math.tan(Math.sin(a)+Math.cos(a));
		//double drawTo2 = Math.tan(Math.sin(a)-Math.cos(a));
		
		// Propali pokusaj crtanja sa funkcijom :'(
		/*for(double x=-10;x<=10;x+=(double) 20/(duzina*100)){
			if(x>= -10 && x <=1){
				drawTo = Math.tan(Math.sin(x)+Math.cos(x));
			}else{
				drawTo = Math.tan(Math.sin(x)-Math.cos(x));
			}
			
			g.setColor(Color.WHITE);
			//System.out.println(drawTo);
			g.drawLine(posX, posY, (int)(x+posX), (int)(posY+drawTo));
		}*/
		
		
		if(rotate != 1){
			
			 AffineTransform at = new AffineTransform();
             at.translate(DogeFrame.FRAME_WIDTH / 2, DogeFrame.FRAME_HEIGHT/ 2);
             at.rotate(rotate);
             at.translate(posX, posY);
             
            
             g.drawImage(image, at, null);

			
			
		}else{
			int ih=image.getHeight(null);
			int iw=image.getWidth(null);
			g.drawImage(image, posX-iw/2, posY - ih/2, 
					posX+iw/2, posY + ih/2,
					 0, 0,iw , ih, null);
		}
		
		
		
		
	}

	
	
	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public double getDuzina() {
		return duzina;
	}

	public void setDuzina(double duzina) {
		this.duzina = duzina;
	}

	public int getDrawLength() {
		return drawLength;
	}

	public void setDrawLength(int drawLength) {
		this.drawLength = drawLength;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public AffineTransform getTransImage() {
		return transImage;
	}

	public void setTransImage(AffineTransform transImage) {
		this.transImage = transImage;
	}

	public double getRotate() {
		return rotate;
	}

	public void setRotate(int rotate) {
		this.rotate = rotate;
	}
	
	
	
}

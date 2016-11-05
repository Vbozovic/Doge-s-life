package gui;

import java.awt.Color;
import java.awt.Graphics;

public class DBallM {

	public static final int SIRINA_LOPTE=20;
	
	private Color color= Color.yellow;
	public int x,y;
	public int dir=1;
	
	
	public DBallM(int x,int y,Color c){
		this.x = x;
		this.y = y;
		this.color=c;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public void draw(Graphics g,int centerX,int centerY){
		g.setColor(color);
		g.fillOval(centerX+x-SIRINA_LOPTE/2, centerY+y-SIRINA_LOPTE/2, SIRINA_LOPTE, SIRINA_LOPTE);
	}
	
}

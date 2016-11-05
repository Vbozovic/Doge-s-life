package glavniProzor;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class DogeSprite {

	
	private int posX, posY;
	private SpriteSheet mySheet;
	private int animationID = 0;
	private int animFrame = 0;
	private boolean animPlaying = false;
	private int frameInterval = 2;
	private int frameCountdown = 0;
	
	public DogeSprite(SpriteSheet sheet, int X, int Y)
	{
		posX = X;
		posY = Y;
		mySheet = sheet;
		BufferedImage novo=mySheet.getSheet();
		int w = novo.getWidth()*3;
		int h = novo.getHeight()*3;
		BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		AffineTransform at = new AffineTransform();
		at.scale(3.0, 3.0);
		AffineTransformOp scaleOp = 
		   new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		after = scaleOp.filter(novo, after);
		mySheet.setSheet(after);
		mySheet.setFrameH(after.getHeight()/mySheet.getSheetH());
		mySheet.setFrameW(after.getWidth()/mySheet.getSheetW());
	}
	
	public void update()
	{
		if(animPlaying)
		{
			frameCountdown--;
			if(frameCountdown < 0)
			{
				animFrame = (animFrame + 1) % mySheet.getColumnCount();
				frameCountdown = frameInterval;
			}
		}
	}
	
	public void draw(Graphics g)
	{
		mySheet.drawTo(g, posX, posY, animFrame, animationID);
	}
	
	public int getAnimation() { return animationID; }
	
	public void setAnimation(int anim)
	{
		if(anim >= 0 && anim < mySheet.getRowCount())
			animationID = anim;
	}
	
	public int getFrame() { return animFrame; }
	
	public void setFrame(int frame)
	{
		if(frame >= 0 && frame < mySheet.getColumnCount())
			animFrame = frame;
	}
	
	public void play() { animPlaying = true; }
	public void pause() { animPlaying = false; }
	public void stop() { animPlaying = false; animFrame = 0; frameCountdown = frameInterval; }
	
	public boolean isPlaying() { return animPlaying; }
	
	public int getAnimationInterval() { return frameInterval; }
	public void setAnimationInterval(int i)
	{
		if(i >= 0)
			frameInterval = i;
	}
	
	public void setPosition(int x, int y)
	{
		posX = x;
		posY = y;
	}
	
	public int getPositionX() { return posX; }
	public int getPositionY() { return posY; }
	
	public void move(int movX, int movY)
	{
		posX += movX;
		posY += movY;
	}
	
}

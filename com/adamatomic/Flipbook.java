package com.adamatomic;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class Flipbook
{
	int width;
	int height;
	
	BufferedImage composite;
    Graphics2D graphics;
    
    public Flipbook(int Width, int Height)
    {
    	width = Width;
    	height = Height;
    	
    	composite = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
    	graphics = composite.createGraphics();
    	// Paint it white
        graphics.setBackground(Color.WHITE);
        graphics.clearRect(0, 0, composite.getWidth(), composite.getHeight());
        
        // Enable anti-aliasing and sub-pixel rendering 
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                  RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, 
                                  RenderingHints.VALUE_STROKE_PURE);
    }
    
    public void draw(float x, float y, float pressure, Color color)
    {
    	graphics.setColor(color);
		float radius = pressure * 10;
        graphics.fill(new Ellipse2D.Float(x - radius, y - radius, radius * 2, radius * 2));
    }
}

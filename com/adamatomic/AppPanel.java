package com.adamatomic;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class AppPanel extends Panel
{
	private static final long serialVersionUID = 1L;
	
	Flipbook flipbook;
	int fbx;
	int fby;
	
	Color color;

	public AppPanel()
	{
		flipbook = new Flipbook(100,100);
		color = Color.BLACK;
		
		this.addComponentListener(new ComponentListener() 
        {  
            // This method is called after the component's size changes
            public void componentResized(ComponentEvent arg0)
            {
                locateFlipbook();
            }

			public void componentHidden(ComponentEvent arg0)
			{
				// TODO Auto-generated method stub
			}

			public void componentMoved(ComponentEvent arg0)
			{
				// TODO Auto-generated method stub
			}

			public void componentShown(ComponentEvent arg0)
			{
				// TODO Auto-generated method stub
			}
        });
	}
	
	public void locateFlipbook()
	{
		fbx = (int)((this.getWidth()-flipbook.width)*0.5);
		fby = (int)((this.getHeight()-flipbook.height)*0.5);
	}
	
	public void cursorDragged(float x, float y, float pressure)
	{
		x -= this.getLocation().x;
		y -= this.getLocation().y;
		flipbook.draw(x - fbx,y - fby,pressure,color);
		repaint();
	}
	
	public void cursorEntered(boolean eraser)
	{
		if(eraser)
		{
            color = Color.WHITE;
        }
		else
        {
            color = Color.BLACK;
        }
	}
	
	// Paint the canvas to the screen
    public void paint(Graphics g)
    {
        g.drawImage(flipbook.composite, fbx, fby, null);
    }
}

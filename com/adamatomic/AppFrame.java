package com.adamatomic;
import java.awt.*;
import java.awt.event.*;

import cello.jtablet.*;
import cello.jtablet.event.*;
import cello.jtablet.installer.*;

public class AppFrame extends Frame
{
	private static final long serialVersionUID = 1L;
	
	AppPanel tab;
	
	public AppFrame()
	{
		if(!JTabletExtension.checkCompatibility(this, "1.2.0"))
			return;
		
		//make a new tab
		tab = new AppPanel();
		add(tab);
		
		 // Create the tablet listener
        TabletManager.getDefaultManager().addTabletListener(this, new TabletAdapter()
        {
            // Draw circles when the cursor is dragged
            public void cursorDragged(TabletEvent event)
            {
            	float pressure = event.getPressure();
            	if(event.getDevice().getType() == TabletDevice.Type.UNKNOWN)
            		pressure = 1.0f;
            	tab.cursorDragged(event.getFloatX(), event.getFloatY(), pressure);
            }
            
            // Detect when a new cursor enters the canvas
            public void cursorEntered(TabletEvent event)
            {
            	tab.cursorEntered(event.getDevice().getType() == TabletDevice.Type.ERASER);
            }
        });

        //handle misc window events like resizing
        this.addComponentListener(new ComponentListener() 
        {  
            // This method is called after the component's size changes
            public void componentResized(ComponentEvent arg0)
            {
                Component c = (Component)arg0.getSource();
                Dimension newSize = c.getSize();
                tab.setSize(newSize.width,newSize.height);
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
}

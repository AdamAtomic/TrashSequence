package com.adamatomic;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TrashSequence
{
	public static void main(String[] args)
	{
		Frame frame = new AppFrame();
	    frame.addWindowListener(new WindowAdapter()
	    {
	      public void windowClosing(WindowEvent we)
	      {
	        System.exit(0);
	      }
	    });
	    frame.setSize(640,480);
	    frame.setVisible(true);
	}
}

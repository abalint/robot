import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.*;

public class CoordFind extends JFrame
{

   static JTextArea showC = new JTextArea("STUFF GOES HERE");
    
    public static void main(String[]args)
    {
	new CoordFind();
	while(true){
	    try{
	    Thread.sleep(20);//updates 50 times a secod
	    }
	    catch(InterruptedException ie)
		{
		    System.exit(0);
		}
	    showC.setText("("+MouseInfo.getPointerInfo().getLocation().x+","
			  +MouseInfo.getPointerInfo().getLocation().y+")");
	}

    }//end main

    CoordFind()
    {
	getContentPane().setLayout(null);
	showC.setEditable(false);
	getContentPane().add(showC);
	showC.setBounds(100,100,75,20);
	setTitle("find coords");
	setSize(300, 300);
	setVisible(true);
	
	this.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
		    System.exit(0);
		} } );



    }//end coordfind


}//end class
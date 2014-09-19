import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;
import java.io.*;
import java.awt.Dimension;


public class Listen extends JFrame implements ActionListener 
{


    JButton jButton = new JButton("GO");
    JTextArea jTextArea = new JTextArea();
    JLabel jLabel = new JLabel("Listener");
    JLabel prompt = new JLabel("Input");
    JScrollPane spane = new JScrollPane(jTextArea);


    public static void main(String[]args)
    {
	new Listen();

    }//end main

    Listen()
    {
	
	jButton.addActionListener(this);
	getContentPane().setLayout(null);
	jTextArea.setEditable(false);
	jTextArea.setFont(new Font("Times Roman", Font.BOLD, 10));
	getContentPane().add(jButton);
	getContentPane().add(jTextArea);
	getContentPane().add(jLabel);
	getContentPane().add(prompt);
	getContentPane().add(spane, BorderLayout.CENTER);
	jLabel.setBounds(30,10, 450, 60);
	jButton.setBounds(150,250, 100, 40);
	jLabel.setFont(new Font("Times Roman", Font.BOLD, 24));
	prompt.setBounds(1, 50, 100, 20);
	jTextArea.setBounds(30, 70, 320, 170);//x,y,width,height
	setTitle("Listener");
	setSize(400,350);
	setVisible(true);
	
	this.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e)
		{
		    System.exit(0);
		} } );
	

    }//end RobotProject


        public void actionPerformed(java.awt.event.ActionEvent e)
  
      {
	  setVisible(false);
	  

      }//end actionPerformed

}//end class


















/*



import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.*;
import java.io.*;
import java.awt.Dimension;

class RobotProject extends JFrame implements ActionListener
{
    JButton jButton = new JButton("GO");
    JTextArea jTextArea = new JTextArea();
    JTextArea helpInfo = new JTextArea("");
    JLabel jLabel = new JLabel("The Robot");
    JTextField jFileName = new JTextField("");
    JLabel prompt = new JLabel("Commands:");
    JLabel usage = new JLabel("Usage:");
    JLabel jFileNameLabel = new JLabel("Command File");
    JScrollPane spane = new JScrollPane(jTextArea);
    static JTextArea showC = new JTextArea("");

    public static void main(String[]args)
    {
	new RobotProject();
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
	}//end while
    }//end main

    RobotProject()
    {
	
	jButton.addActionListener(this);
	getContentPane().setLayout(null);
	jTextArea.setEditable(true);
	jTextArea.setFont(new Font("Times Roman", Font.BOLD, 10));
	getContentPane().add(showC);
	getContentPane().add(jButton);
	getContentPane().add(jTextArea);
	getContentPane().add(jLabel);
	getContentPane().add(jFileName);
	getContentPane().add(prompt);
	getContentPane().add(helpInfo);
	getContentPane().add(usage);
	getContentPane().add(jFileNameLabel);
	getContentPane().add(spane, BorderLayout.CENTER);
	jLabel.setBounds(30,10, 450, 60);
	jButton.setBounds(100, 450, 80, 40);
	jLabel.setFont(new Font("Times Roman", Font.BOLD, 24));
	prompt.setBounds(1, 50, 100, 20);
	usage.setBounds(100, 50, 80, 20);
	jTextArea.setBounds(10, 70, 80, 405);
	jFileName.setBounds(100, 435, 80, 20);
	jFileNameLabel.setBounds(95, 405, 90, 20);
	helpInfo.setBounds(100, 70, 80, 400);
	showC.setBounds(10, 475, 80, 20);//x pos, y pos, width, height
	showC.setEditable(false);
	helpInfo.setEditable(false);
	helpInfo.setText("Type text:\n   t:abc\n   t:ALTDN"
			 + "\n   t:ALTUP"
			 + "\n   t:CTRLDN"
			 + "\n   t:CTRLUP"
			 + "\n   t:TAB"
			 + "\n   t:ENTER"
			 + "\n   t:ESCAPE"
			 + "\nMove mouse:\n   m:x,y\n"
			 + "LeftClick:\n    c:\n"
			 + "Right Click: \n   r:\n"
			 + "Wait in secs:\n   w:n\n"
			 // + "Cap screen:\n   s:\n"
			 + "Beep:\n   b:\n"
			 + "Loop times:\n   l:n\n");
			 // + "End:\n   e:");

	setTitle("Robot");
	setSize(200,520);
	setVisible(true);
	
	this.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e)
		{
		    System.exit(0);
		} } );
	

    }//end RobotProjet


        public void actionPerformed(java.awt.event.ActionEvent e)
  
      {
	
	      setVisible(false);
	      Robot robot = null;
	      try{
		  robot = new Robot();
		  robot.delay(500);
	      }
	      catch(AWTException awte){
		  System.exit(0);
	      }//end catch
	      String[] commands = new String[200];
	      int numberCommands=0;
	      
	     
	      if(!jFileName.getText().equals("")){
	
		  try{
		  
		  BufferedReader bufferedFile = new BufferedReader(new FileReader(
						jFileName.getText()));
		  int commandIndex = 0;
		  String inline = "";
		 while((inline = bufferedFile.readLine()) != null){
		     commands[commandIndex++] = inline;
		     }//end while
		   numberCommands = commandIndex;
		  }//end try
		  catch(FileNotFoundException fnfe){
		      System.exit(0);
		  }//end catch
		  catch(IOException ioe){
		      System.exit(0);
		  }//end catch
	      }//end if
	      else{
		  commands = jTextArea.getText().split("\n");
		  numberCommands = commands.length;
	      }
	      String op1 = commands[0].substring(0,1);
	      String loopdata = commands[0].substring(2);
	      int loopi = 1;
	      if(op1.toCharArray()[0] == 'l')
		  {
		       loopi = Integer.parseInt(loopdata);
		  }
	      for(int iloop = 0; iloop<loopi; iloop++)
		  {

		   for(int loopIndex = 0; loopIndex < numberCommands; loopIndex++)
		       {
			   
			   String operation = commands[loopIndex].substring(0,1);
			   String data = commands[loopIndex].substring(2);
			   
			   switch(operation.toCharArray()[0])
			       {
			       case 'l':
				   break;

			       case 't':
				   if(data.equals("ALTDN"))
				       robot.keyPress(KeyEvent.VK_ALT);
				   else if(data.equals("ALTUP"))
				       robot.keyRelease(KeyEvent.VK_ALT);
				   
				   if(data.equals("CTRLDN"))
				      robot.keyPress(KeyEvent.VK_CONTROL);
				   else if(data.equals("CTRLUP"))
				       robot.keyRelease(KeyEvent.VK_CONTROL);
				   
				   else if(data.equals("ENTER")){
				       robot.keyPress(KeyEvent.VK_ENTER);
				       robot.keyRelease(KeyEvent.VK_ENTER);
				   }//end elseif for ENTER

				   else if(data.equals("TAB")){
				       robot.keyPress(KeyEvent.VK_TAB);
				       robot.keyRelease(KeyEvent.VK_TAB);
				   }//end elseif for TAB

				   else if(data.equals("ESCAPE")){
				       robot.keyPress(KeyEvent.VK_ESCAPE);
				       robot.keyRelease(KeyEvent.VK_ESCAPE);
				   }//end elseif for ESCAPE

				   else{
				       char chars[] = data.toCharArray();
				       for(int charIndex = 0; charIndex < chars.length;
					   charIndex++){
					   
					   if(chars[charIndex] >= 'a' &&
					      chars[charIndex] <= 'z'){
					       robot.keyPress((int)chars[charIndex]
							      - ('a' -'A'));
					       robot.keyRelease((int)chars[charIndex]
								-('a' -'A'));
					   }//end if for lowercase

					   else if(chars[charIndex] >= 'A' &&
						   chars[charIndex] <= 'Z'){
					       
					       robot.keyPress(KeyEvent.VK_SHIFT);
					       robot.keyPress((int)chars[charIndex]);
					       robot.keyRelease((int)chars[charIndex]);
					       robot.keyRelease(KeyEvent.VK_SHIFT);

					   }//end else if for capitals
					   
					   else{
					       robot.keyPress((int)chars[charIndex]);
					       robot.keyRelease((int)chars[charIndex]);
					       robot.delay(100);
					   }//end else

				       }//end for
				       
				   }//end else
				   
				   break;
				   
			       case 'm':
				   String coords[] = data.split(",");
				   int x = Integer.parseInt(coords[0]);
				   int y = Integer.parseInt(coords[1]);
				   robot.mouseMove(x, y);
				   robot.delay(500);

				   break;
			       case 'c':
				   robot.mousePress(InputEvent.BUTTON1_MASK);
				   robot.delay(500);
				   robot.mouseRelease(InputEvent.BUTTON1_MASK);
				   
				   break;
			       case 'r':
				   robot.mousePress(InputEvent.BUTTON3_MASK);
				   robot.delay(500);
				   robot.mouseRelease(InputEvent.BUTTON3_MASK);
			
				   break;
			       case 'w':
				   int numberSeconds = Integer.parseInt(data);
				   robot.delay(numberSeconds * 1000);

				   break;
			       case 'b':
				   Toolkit.getDefaultToolkit().beep();
				   
				   break;
			       case 's':
				   JOptionPane.showMessageDialog(null,"Case s does not work sorry");
				   /*
				   Dimension screenSize = Toolkit.getDefaultToolkit().
				       getScreenSize();
				   BufferedImage bufferedImage = robot.createScreenCapture
				       (newRectangle(screenSize));
				   File outputFile = new File("cap.png");
				   ImageIO.write(bufferedImage, "PNG", outputFile);
				   */

/*
				   break;


				   //case 'e':
				   //setVisible(true); 
				   
				   //break;
			       default: 
				   JOptionPane.showMessageDialog(null,"did not understand command");
				   setVisible(true);
											   
				   
				   
			       }//end switch
			   
		       }//end for
		  }//end for
	      setVisible(true);
      }//end actionPerformed
}//end class
*/



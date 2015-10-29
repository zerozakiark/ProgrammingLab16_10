import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProgrammingLab16_10 extends JFrame {
	
  private DisplayMessage message = new DisplayMessage();

  //initialize UI
  public ProgrammingLab16_10() {
    add(message, BorderLayout.CENTER);
    
    //set focus
    message.setFocusable(true);
  }

  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new ProgrammingLab16_10();
    frame.setTitle("ProgrammingLab16_10");
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null); 
    frame.setVisible(true);
  }

  //extends MessagePanel from book example 13.8
  class DisplayMessage extends MessagePanel {
    private String message = "";
    private StringBuffer newMessage = new StringBuffer();

    public DisplayMessage() {
      setCentered(true);
      //add key listener
      //add new listener
      this.addKeyListener(new Listener()); 
    }
    
    class Listener extends KeyAdapter {

      //use getKeyChar() to return char	
      public void keyTyped(KeyEvent e) {
    	  newMessage.append(e.getKeyChar());
      }
      
      // press enter than output new message 
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          message = newMessage.toString().trim();
          newMessage.setLength(0);
          setMessage(message);
        }
      }
    }
  }
}

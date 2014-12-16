import javax.swing.*;
import java.awt.*;

/**
 *  Klasse für das Frame
 * @author Purger Aaron
 * @version 1.2
 *
 */
public class GUI extends JFrame{

	private Panel p = new Panel();

	public GUI(){
		super("Lights Out");
		this.setSize(500, 500);
		this.add(p);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args){
		new GUI();
	}
	
}

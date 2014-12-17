import javax.swing.*;
import java.awt.*;

/**
 * Frameklasse zum Spiel LightsOut
 * @author Purger Aaron
 * @version 17.12.2014
 *
 */
public class GUI extends JFrame{

	private Panel p = new Panel(); // Neues Panel erzeugen
	
	/**
	 * Konstruktor für die Klasse 
	 */
	public GUI(){
		super("Lights Out");
		this.setSize(500, 500);
		this.add(p);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}

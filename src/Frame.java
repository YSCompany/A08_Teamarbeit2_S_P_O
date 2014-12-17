import javax.swing.*;
import java.awt.*;

/**
 * Frameklasse zum Spiel LightsOut
 * @author Purger Aaron
 * @version 12.12.2014
 *
 */
public class Frame extends JFrame{
	
	/**
	 * Konstruktor f�r die Klasse 
	 */
	public Frame(GUI gui){
		super("Lights Out"); // Titel setzen
		this.add(gui);
		this.setSize(700, 700); // Gr��e setzen
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3); 
		this.setVisible(true);
		
	}
}

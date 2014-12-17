import javax.swing.*;
import java.awt.*;

/**
 * Die GUI Klasse zum Spiel LightsOut
 * @author Purger Aaron
 * @version 12.12.2014
 */
public class GUI extends JPanel{

	private JButton[][] buttons;
	private Controller controller;
	private JPanel model,panel;
	private JButton neuesSpiel,beenden;
	
	/**
	 * Konstruktor
	 */
	public GUI(Controller controller){
		this.controller = controller;
		this.setLayout(new BorderLayout()); // Ein BorderLayout setzen
		model = new JPanel(); // Neues Panel erzeugen (model)
		panel = new JPanel(); // Neues Panel erzuegen (panel)
		neuesSpiel = new JButton("Neues Spiel"); // Neues Button erzeugen und benennen
		neuesSpiel.setBackground(Color.GREEN); // Farbe des Buttons setzen
		beenden = new JButton("Spiel Beenden"); // Neues Button erzeugen und benennen
		beenden.setBackground(Color.RED);// Farbe des Buttons setzen
		buttons = new JButton[5][5]; 
		int i = 0; // Den Wert 0 auf die Variable i zuweisen 
		for(int j = 0; j<buttons.length; j++){
			for(int h = 0; h<buttons.length; h++){
				buttons[j][h] = new JButton("");
				buttons[j][h].setBorder(BorderFactory.createLineBorder(Color.white));
				buttons[j][h].setActionCommand(i+"");
				buttons[j][h].addActionListener(controller);
				model.add(buttons[j][h]);
				
				i++;
			}
		}
		neuesSpiel(controller.getModel().getField()); 
		beenden.addActionListener(controller); // den Button beenden zum ActionListener hinzufuegen
		neuesSpiel.addActionListener(controller); // Button neuesSpiel zum ActionListener hinzufuegen
		model.setLayout(new GridLayout(5, 5)); // neues GridLayout mit 5 x 5 erzeugen
		panel.setLayout(new GridLayout(1, 4)); 
		panel.add(neuesSpiel); // adden des buttons 'neuesSpiel' zum Panel
		panel.add(beenden); // adden des buttons 'beenden' zum Panel
		this.add(model, BorderLayout.CENTER); // Postionierung
		this.add(panel, BorderLayout.NORTH); // Postionierung
	}
	
	/**
	* Eine Methode das das Spiel neu startet
	* @param feld
	*/
	public void neuesSpiel(boolean[][] feld){
		for(int i = 0; i<buttons.length; i++){
			for(int j = 0; j<buttons.length; j++){
				if(feld[i][j] == true){
					buttons[i][j].setBackground(Color.orange);
				}
				else{
					buttons[i][j].setBackground(Color.black);
				}
			}
		}
	}
	
	/**
	 * Eine Methode zum wechseln des Zustands der Buttons
	 * @param feld 
	 * Zu aktivierende felder
	 * und zu deaktivierende felder
	 */
	public void druecken(boolean[][] feld) {
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				buttons[i][j].setBackground(Color.black);
			}

		}
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				if (feld[i][j] == true) {
					buttons[i][j].setBackground(Color.orange);
				}
			}

		}
	}
	
	/**
	 * Eine Methode zum umschalen der Buttons
	 * @param status
	 */
	public void aendern(boolean umschalten) {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j].setEnabled(umschalten);
			}
		}
	}
	
	/**
	 * Diese Methode gibt eine Meldung wenn das Spiel gewonnen wurde
	 */
	public void gewonnen() {
		JOptionPane.showMessageDialog(null, "Sie haben GEWONNEN ! GRATULATION :D ");
	}
}


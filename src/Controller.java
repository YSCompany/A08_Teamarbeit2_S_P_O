import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Die Controllerklasse (Steuerungsklasse) zum Spiel LightsOut
 * @author Oezsoy Ahmet
 * @version 10.12.2014
 */

public class Controller implements ActionListener {
	
	private GUI gui; // GUI
	private Frame frame; // Frame 
	private Model model; // Model
	
	/**
	 * Konstruktor
	 */
	public Controller(){
		model = new Model(5, 5); // Neues Model erzeugen
		gui = new GUI(this); // Neues GUI erzeugen
		frame = new Frame(gui); // Neues Frame erzeugen
	}
	
	/**
	 * Getter-Methode für die GUI
	 * @return the gui
	 */
	 public GUI getGui() {
		 return gui;
	 }
	 
	/**
	 * Getter-Methode für das Model
	 * @return the model
	 */
	 public Model getModel() {
		 return model;
	}
	
	/**
	 * ActionListener zum reagieren auf das Druecken der Buttons
	 */
	 public void actionPerformed(ActionEvent e) {
		 switch (e.getActionCommand()) {
		 case "Neues Spiel":
			 gui.aendern(true);
			 model.zufaelligeWerte();
			 gui.neuesSpiel(model.getField());
			 break;
		 case "Spiel Beenden":
			 model.beenden();
			 break;
		 default:
			 int xk = Integer.parseInt(e.getActionCommand()) % 5;
			 int yk = Integer.parseInt(e.getActionCommand()) / 5;
			 model.changeField(xk, yk);
			 gui.druecken(model.getField());
			 if (model.gewonnenCheck() == true) {
				 gui.aendern(false);
				 gui.druecken(model.getField());
				 gui.gewonnen();
			 }
		 }
	 }
}
	

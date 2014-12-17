import java.io.Closeable;
import java.util.Random;
import javax.swing.JOptionPane;
import com.sun.imageio.stream.StreamCloser.CloseAction;


/**
 * Die Model-Klasse zum Spiel LightsOut
 * @author Yehezkel Sivan
 * @version 12.12.2014
 */
public class Model {
	private boolean field[][]; //Erstellt ein 2D Array
	private int height, width; // hoehe und breite
	
	/**
	 * Standard-Konstruktor der Klasse Model
	 * @param height
	 * @param width
	 */
	public Model(int height, int width){
		this.width = width;
		this.height = height;
		zufaelligeWerte();
	}
	
	/**
	 * Diese Methode setzt zufällige Werte vom 2D Array auf true oder false
	 */
	public void zufaelligeWerte(){
		field = new boolean[height][width];
		Random r = new Random();
		for(int i=0; i<field.length; i++){
			for(int e=0; e<field[i].length; e++){
				field[i][e] = r.nextBoolean();
			}
		}
	}
	
	/**
	* Diese Methode ueberprueft ob alle Felder den richtigen Zustand haben
	* @return false wenn ein Feld den Zustand true hat, true wenn alle Felder false sind
	*/
	public boolean gewonnenCheck() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				if (field[i][j] == true) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	* Gibt das Feld zurueck
	* @return the field
	*/
	public boolean[][] getField() {
		return field;
	}
	
	/**
	 * Diese Methode beendet das Spiel
	 */
	public void beenden() {
		int result = JOptionPane.showConfirmDialog(null,"Möchten Sie das Programm beenden?", "Spiel beenden", JOptionPane.YES_NO_OPTION); 
		switch(result) { 
			case JOptionPane.YES_OPTION: 
			System.exit(0); //Aktion(en) bei Klicken auf den "Ja-Button"
      } 
	}
	
	/**
	 * Diese Methode verändert den Wert der gedrückten Buttons und die von seinen umliegenden Buttons.
	 * @param y
	 * @param x
	 */
	public void changeField(int y, int x) {
		field[x][y] = !field[x][y];
		if (x>=1) {
			field[x-1][y] = !field[x-1][y];
		}
		if (x<width-1) {
			field[x+1][y] = !field[x+1][y];
		}
		if (y>=1) {
			field[x][y-1] = !field[x][y-1];
		}
		if (y<height-1) {
			field[x][y+1] = !field[x][y+1];
		}
	}
}

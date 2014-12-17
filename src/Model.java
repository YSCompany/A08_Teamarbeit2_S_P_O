import java.util.Random;


/**
 * Die Model-Klasse zum Spiel LightsOut
 * @author Yehezkel Sivan
 * @version 2014.12.17, v0.8
 */
public class Model {
	private boolean field[][]; //Erstellt ein 2D Array
	private int height, width;
	
	/**
	 * Standard-Konstruktor der Klasse Model
	 * @param height
	 * @param width
	 */
	public Model(int height, int width){
		this.width = width;
		this.height = height;
		init();
	}
	
	/**
	 * Diese Methode setzt zufällige Werte vom 2D Array auf true oder false
	 */
	void init(){
		field = new boolean[height][width];
		Random r = new Random();
		for(int i=0; i<field.length; i++){
			for(int e=0; e<field[i].length; e++){
				field[i][e] = r.nextBoolean();
			}
		}
	}
	
	/**
	 * Diese Methode setzt alle Werte auf false und bewältigt das Spiel
	 */
	void solve(){
		for(int i=0; i<field.length; i++){
			for(int e=0; e<field.length; e++){
				field[i][e] = false;
			}
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
	
	//checkWin(), getField(), actualStatus()
	
}

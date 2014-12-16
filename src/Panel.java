import javax.swing.*;

import java.awt.*;

/**
 * Klasse für das panel und die Buttons
 * @author Purger Aaron
 * @version 1.2
 * 
 *
 */
public class Panel extends JPanel{

	private JButton[][] buttons;
	private Controller controller;
	private JLabel feld;
	private JPanel p1;
	
	public Panel(){
		this.setLayout(new BorderLayout());
		p1 = new JPanel();
		p1.setLayout(new GridLayout(5,5));
	
		controller = new Controller();
		
		buttons = new JButton[5][5];
		feld = new JLabel();
		
		
		int i = 0;
		for(int j = 0; j<buttons.length; j++){
			for(int h = 0; h<buttons.length; h++){
				buttons[j][h] = new JButton("");
				buttons[j][h].setBorder(BorderFactory.createLineBorder(Color.white));
				buttons[j][h].setActionCommand(i+"");
				buttons[j][h].addActionListener(controller);
				p1.add(buttons[j][h]);
				
				i++;
			}
		}
		
		this.add(p1);
		this.add(feld, BorderLayout.SOUTH);
		
		
	}
	// muss im Controller aufgerufen werden mit einem Array
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
	
	public void aendern(boolean status) {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j].setEnabled(status);
			}
		}
	}
	
}


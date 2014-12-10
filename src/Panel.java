import javax.swing.*;
import java.awt.*;


public class Panel extends JPanel{

	private JButton neuesSpiel;
	private JPanel oben;
	
	public Panel(){
		this.setLayout(new BorderLayout());
		
		neuesSpiel = new JButton("Neues Spiel");
		oben = new JPanel();
		
		oben.add(neuesSpiel);
		this.add(oben, BorderLayout.NORTH);
	}
	
}

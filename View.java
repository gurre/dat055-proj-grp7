/**
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Observer;
import java.util.Observable;

public class View extends JFrame implements Observer {
	private	Controller controller;
	
	private JButton btn;
	
	View(Controller c) {
		System.out.println(">> View.View()");
		setController(c);
		
		// Init variables
		btn = new JButton(" >> Click for action <<");
		
		// Configure variables
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Controller handles all actions
		btn.addActionListener(controller);
		getContentPane().add(btn);
		pack();
		setVisible(true);
	}
	
	public void updateButton(String str){
		System.out.println(">> View.updateButton()");
		btn.setText(str);
	}
	
	// Called from java.util.Observer through Model when the models has changed
	public void update(Observable obj, Object arg) {
		System.out.println(">> View.update()");
		if (arg instanceof String) {
			updateButton((String)arg);
			//System.out.println("Observed change!");
		}
	}
	
	// Getters and setters
	public void setController(Controller c){ controller=c; }
	public Controller getController(){ return controller; }
}
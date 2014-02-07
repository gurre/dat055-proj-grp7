/**
 * 
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.util.Observer;
import java.util.Observable;

public class View extends JFrame implements Observer {
	private	Controller controller;

	private JButton sendBtn;
	private JButton returnBtn;
	private JLabel title;
	private JLabel kurs;
	private JLabel sekVal;
	private JLabel information;
	private JTextField input1;
	private JPasswordField passwordfield;
	private JPanel view1;
	
	
	View(Controller c) {
		System.out.println(">> View.View()");
		setController(c);
		
		// Init variables
		sendBtn = new JButton("sendBtn");
		title = new JLabel("Ange ditt PayPalkonto");
		input1 = new JTextField("Epost");
		passwordfield = new JPasswordField();
		view1 = new JPanel();
		
		
		// Configure variables
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Controller handles all actions

		sendBtn.addActionListener(controller);
		
		
		//put every object in a panel

		
		view1.add(title);
		view1.add(input1);
		view1.add(passwordfield);
		view1.add(sendBtn);	
		
		
		//set the size and layout of the panel
		
		view1.setPreferredSize(new Dimension(400, 100));
		view1.setLayout(new BoxLayout(view1, BoxLayout.PAGE_AXIS));
		
		
		Container frameContainer = getContentPane();
		frameContainer.add(view1, BorderLayout.CENTER);
		

		setLocationRelativeTo(null);
		setResizable(false);
		pack();
		setVisible(true);
	}
	
	public void showAmount(){
		
		// From page 1 to page 2. The user must enter the amount BTC/SEK
		
	}
	
	
	public void updateButton(String str){
		System.out.println(">> View.updateButton()");
		sendBtn.setText(str);
		
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
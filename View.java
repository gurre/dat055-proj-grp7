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
import javax.swing.JOptionPane;
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
	private JOptionPane popup;
	
	
	View(Controller c) {
		System.out.println(">> View.View()");
		setController(c);
		
		// Init variables
		sendBtn = new JButton();
		returnBtn = new JButton();
		title = new JLabel();
		kurs = new JLabel();
		sekVal = new JLabel();
		information = new JLabel();
		input1 = new JTextField();
		passwordfield = new JPasswordField();
		view1 = new JPanel();
		
		//show welcomeslide		
		showWelcome();
		
		// Configure variables
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set commands for buttons
		sendBtn.setActionCommand("forward");
		returnBtn.setActionCommand("backwards");
		
		// Controller handles all actions
		sendBtn.addActionListener(controller);
		returnBtn.addActionListener(controller);

		//frame changes
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		

	}

	
	public void showAmount(){
		
		// From page 1 to page 2. The user must enter the amount BTC/SEK
		
	}
	
	public void showError(String error){
		JOptionPane.showMessageDialog(view1, error);
	}
	
	// Called from java.util.Observer through Model when the models has changed
	public void update(Observable obj, Object arg) {
		System.out.println(">> View.update()");
		if (arg instanceof String) {
			showError((String)arg);
			System.out.println("Observed change!");
		}
	}
	
	public void changeView(int slide){
		if(slide == 1){
			showWelcome();
		}else if(slide == 2){
			showTrans();
		}else if(slide == 3){
			showConfirmation();
		}
	}
	
	public void showWelcome(){
		System.out.println(">> View.showWelcome()");
		//
		sendBtn.setText("Logga in");
		title.setText("Logga in med ditt Amazonkonto");
		input1.setText("Epost");
		//put every object needed in a panel
		view1.remove(returnBtn);
		view1.remove (sekVal);
		view1.add(title);
		view1.add(input1);
		view1.add(passwordfield);
		view1.add(sendBtn);			
		//set the size and layout of the panel	
		view1.setPreferredSize(new Dimension(400, 150));
		view1.setLayout(new BoxLayout(view1, BoxLayout.PAGE_AXIS));
		//create a Container that holds the panel		
		Container frameContainer = this.getContentPane();
		frameContainer.add(view1, BorderLayout.CENTER);	
	}
	
	public void showTrans(){
		System.out.println(">> View.showTrans()");
		title.setText("Ange Onskat belopp");
		input1.setText("Belopp");
		sekVal.setText("x 5000");
		sendBtn.setText("Bekräfta");
		returnBtn.setText("Bakåt");

		view1.remove(passwordfield);
		view1.add(title);
		view1.add(input1);
		view1.add(sekVal);
		view1.add(sendBtn);
		view1.add(returnBtn);

		view1.setPreferredSize(new Dimension(400, 150));
		view1.setLayout(new BoxLayout(view1, BoxLayout.PAGE_AXIS));

		Container frameContainer = this.getContentPane();
		frameContainer.add(view1, BorderLayout.CENTER);	
	}
	
	public void showConfirmation(){
		
		System.out.println(">> View.showConfirmation()");
		//
		title.setText("Tack f?r att du valde oss!");
		information.setText("Ha en bra dag!");
		input1.setText("QX<9Wrzslokm?z?#13");
		//remove unwanted objects
		view1.remove(sekVal);
		view1.remove(sendBtn);
		view1.remove(returnBtn);
		//put every object needed in a panel
		view1.add(title);
		view1.add(information);
		view1.add(input1);	
		//set the size and layout of the panel	
		view1.setPreferredSize(new Dimension(400, 150));
		view1.setLayout(new BoxLayout(view1, BoxLayout.PAGE_AXIS));
		//create a Container that holds the panel		
		Container frameContainer = this.getContentPane();
		frameContainer.add(view1, BorderLayout.CENTER);	
	}

	
	// Getters and setters
	public void setController(Controller c){ controller=c; }
	public Controller getController(){ return controller; }
}
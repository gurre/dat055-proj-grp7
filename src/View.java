/**
 * View class.
 * This class only builds the GUI and only knows the Controller class.
 */

import java.awt.*;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.JTextPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.util.Observer;
import java.util.Observable;

public class View extends JFrame implements Observer {
	private	Controller controller;
	private JButton newTransBtn;
	private JButton newAccount;
	private JButton loginBtn;
	public JButton transSendBtn;
	private JButton transReturnBtn;
	private JButton newuserSendBtn;
	private JButton newuserReturnBtn;
	private JLabel kurs;
	public JLabel sekVal;
	private JLabel information;
	private JLabel welcomeTitle;
	private JLabel confTitle;
	private JLabel transTitle;
	private JLabel newuserTypeUser;
	private JLabel newuserTypePassword;
	private JLabel newuserConfPassword;
	private JTextField input1;
	private JTextField numeric1;
	private JTextField welcomeInput;
	private JTextField transInput;
	private JTextPane confInput;
	private JTextField newuserInput;
	private JPasswordField welcomePasswordfield;
	private JPasswordField newuserPasswordfield;
	private JPasswordField newuserPasswordfield2;
	private JPanel views;
	private JPanel view1;
	private JPanel view2;
	private JPanel view3;
	private JPanel view4;
	private JComboBox currencyList;
	private CardLayout layout;
	
	String[] currency = {"SEK", "BTC"}; //For the currencyList
		
	View(Controller c) {
		System.out.println(">> View.View()");
		setController(c);
		
		// Init variables
		newTransBtn = new JButton();
		newAccount = new JButton();
		loginBtn = new JButton();
		transSendBtn = new JButton();
		transReturnBtn = new JButton();
		newuserSendBtn = new JButton();
		newuserReturnBtn = new JButton();
		kurs = new JLabel();
		sekVal = new JLabel();
		information = new JLabel();
		welcomeTitle = new JLabel();
		transTitle = new JLabel();
		confTitle = new JLabel();
		newuserTypeUser = new JLabel();
		newuserTypePassword = new JLabel();
		newuserConfPassword = new JLabel();
		input1 = new JTextField();
		welcomeInput = new JTextField();
		transInput = new JTextField();
		confInput = new JTextPane();
		confInput.setAlignmentX(Component.LEFT_ALIGNMENT);
		newuserInput = new JTextField();
		welcomePasswordfield = new JPasswordField();
		newuserPasswordfield = new JPasswordField();
		newuserPasswordfield2 = new JPasswordField();
		views = new JPanel();
		view1 = new JPanel();
		view2 = new JPanel();
		view3 = new JPanel();
		view4 = new JPanel();
		layout = new CardLayout();
		currencyList = new JComboBox(currency);
		currencyList.setAlignmentX(Component.LEFT_ALIGNMENT);
		numeric1 = new JTextField("0.00");
				
		//Create cards	
		makeViews();
		
		// Configure variables
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set commands for buttons
		loginBtn.setActionCommand("forward");
		transSendBtn.setActionCommand("forward");
		newuserSendBtn.setActionCommand("newUser");
		transReturnBtn.setActionCommand("backwards");
		newuserReturnBtn.setActionCommand("showWelcome");
		newTransBtn.setActionCommand("newTrans");
		newAccount.setActionCommand("newAccount");
		currencyList.setActionCommand("list");
		
		// Controller handles all actions
		loginBtn.addActionListener(controller);
		transSendBtn.addActionListener(controller);
		newuserSendBtn.addActionListener(controller);
		transReturnBtn.addActionListener(controller);
		newuserReturnBtn.addActionListener(controller);
		newTransBtn.addActionListener(controller);
		newAccount.addActionListener(controller);
		numeric1.addKeyListener(controller);
		currencyList.addActionListener(controller);

		//frame changes
		this.setLocationRelativeTo(null);
		//this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * This method creates an error message.
	 * @param Desired text in error message
	 */
	public void showError(String error){
		JOptionPane.showMessageDialog(view1, error);
	}
	
	/**
	 * This method is called from java.util.Observer through 
	 * Model when the models has changed.
	 * @param String for error message
	 * @param BtcMarket Object to update text
	 */
	public void update(Observable obj, Object arg) {
		System.out.println(">> View.update()");
		if(arg instanceof Double){
			sekVal.setText(Double.toString((Double)arg));
		}
		if (arg instanceof String) {
			showError((String)arg);
			System.out.println("   Error: "+((String)arg));
		}
		if (arg instanceof BtcMarket) {
			// Hur uppdateras texten?
			System.out.println("   Got new exchangeRate: "+(((BtcMarket)arg).getCurrentExchangeRate()));
			if( currencyList.getSelectedItem() == "SEK"){
				sekVal.setText( "Exchange rate: " + Double.toString(getAmount()*((BtcMarket)arg).getCurrentExchangeRate()) + " " + currencyList.getSelectedItem() );
			}else if(currencyList.getSelectedItem() == "BTC"){
				sekVal.setText("Exchange rate: " + Double.toString(getAmount()/((BtcMarket)arg).getCurrentExchangeRate()) + " " + currencyList.getSelectedItem());
			}
		}
	}
	
	/**
	 * This method changes between the slides and is
	 * called from Controller when a button is pressed.
	 * @Param int with slide id
	 */
	public void changeView(int slide){
		
		if(slide == 1){
			layout.show(views, "1");
		}else if(slide == 2){
			layout.show(views, "2");
		}else if(slide == 3){
			if (getCurrency().equals("SEK")){
				confInput.setText("\n RECEIPT \n You bought " +numeric1.getText()+ " BTC for " + sekVal.getText()+ " SEK. \n We have deposited this in a BitCoin Wallet for you, it is: \n" +getReceipt()+"\n Time:" +getTimeStamp()) ;
			}
			else{
				confInput.setText("\n RECEIPT \n You bought " +numeric1.getText()+ " SEK for " + sekVal.getText()+ " BTC. \n We have deposited this in a BitCoin Wallet for you, it is: \n" +getReceipt()+"\n Time:" +getTimeStamp()) ;

			}
			layout.show(views, "3");
			
			layout.show(views, "3");
		}else if(slide == 4){
			layout.show(views, "4");
		}
	}
	
	/**
	 * This method creates the Cardlayout view.
	 */
	public  void makeViews(){
		views.setLayout(layout);
		
		showWelcome();
		showTrans();
		showConfirmation();
		showNewUser();
		
		views.add(view1, "1");
		views.add(view2, "2");
		views.add(view3, "3");
		views.add(view4, "4");
		
		layout.show(views, "1");
	    Container frameContainer = this.getContentPane();
		frameContainer.add(views, BorderLayout.CENTER);	
	}
	
	/**
	 * This method creates our Welcome slide (first slide)
	 * Where the user uses its sign-in information.
	 */
	private void showWelcome(){		
		System.out.println(">> View.showWelcome()");

		loginBtn.setText("Log in");
		
		welcomeTitle.setText("Log in with your Account ");
		welcomeInput.setText("Username");
		newAccount.setText("New User?");
		
		//put every object needed in a panel		
		view1.add(welcomeTitle);
		view1.add(welcomeInput);
		view1.add(welcomePasswordfield);
		view1.add(loginBtn);
		view1.add(newAccount);
		
		//Highlights the text in the email-field
		input1.selectAll();
		
		//set the size and layout of the panel	
		view1.setPreferredSize(new Dimension(400, 150));		
		view1.setLayout(new BoxLayout(view1, BoxLayout.PAGE_AXIS));
	}
	
	/**
	 * This method creates the Transaction slide (second slide).
	 * The slide where the user enters an amount to be bought.
	 */
	private void showTrans(){
		System.out.println(">> View.showTrans()");
		transTitle.setText("Enter the desired amount");
		sekVal.setText("Exchange rate: ");
		transSendBtn.setText("Confirm");
		transReturnBtn.setText("Back");
		
		view2.add(transTitle);
		view2.add(numeric1);
		view2.add(sekVal);
		view2.add(transSendBtn);
		view2.add(transReturnBtn);
		view2.add(Box.createRigidArea(new Dimension(0,10)));		
		view2.add(currencyList);
		//Highlights all the text in the amount-field
		transInput.selectAll();
		view2.setPreferredSize(new Dimension(400, 150));
		view2.setLayout(new BoxLayout(view2, BoxLayout.PAGE_AXIS));
	
	}
	
	/**
	 * This method creates the Recipt/confirmation slide (third slide)
	 * Where the user gets an confirmation and its recipt.
	 */
	private void showConfirmation(){	
		confTitle.setText("Thank you for choosing us!");
		information.setText("Have a great day!");
		confInput.setEditable(false);
			
		//put every object needed in a panel
		view3.add(confTitle);
		view3.add(information);
		view3.add(confInput);	
		view3.add(newTransBtn);
		newTransBtn.setText("New Transaction?");
		//set the size and layout of the panel	
		view3.setPreferredSize(new Dimension(400, 150));
		view3.setLayout(new BoxLayout(view3, BoxLayout.PAGE_AXIS));
	}

	
	/**
	 * This method creates the "New user" slide which the user can use 
	 * to create a new account.
	 */
	private void showNewUser(){		
		System.out.println(">> View.showNewUser()");
		
		newuserTypeUser.setText("Type in new username");
		newuserTypePassword.setText("Type in new password");
		newuserConfPassword.setText("Confirm new Password");
		newuserInput.setText("Username");
		newuserSendBtn.setText("Confirm");
		newuserReturnBtn.setText("Back");		
		
		view4.add(newuserTypeUser);
		view4.add(newuserInput);
		view4.add(newuserTypePassword);
		view4.add(newuserPasswordfield);
		view4.add(newuserConfPassword);
		view4.add(newuserPasswordfield2);
		view4.add(newuserSendBtn);
		view4.add(newuserReturnBtn);
		view4.setPreferredSize(new Dimension(400, 200));
		view4.setLayout(new BoxLayout(view4, BoxLayout.PAGE_AXIS));
	}
	
	// Getters and setters
	public void setController(Controller c){ controller=c; }
	public Controller getController(){ return controller; }
	public double getAmount(){
		try {
			return Double.parseDouble(numeric1.getText());
		} catch( Exception e){
			
		}
		return 0.0;
	} //returns the amount as a double
	public String getPassword(){return controller.gethashPassword(new String(welcomePasswordfield.getPassword()));}
	public String getUsername(){System.out.println(welcomeInput.getText());return welcomeInput.getText();	}
	public String getCurrency(){return (String)currencyList.getSelectedItem();};
	public String getnewuserPassword(){return controller.gethashPassword(new String(newuserPasswordfield.getPassword()));}
	public String getnewuserConfPassword(){return controller.gethashPassword(new String(newuserPasswordfield2.getPassword()));}
	public String getnewuserUsername(){System.out.println(newuserInput.getText());return newuserInput.getText();	}
	public String getTimeStamp(){
		java.util.Date date= new java.util.Date();
		String time = new Timestamp(date.getTime()).toString();
		return time;
	};
	public String getReceipt(){
		String time = getTimeStamp();
		System.out.println(controller.gethashPassword(time));
		return controller.gethashPassword(time);
		
		}
	

}
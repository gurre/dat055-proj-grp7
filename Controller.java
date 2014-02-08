/**
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	
	// Accessing our view for updating changes from the view itself and model
	private View view;
	// Accessing the model for updating changes from the view
	private Model model;
	// keep track of which slide that will be shown
	private int viewflowStep;
	
	Controller() {
		System.out.println(">> Controller.Controller()");
		viewflowStep=1;
	}
	

	
	public void preparePurchase(String email, String password){
		if( !email.equals("") && !password.equals("") && Model.placeHolderAccount(email,password) ){
			view.showAmount();
		}else{
			view.showError("Email or Password is wrong.");
		}
	}
	
	public void buyBitcoins(double amount, String valuta){
		if( valuta.equals("SEK") || valuta.equals("BTC")&& amount < 0.00){
			view.showAmount();
		}else{
			view.showError("Please enter a positive number.");
		}
	}
	
	public void purchaseComplete(){
		// Send receipt
		// Restart atm
	}
	
	

	public void action(){	//en if-sats som undersöker om epost och lösenord är godkänt

		System.out.println(">> Controller.action()");
		view.updateButton(">> Changed from controller! <<");
		
		model.action();
	}
	
	public void nextStep(){
		view.changeView(viewflowStep);
	}

	
	// Called from the view
	public void actionPerformed(ActionEvent e){
		System.out.println(">> Controller.actionPerformed()");
		//checks which button is pressed to know which slide will be shown
		if ("forward".equals(e.getActionCommand())) {
			viewflowStep++;
		}else if("backwards".equals(e.getActionCommand())){
			viewflowStep--;
		}
		nextStep();
		
		//action();
	}

	
	
	// Getters and setters
	public void setView(View v){ view=v; }
	public View getView(){ return view; }
	public void setModel(Model m){ model=m; }
	public Model getModel(){ return model; }
}
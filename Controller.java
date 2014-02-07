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
	
	Controller() {
		System.out.println(">> Controller.Controller()");
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
	
	// Called from the view
	public void actionPerformed(ActionEvent e){
		System.out.println(">> Controller.actionPerformed()");
		action();
	}
	
	
	// Getters and setters
	public void setView(View v){ view=v; }
	public View getView(){ return view; }
	public void setModel(Model m){ model=m; }
	public Model getModel(){ return model; }
}
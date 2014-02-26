/**
 * 
 */

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.math.BigInteger;
import java.security.*;


public class Controller implements ActionListener, KeyListener {
	
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
		
	
	//.......Kod som hämtar och ändrar i view.....
	public void preparePurchase(){
		System.out.println(">> Controller.preparePurchase()");
		String password = view.getPassword();
		String email = view.getUsername();		
		if( !email.equals("") &&
			!password.equals("") && 
			model.placeHolderAccount(email,password)
		){
			//view.showAmount(); 
			
			view.changeView(viewflowStep++); //Flowstep 2, gives showTrans
		}else{
			view.showError("Email or Password is wrong.");
			
		}
	}

	
	
	public void buyBitcoins(double amount, String valuta){
		System.out.println(">> Controller.buyBitcoins("+amount+","+valuta+")");
		if( valuta.equals("SEK") || valuta.equals("BTC") && amount < 0.00){
			viewflowStep++; //Flowstep 3, gives showConfirmation
			view.changeView(viewflowStep);
		}else{
			view.showError("Please enter a positive number.");
		}
	}
	
	public void purchaseComplete(){
		System.out.println(">> Controller.purchaseComplete()");
		viewflowStep = 1;
		view.changeView(viewflowStep);
		// Send receipt
		// Restart atm
	}
	
	
	public void action(Object arg){	

		System.out.println(">> Controller.action()");
		
		model.action(arg);
	}
	
	public void nextStep(){
		System.out.println(">> Controller.nextStep()");
		view.changeView(viewflowStep);
	}
	
	


	
	// Called from the view
	public void actionPerformed(ActionEvent e){
		System.out.println(">> Controller.actionPerformed("+(e.getActionCommand())+")");
		//checks which button is pressed to know which slide will be shown
		if ("forward".equals(e.getActionCommand())) {  //Checks witch slide the forward button is pressed
			viewflowStep++;
		}else if("backwards".equals(e.getActionCommand())){
			viewflowStep--;
		}else if("newTrans".equals(e.getActionCommand())||"showWelcome".equals(e.getActionCommand())){
			viewflowStep = 1;
		}/*else if("newAccount".equals(e.getActionCommand())){ //Get the user to the Amazon signup page
			String url = "https://www.amazon.com/ap/register?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dgno_newcust";
	        if(Desktop.isDesktopSupported()){
	            Desktop desktop = Desktop.getDesktop();
	            try {
	                desktop.browse(new URI(url));
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            } catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
	        }
		}*/
		nextStep();
		
		//action();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		//Calculate amount of sek/btc
		action(view.getAmount());
	}
	@Override
	public void keyTyped(KeyEvent e) {}

	
	
	// Getters and setters
	public void setView(View v){ view=v; }
	public View getView(){ return view; }
	public void setModel(Model m){ model=m; }
	public Model getModel(){ return model; }
	public String getPassword(){return view.getPassword();}
	public String gethashPassword(String password){return model.hashPassword(password);}
}

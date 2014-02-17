/**
 * 
 */

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.math.BigInteger;
import java.security.*;


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
		
	public void preparePurchase(){
		String password = view.getPassword();
		String email = view.getUsername();
				
		if( email.equals("Admin") && password.equals(hashPassword("password")) ){
			view.showAmount();
			viewflowStep++;
			view.changeView(viewflowStep);

		}else{
			view.showError("Email or Password is wrong.");
		}
	}
	
	
	public void buyBitcoins(double amount, String valuta){
		if( valuta.equals("SEK") || valuta.equals("BTC") && amount < 0.00){
			view.showAmount();
			viewflowStep++; //Flowstep 3, gives showConfirmation
			view.changeView(viewflowStep);

		}else{
			view.showError("Please enter a positive number.");
		}
	}
	
	public void purchaseComplete(){
		viewflowStep = 1;
		view.changeView(viewflowStep);
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
	
	public String hashPassword(String password)
    {
		
        BigInteger hash = null;
        for(int i=0; i<145734; i++){
            try {

                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(password.getBytes());
                
                hash = new BigInteger(1, md5.digest());
            
                password = hash.toString(16);

            } catch (NoSuchAlgorithmException nsae) {
                // ignore
            }
            while(password.length() < 32 ){
                password = "0"+password;
            }
        }
        return password;
    }


	
	// Called from the view
	public void actionPerformed(ActionEvent e){
		System.out.println(">> Controller.actionPerformed()");
		//checks which button is pressed to know which slide will be shown
		if ("forward".equals(e.getActionCommand())) {  //Checks witch slide the forward button is pressed
			switch(viewflowStep){
				case 1: System.out.println(">> PreparePurchase");
						preparePurchase();
						break;
				case 2: System.out.println(">> BuyBitcoins");
						//buyBitcoins();
						break;
			}
		}else if("backwards".equals(e.getActionCommand())){
			viewflowStep--;
		}else if("newTrans".equals(e.getActionCommand())){
			viewflowStep = 1;
		}else if("newAccount".equals(e.getActionCommand())){ //Get the user to the Amazon signup page
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
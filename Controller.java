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
		
	
	//.......Kod som h�mtar och �ndrar i view.....
	public void preparePurchase(){
		String password = view.getPassword();
		String email = view.getUsername();		
		if( email.equals("Admin") && password.equals(hashPassword("password")) ){
			viewflowStep++;
			view.changeView(viewflowStep);
		}else{
			view.showError("Email or Password is wrong.");
		}
	}
	
	
	public void buyBitcoins(double amount, String valuta){
		if( valuta.equals("SEK") || valuta.equals("BTC") && amount < 0.00){
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
	
	
	public void action(Object arg){	//en if-sats som undersöker om epost och lösenord är godkänt

		System.out.println(">> Controller.action()");
		model.action(arg);
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
			viewflowStep++;
		}else if("backwards".equals(e.getActionCommand())){
			viewflowStep--;
		}else if("newTrans".equals(e.getActionCommand())||"showWelcome".equals(e.getActionCommand())){
			viewflowStep = 1;
		}else if("newAccount".equals(e.getActionCommand())){ //Get the user to the Amazon signup page
			viewflowStep = 4;
			}
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
}

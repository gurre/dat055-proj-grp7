import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.security.*;

/**
 * Controller class contains all logic, it communicates with the view and model through direct
 * method calls.
 */
public class Controller implements ActionListener, KeyListener {
	/**
  * Accessing our view for updating changes from the view itself and model
  */
  private View view;
  /**
  * Accessing the model for updating changes from the view
  */
	private Model model;
	/**
   * keep track of which slide that will be shown
   */
  private int viewflowStep;

	private boolean updating=false;


	Controller() {
		System.out.println(">> Controller.Controller()");
		viewflowStep=1;
	}

	/**
	 * This method checks if the username & password is correct and flips to the
	 * showTrans view. If the username or the password is wrong an errormessage will
	 * appear and you wont come to the next card.
	 */
	public void preparePurchase() throws Exception{
		System.out.println(">> Controller.preparePurchase()");
		String password = view.getPassword();
		String email = view.getUsername();
		if( !email.equals("") &&
			!password.equals("") &&
			model.checkUser(email,password)){
			//view.showAmount();
			view.changeView(viewflowStep++); //Gives showTrans
		}else{
			view.showError("Username or Password is wrong.");

		}
	}

	/**
	 * This method checks which currency is SEK or BTC and if the amount
	 * is greater than zero. Else an error message which tells the user to
	 * enter a positive number and you wont come through to the reciept.
	 */
	public boolean buyBitcoins(double amount, String valuta){
		System.out.println(">> Controller.buyBitcoins("+amount+","+valuta+")");
		if( (valuta.equals("SEK") || valuta.equals("BTC")) && amount > 0.00){
			model.updateExchangeRate();
			view.changeView(viewflowStep);
			return true;
		}else{
			view.showError("Please enter a positive number.");
			return false;
		}
	}

	/**
	 * This method is used when the purchase is completed with no errors
	 * and gets the user to the start window again.
	 */
	public void purchaseComplete(){
		System.out.println(">> Controller.purchaseComplete()");
		viewflowStep = 1;
		view.changeView(viewflowStep);
	}


	/**
	 * This method changes the view to the current one.
	 */
	public void nextStep(){
		System.out.println(">> Controller.nextStep()");
		view.changeView(viewflowStep);
	}

	/**
	 * This method checks which button that is pressed and perfomes the action.
	 * Called from the View
	 */
	public void actionPerformed(ActionEvent e){

		//checks which button is pressed to know which slide will be shown

		if ("forward".equals(e.getActionCommand())){  //Checks if the forward button is pressed
			switch(viewflowStep){
				case 1: System.out.println(">> Controller.actionPerformed(PreparePurchase)");
				try {
					preparePurchase();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					//viewflowStep++;
					break;
				case 2: System.out.println(">> Controller.actionPerformed(BuyBitcoins)");
					if(buyBitcoins(view.getAmount(),view.getCurrency())){
						viewflowStep++;}
					else{
						break;
					}
			}
		}else if("backwards".equals(e.getActionCommand())){
			viewflowStep--;
		}else if("newTrans".equals(e.getActionCommand())||"showWelcome".equals(e.getActionCommand())){
			viewflowStep = 1;
		}else if("newAccount".equals(e.getActionCommand())||"showWelcome".equals(e.getActionCommand())){
			viewflowStep = 4;
			//Checks if the userinformation matches the criterias from the user and adds them to a textfile.
		}else if ("list".equals(e.getActionCommand())){
			model.updateExchangeRate();
		}else if("newUser".equals(e.getActionCommand())||"showWelcome".equals(e.getActionCommand())){
			String password = view.getnewuserPassword();
			String confPassword=view.getnewuserConfPassword();
			String username = view.getnewuserUsername();
			if( !username.equals("") &&
				!password.equals(model.hashPassword("")) &&
				(confPassword.equals(password))){
				//Add username and password  the textfile
				try {
					model.newUser(username, password);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				viewflowStep = 1;
			}else{
				view.showError("Email or Password is wrong.");
			}
		}
		nextStep();
	}



	/**
	 * When a key is released in the amount field the value
	 * should update in a label.
	 */
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {
		//Calculate amount of sek/btc
		//model.action(view.getAmount(),view.getCurrency());
			view.transSendBtn.setEnabled(false);
			model.updateExchangeRate();
			view.transSendBtn.setEnabled(true);
		//}
		//view.sekVal.setText(view.getAmount());
	}
	@Override
	public void keyTyped(KeyEvent e) {}

	/**
   * Set the view
   */
	public void setView(View v){ view=v; }
	/**
   * Get the view
   */
  public View getView(){ return view; }
	/**
   * Set model
   */
  public void setModel(Model m){ model=m; }
	/**
   * Get the model
   */
  public Model getModel(){ return model; }
	/**
   * Get the password of current user
   */
  public String getPassword(){return view.getPassword();}
	/**
  * Get the username of current user
  */
  public String getUsername(){return view.getUsername();}
	/**
  * Get hashed password of the user
  */
  public String gethashPassword(String password){return model.hashPassword(password);}
}

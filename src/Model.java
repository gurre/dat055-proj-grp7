import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Observable;          //Observable is here
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URL;

/**
 * The Model Class is where we make all calculations & and handle all the data.
 * We observe this object from the view.
 */
class Model extends Observable {

	private PaymentProvider paymentProvider;
	private BtcMarket btcMarket;
	private double currentExchangeRate = -1.0;

	Model(){
		System.out.println(">> Model.Model()");
		paymentProvider = new PaymentProvider();
		btcMarket = new BtcMarket();
	}
	public boolean checkUser (String username, String password) throws Exception {
        String line = null;


        BufferedReader reader = new BufferedReader(new FileReader("account.txt"));

        while((line=reader.readLine())!=null){

            if(line.equals(username)){
                line=reader.readLine();

                if (line.equals(password)){
                	reader.close();
                    return true;
                }

                else{
                	reader.close();
                    return false;
                }

            }

        }
        reader.close();
        return false;
    }

	/*
	 * This method checks if the email & password is correct when the user loggin by
	 * match the email & a hashed password against a textfile
	 */
	/*public boolean checkUser(String username, String password){
		System.out.println(">> Model.checkUser("+username+")");
		return checkUser(username, password);

		if(email.equals("admin") && password.equals(hashPassword("test"))){
			return true;
		}else{
			return false;
		}
	}
	/*
	/*
	 * This method returns a hashed password of the users password.
	 */
	public String hashPassword(String password)
    {
		System.out.println(">> Model.hashPassword("+password+")");
        BigInteger hash = null;
        for(int i=0; i<1338; i++){
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

	// Called from controller
	/*public void action(Object arg, String currency){
		System.out.println(">> Model.action()");
		//........Updates view...........
		//Updates View in transactionwindow for exchangerates
		if(arg instanceof Double){
			if(currency.equals("SEK")){
				//notifyObservers(btcMarkets[0].getExchangeRateForSEK((Double)arg));
			}
			else{
				//notifyObservers...getExchangeRateForBTC
			}
		}
	}*/

	/*
	 * This method updates the exchange rate from a server and updates the label
	 * in the View.
	 */
	public void updateExchangeRate(){
		btcMarket.updateRate();
		setChanged();
		notifyObservers(btcMarket);
	}
	public boolean newUser(String username, String password)throws Exception{
        String line = null;


        BufferedReader reader = new BufferedReader(new FileReader("account.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("account.txt", true));
        //PrintWriter writer = new PrintWriter ("account.txt");

        while((line=reader.readLine())!=null){
        	System.out.println(line);

            if(line.equals(username)){
            	writer.close();
            	reader.close();
            	setChanged();
        		notifyObservers("cannot create user");

            	return false;
            }

        }



            writer.write(username);
            writer.newLine();
            writer.write(password);
            writer.newLine();
            writer.close();
            return true;


    }
}

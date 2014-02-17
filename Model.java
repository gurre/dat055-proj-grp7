/**
 * 
 */

import java.util.Observable;          //Observable is here
import java.lang.Runnable;
import java.lang.Thread;

// We observe this object from the view
class Model extends Observable implements Runnable {
	
	private PaymentProvider paymentProvider;
	private BtcMarket[] btcMarkets;
	
	
	Model(){
		System.out.println(">> Model.Model()");
		paymentProvider = new PaymentProvider();
		btcMarkets = new BtcMarket[2];
		btcMarkets[0] = new BtcMarket();
	}
	
	// Called from controller
	public void action(Object arg){
			System.out.println(">> Model.action()");
			
			
			//........Updates view...........
			
			//Updates View in transactionwindow for exchangerates

			if(arg instanceof Double){
			notifyObservers(btcMarkets[0].getExchangeRateForSEK((Double)arg));
			}
			
			(new Thread(this)).start();
	}
	
	// Called from java.lang.Thread, before that Model.action()
	public void run() {
		System.out.println("   Running from thread");
		System.out.println("   Sleeping...");
		try {
			//ignore
		} catch (Exception e) {
			System.out.println(e);
		}
		// Tell the observer we have changed our state
		setChanged();
		// Update the view through Observer
		//notifyObservers(">> Changed from model! <<");
		Thread.currentThread().interrupt();
		System.out.println("   Thread interrupted");
		return;
	}
}
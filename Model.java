/**
 * 
 */

import java.util.Observable;          //Observable is here
import java.lang.Runnable;
import java.lang.Thread;

// We observe this object from the view
class Model extends Observable {
	
	private PaymentProvider paymentProvider;
	private BtcMarket[] btcMarkets;
	private double currentExchangeRate = -1.0;
	
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
			
			
	}
	
	public void updateExchangeRate(){
		
		for (BtcMarket market : btcMarkets){
			market.updateRate();
		}
		
		double int bestPrice;
		for (BtcMarket market : btcMarkets){
			if( bestPrice > market.getExchangeRate() ){
				bestPrice = market.getExchangeRate();
			}
		}
		
		currentExchangeRate = newRate;
		// Tell the observer we have changed our state
		setChanged();
		// Update the view through Observer
		notifyObservers("exchangeRate");
		
	}
	
	
}
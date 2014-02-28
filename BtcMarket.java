

/**
 * 
 */


import org.json.*;
import java.net.*;
import java.util.Scanner;
import java.lang.*;
import java.lang.Runnable;
import java.lang.Thread;

class BtcMarket implements Runnable {
	
	double latestExchangeRate = -1.0;
	
	BtcMarket(){
		System.out.println(">> BtcMarket.BtcMarket()");
	}
	
	
	public synchronized void updateRate(){
		System.out.println(">> BtcMarket.updateRate()");
		//synchronize(this) {
		(new Thread(this)).start();
		//}
		
	}
	
	
	// Called from java.lang.Thread
	public void run() {
		System.out.println("   Updating Btc exchange rates async");
		try {
			double bestPrice;
			String out = new Scanner(new URL("http://api.bitcoincharts.com/v1/markets.json").openStream(), "UTF-8").useDelimiter("\\A").next();
			JSONObject market;
			JSONArray root = new JSONArray(out);
			for (int i = 0; i < root.length(); i++) {
				market = root.getJSONObject(i);
				if( bestPrice > market.getDouble("avg") ){
					bestPrice = market.getDouble("avg");
				}
			}
			latestExchangeRate=bestPrice;
		} catch (Exception e) {
			System.out.println(e);
		}
		Thread.currentThread().interrupt();
		System.out.println("   Thread interrupted");
		return;
	}
	
	
	//public double getExchangeRate(){ return exchangeRate; }
	
	// Getters and setters
	//public void setExchangeRate(double r){ exchangeRate=r; }	/* Not very good to have public */
	//public double getExchangeRateForSEK(double sek){ return ; }
}
/**
 * 
 */

class BtcMarket implements Runnable {
	
	// 1 BTC = ...
	private double exchangeRate = 3574.81526;
	// BTC-e 
	private String name;
	
	private String url;
	
	BtcMarket(){
		System.out.println(">> BtcMarket.BtcMarket()");
	}
	
	
	public synchronized void updateRate(){
		System.out.println(">> BtcMarket.updateRate() "+url+"");
		synchronize(this) {
			(new Thread(this)).start();
		}
		
	}
	
	
	// Called from java.lang.Thread
	public void run() {
		System.out.println("   Updating Btc exchange rates async");
		try {
			
		} catch (Exception e) {
			System.out.println(e);
		}
		Thread.currentThread().interrupt();
		System.out.println("   Thread interrupted");
		return;
	}
	
	
	public double getExchangeRate(){ return exchangeRate; }
	
	// Getters and setters
	//public void setExchangeRate(double r){ exchangeRate=r; }	/* Not very good to have public */
	public double getExchangeRateForSEK(double sek){ return sek*exchangeRate; }
}
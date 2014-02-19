/**
 * 
 */

class BtcMarket {
	
	// 1 BTC = ...
	private double exchangeRate = 3574.81526;
	// BTC-e 
	private String name;
	
	private String url;
	
	BtcMarket(){
		System.out.println(">> BtcMarket.BtcMarket()");
	}
	
	
	public void updateRate(){
		
		
	}
	
	
	// Getters and setters
	//public void setExchangeRate(double r){ exchangeRate=r; }	/* Not very good to have public */
	public double getExchangeRateForSEK(double sek){ return sek*exchangeRate; }
}
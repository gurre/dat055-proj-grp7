/**
 * 
 */

class BtcMarket {
	
	private double exchangeRate;
	private String name;
	private String url;
	
	BtcMarket(){
		System.out.println(">> BtcMarket.BtcMarket()");
	}
	
	
	public void updateRate(){
		
		
	}
	
	
	// Getters and setters
	//public void setExchangeRate(double r){ exchangeRate=r; }	/* Not very good to have public */
	public double getExchangeRate(){ return exchangeRate; }
}
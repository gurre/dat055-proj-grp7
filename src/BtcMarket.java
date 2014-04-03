import org.json.*;
import org.json.JSONArray;
import java.net.*;
import java.util.Scanner;
import java.lang.*;
import java.lang.Runnable;
import java.lang.Thread;

/**
 * This class contains the logic for updating the current exchange rate
 * of bitcoins. It fetches the rate from a json endpoint using HTTP GET.
 *
 */
class BtcMarket implements Runnable {

  /**
   * The latest known exchange rate
   */
	double latestExchangeRate = 999999999.0;
  /**
   * The currency to buy with
   */
  String currency = "SEK";
  /**
   * Is there a pending request?
   */
	boolean updating = false;

	BtcMarket(){
		System.out.println(">> BtcMarket.BtcMarket()");
	}

  /**
   * Checks if the lock is active
   *
   * @return  value of lock
   */
	private synchronized boolean isLocked(){
		return updating;
	}
  /**
   * Sets the lock, used for either locking or unlocking.
   * Used when the request is pending.
   *
   * @param  boolean value to be set
   */
	private synchronized void setLocked(boolean val){
		updating=val;
	}
  /**
   * Starts a thread and updates the bitcoin exchange value
   * against the <i>http://api.bitcoincharts.com/v1/markets.json</i>-endpoint.
   *
   */
	public synchronized void updateRate(){
		System.out.println(">> BtcMarket.updateRate()");

		try {
			Thread t = new Thread(this);
			t.start();
			//t.join();	// Wait for the update to finish
		} catch(Exception e){
			System.out.println("   Exception: BtcMarket.updateRate() was finished early");
		}
	}

  /**
   * Internal thread method
   *
   */
	// Called from java.lang.Thread
	public void run() {
		System.out.println("   Updating Btc exchange rates async");
		if( !isLocked() ){
			setLocked(true);
			try {
				Thread.sleep(10);
				double bestPrice = 999999999.0;
				String out = new Scanner(new URL("http://api.bitcoincharts.com/v1/markets.json").openStream(), "UTF-8").useDelimiter("\\A").next();
				//System.out.println("   Got:"+out);
				JSONObject market;
				JSONArray root = new JSONArray(out);
				for (int i = 0; i < root.length(); i++) {
					market = root.getJSONObject(i);
					if( currency.equals(market.optString("currency")) && bestPrice > market.optDouble("avg") ){
						System.out.println("   Available market: "+(market.optString("currency"))+" @ "+(market.optDouble("avg")));
						bestPrice = market.getDouble("avg");
					}
				}
				latestExchangeRate=bestPrice;
			} catch (Exception e) {
				System.out.println(e);
			}

			System.out.println("   Best current spot price:"+latestExchangeRate);
			setLocked(false);
		}
		Thread.currentThread().interrupt();
		System.out.println("   Thread exited");
		return;
	}

/**
 * Get the last known exchange rate
 *
 * @return  latest exchange rate
 */
	public synchronized double getCurrentExchangeRate(){ return latestExchangeRate; }
}
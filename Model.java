/**
 * 
 */

import java.util.Observable;          //Observable is here
import java.lang.Runnable;
import java.lang.Thread;

// We observe this object from the view
class Model extends Observable implements Runnable {
	
	Model(){
		System.out.println(">> Model.Model()");
	}
	
	// Called from controller
	public void action(){
		System.out.println(">> Model.action()");
		
		(new Thread(this)).start();
	}
	
	// Called from java.lang.Thread, before that Model.action()
	public void run() {
		System.out.println("   Running from thread");
		System.out.println("   Sleeping...");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}
		// Tell the observer we have changed our state
		setChanged();
		// Update the view through Observer
		notifyObservers(">> Changed from model! <<");
		Thread.currentThread().interrupt();
		System.out.println("   Thread interrupted");
		return;
	}
}
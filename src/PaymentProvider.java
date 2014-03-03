/**
 * Gustav...
 */

class PaymentProvider {
		
	PaymentProvider(){
		System.out.println(">> PaymentProvider.PaymentProvider()");
	}
	
	public void makePayment(double amount){
		System.out.println(">> PaymentProvider.makePayment("+amount+")");
		System.out.println("   Payment processed");
	}
}
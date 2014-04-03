/**
 * This class contains a muckup of a possible payment provider
 */
 class PaymentProvider {

	PaymentProvider(){
		System.out.println(">> PaymentProvider.PaymentProvider()");
	}

  /**
   * Process a payment, prints debugging
   *
   * @param  amount of money to charge
   */
	public void makePayment(double amount){
		System.out.println(">> PaymentProvider.makePayment("+amount+")");
		System.out.println("   Payment processed");
	}
}
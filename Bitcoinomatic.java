/**
 * 
 */

class Bitcoinomatic {
	public static void main(String[] args) {
	
		// The model is the database/network/communication/storage-class. Will never change, therefore final
		final Model model = new Model();
	
		// The controller is our middle-man, in between the model and view, it handles whatever needs to happen and when. 
		final Controller controller = new Controller();
	
		// View is were our gui resides. It knows about the controller.
		final View view = new View(controller);
		
		controller.setView(view);
		controller.setModel(model);
		model.addObserver(view);
	}
}
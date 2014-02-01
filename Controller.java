/**
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	
	// Accessing our view for updating changes from the view itself and model
	private View view;
	// Accessing the model for updating changes from the view
	private Model model;
	
	Controller() {
		System.out.println(">> Controller.Controller()");
	}
	
	public void action(){
		System.out.println(">> Controller.action()");
		view.updateButton(">> Changed from controller! <<");
		model.action();
	}
	
	// Called from the view
	public void actionPerformed(ActionEvent e){
		System.out.println(">> Controller.actionPerformed()");
		action();
	}
	
	
	// Getters and setters
	public void setView(View v){ view=v; }
	public View getView(){ return view; }
	public void setModel(Model m){ model=m; }
	public Model getModel(){ return model; }
}
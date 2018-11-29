package application.controller;

import application.model.Calculator;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController implements EventHandler<ActionEvent> {
	
	@FXML
	private Label output;
	private Calculator calc;
	
	/**
	 * MainControler constructor
	 */
	public MainController() {
		super();
		this.calc = new Calculator();
	}
	
	/**
	 * @param ActionEvent event
	 * is using to create the function of each 
	 * button and update the information
	 * in the displayed
	 */
	@Override
	public void handle(ActionEvent event) {
		Button b = (Button)event.getSource();
		this.calc.update( b.getText() );
		this.output.setText( calc.getValue() );
	}
	
	
}
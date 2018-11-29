package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * This program creates a calculator with 25
 * buttons including numbers, operations and
 * clean operations, each time the user
 * enters an operation, it computes the calculation.
 * After a interaction, the user should clear the result
 * using cc button
 */

public class Main extends Application {
	
	private static Stage stage;
	/**
	 * @param primaryStage creates the FXMLLoader.load and pass the
	 * information where the main view is located,
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/MainView.fxml"));
			primaryStage.setScene(new Scene(root, 500, 500));
			primaryStage.setTitle("CS3443 Calculator");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.stage = primaryStage;
	}
	/**
	 * Main Method launch passing args
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
	/**
	 * 
	 * @return stage
	 */
	public static Stage getStage() {
		return stage;
	}
}




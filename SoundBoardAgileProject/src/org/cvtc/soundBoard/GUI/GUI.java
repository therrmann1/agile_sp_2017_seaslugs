package org.cvtc.soundBoard.GUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import org.cvtc.soundBoard.SoundTest;

public class GUI extends Application {
	
	Button randomSoundButton;
	Stage window;

	/**
	 * Launch application GUI
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Set title for application
		window = primaryStage;
		window.setTitle("SeaSlugs Sound Board");
		
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});
		
		Button closeButton = new Button();
		closeButton.setText("Close Program");
		
		randomSoundButton = new Button();
		randomSoundButton.setText("Random Sound");
		
		closeButton.setOnAction(e -> closeProgram());
		randomSoundButton.setOnAction(e -> SoundTest.randomSound());
		
		GridPane layout = new GridPane();
		layout.setPadding(new Insets(10, 10, 10, 10));
		layout.setVgap(8);
		layout.setHgap(10);
		
		layout.getChildren().addAll(closeButton, randomSoundButton);
		GridPane.setConstraints(closeButton, 28, 48);
		GridPane.setConstraints(randomSoundButton, 0, 0);
		
		Scene scene = new Scene(layout, 500, 450);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void closeProgram() {
		Boolean answer = ConfirmBox.display("Confirm Close", "Are you sure you wish to exit?");
		if(answer) {
			window.close();
		}
	}

	
	
}

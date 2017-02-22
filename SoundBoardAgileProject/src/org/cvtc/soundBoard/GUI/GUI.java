package org.cvtc.soundBoard.GUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import org.cvtc.soundBoard.SoundTest;

public class GUI extends Application {
	
	Button randomSoundButton;
	Stage window;
	
	Scene main, SoundBoard1Scene, SoundBoard2Scene, SoundBoard3Scene, SoundBoard4Scene, SoundBoard5Scene, SoundBoard6Scene, SoundBoard7Scene;

	/**
	 * Launch application GUI
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Primary Stage, Main Window
		window = primaryStage;
		window.setTitle("SeaSlugs Sound Board");
		
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});
		
		// Setting layout for main scene
		GridPane layoutMain = new GridPane();
		layoutMain.setPadding(new Insets(10, 10, 10, 10));
		layoutMain.setVgap(8);
		layoutMain.setHgap(10);
		layoutMain.setStyle("-fx-background-color: #87CEFA;");
		
		Button closeButton = new Button();
		closeButton.setText("Close Program");
		
		Label mainSplashLabel = new Label("Select a Sound Board.");
		
		Button SoundBoard1Button = new Button("Go to Sound Board 1");
		SoundBoard1Button.setOnAction(e -> startSoundBoard1(window));
		
		Button SoundBoard2Button = new Button("Go to Sound Board 2");
		SoundBoard2Button.setOnAction(e -> startSoundBoard2(window));
		
		Button SoundBoard3Button = new Button("Go to Sound Board 3");
		SoundBoard3Button.setOnAction(e -> startSoundBoard3(window));
		
		Button SoundBoard4Button = new Button("Go to Sound Board 4");
		SoundBoard4Button.setOnAction(e -> startSoundBoard4(window));
		
		Button SoundBoard5Button = new Button("Go to Sound Board 5");
		SoundBoard5Button.setOnAction(e -> startSoundBoard5(window));
		
		Button SoundBoard6Button = new Button("Go to Sound Board 6");
		SoundBoard6Button.setOnAction(e -> startSoundBoard6(window));
		
		Button SoundBoard7Button = new Button("Go to Sound Board 7");
		SoundBoard7Button.setOnAction(e -> startSoundBoard7(window));
		
		
		// Create Button Elements for Main Scene
		randomSoundButton = new Button();
		randomSoundButton.setText("Random Sound");
		
		int random = (int)(Math.random()*100);
		
		closeButton.setOnAction(e -> closeProgram());
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(random));
		
		// Add Elements to Main Scene
		layoutMain.getChildren().addAll(closeButton, randomSoundButton, mainSplashLabel, SoundBoard1Button, SoundBoard2Button, SoundBoard3Button, SoundBoard4Button, SoundBoard5Button, SoundBoard6Button, SoundBoard7Button);
		GridPane.setConstraints(closeButton, 18, 20);
		GridPane.setConstraints(randomSoundButton, 18, 6);
		GridPane.setConstraints(mainSplashLabel, 18, 0);
		GridPane.setConstraints(SoundBoard1Button, 18, 7);
		GridPane.setConstraints(SoundBoard2Button, 18, 8);
		GridPane.setConstraints(SoundBoard3Button, 18, 9);
		GridPane.setConstraints(SoundBoard4Button, 18, 10);
		GridPane.setConstraints(SoundBoard5Button, 18, 11);
		GridPane.setConstraints(SoundBoard6Button, 18, 12);
		GridPane.setConstraints(SoundBoard7Button, 18, 13);
		
		// Main window layout
		Scene mainScene = new Scene(layoutMain, 500, 450);
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
		
		
	}

	private void closeProgram() {
		Boolean answer = ConfirmBox.display("Confirm Close", "Are you sure you wish to exit?");
		if(answer) {
			window.close();
		}
	}

	private void startSoundBoard1(Stage soundBoard1Stage) {
		window = soundBoard1Stage;
		window.setTitle("SeaSlugs Sound Board");
		
		// Setting layout for SoundBoard1 and creating new scene
		GridPane soundBoard1Layout = new GridPane();
		soundBoard1Layout.setPadding(new Insets(10, 10, 10, 10));
		soundBoard1Layout.setVgap(8);
		soundBoard1Layout.setHgap(10);
		Scene soundBoard1Scene = new Scene(soundBoard1Layout, 500, 450);
	
		soundBoard1Stage.setScene(soundBoard1Scene);
		soundBoard1Stage.show();
		
		Button sound1 = new Button();
		sound1.setText("Hi 1");
		sound1.setOnAction(e -> SoundTest.randomSound(0));
		soundBoard1Layout.getChildren().addAll(sound1);
	}
	
	private void startSoundBoard2(Stage soundBoard2Stage) {
		window = soundBoard2Stage;
		window.setTitle("SeaSlugs Sound Board");
		
		// Setting layout for SoundBoard2 and creating new scene
		GridPane soundBoard2Layout = new GridPane();
		soundBoard2Layout.setPadding(new Insets(10, 10, 10, 10));
		soundBoard2Layout.setVgap(8);
		soundBoard2Layout.setHgap(10);
		Scene soundBoard2Scene = new Scene(soundBoard2Layout, 500, 450);
	
		soundBoard2Stage.setScene(soundBoard2Scene);
		soundBoard2Stage.show();
	}
	
	private void startSoundBoard3(Stage soundBoard3Stage) {
		window = soundBoard3Stage;
		window.setTitle("SeaSlugs Sound Board");
		
		// Setting layout for SoundBoard3 and creating new scene
		GridPane soundBoard3Layout = new GridPane();
		soundBoard3Layout.setPadding(new Insets(10, 10, 10, 10));
		soundBoard3Layout.setVgap(8);
		soundBoard3Layout.setHgap(10);
		Scene soundBoard1Scene = new Scene(soundBoard3Layout, 500, 450);
	
		soundBoard3Stage.setScene(soundBoard1Scene);
		soundBoard3Stage.show();
	}
	
	private void startSoundBoard4(Stage soundBoard4Stage) {
		window = soundBoard4Stage;
		window.setTitle("SeaSlugs Sound Board");
		
		// Setting layout for SoundBoard4 and creating new scene
		GridPane soundBoard4Layout = new GridPane();
		soundBoard4Layout.setPadding(new Insets(10, 10, 10, 10));
		soundBoard4Layout.setVgap(8);
		soundBoard4Layout.setHgap(10);
		Scene soundBoard4Scene = new Scene(soundBoard4Layout, 500, 450);
	
		soundBoard4Stage.setScene(soundBoard4Scene);
		soundBoard4Stage.show();
	}
	
	private void startSoundBoard5(Stage soundBoard5Stage) {
		window = soundBoard5Stage;
		window.setTitle("SeaSlugs Sound Board");
		
		// Setting layout for SoundBoard5 and creating new scene
		GridPane soundBoard5Layout = new GridPane();
		soundBoard5Layout.setPadding(new Insets(10, 10, 10, 10));
		soundBoard5Layout.setVgap(8);
		soundBoard5Layout.setHgap(10);
		Scene soundBoard1Scene = new Scene(soundBoard5Layout, 500, 450);
	
		soundBoard5Stage.setScene(soundBoard1Scene);
		soundBoard5Stage.show();
	}
	
	private void startSoundBoard6(Stage soundBoard6Stage) {
		window = soundBoard6Stage;
		window.setTitle("SeaSlugs Sound Board");
		
		// Setting layout for SoundBoard6 and creating new scene
		GridPane soundBoard6Layout = new GridPane();
		soundBoard6Layout.setPadding(new Insets(10, 10, 10, 10));
		soundBoard6Layout.setVgap(8);
		soundBoard6Layout.setHgap(10);
		Scene soundBoard6Scene = new Scene(soundBoard6Layout, 500, 450);
	
		soundBoard6Stage.setScene(soundBoard6Scene);
		soundBoard6Stage.show();
	}
	
	private void startSoundBoard7(Stage soundBoard7Stage) {
		window = soundBoard7Stage;
		window.setTitle("SeaSlugs Sound Board");
		
		// Setting layout for SoundBoard7 and creating new scene
		GridPane soundBoard7Layout = new GridPane();
		soundBoard7Layout.setPadding(new Insets(10, 10, 10, 10));
		soundBoard7Layout.setVgap(8);
		soundBoard7Layout.setHgap(10);
		Scene soundBoard7Scene = new Scene(soundBoard7Layout, 500, 450);
	
		soundBoard7Stage.setScene(soundBoard7Scene);
		soundBoard7Stage.show();
	}
	
}

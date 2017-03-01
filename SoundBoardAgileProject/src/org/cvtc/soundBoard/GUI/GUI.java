package org.cvtc.soundBoard.GUI;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

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
		
		// Adding Seaslugs logo
		final Image logo = new Image("logo.png", 100, 100, true, true);
		ImageView logoView = new ImageView(logo);
	
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});
		
		// Setting layout for main scene
		Pane layoutMain = new Pane();
		layoutMain.setPadding(new Insets(10, 10, 10, 10));
		layoutMain.setStyle("-fx-background-color: #FFF;");
		
		Button closeButton = new Button();
		closeButton.setText("X");
		closeButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		
		Button stopButton = new Button();
		stopButton.setText("STOP");
		stopButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		
		Button SoundBoard1Button = new Button("Greetings");
		SoundBoard1Button.setOnAction(e -> startSoundBoard1(window));
		SoundBoard1Button.getStyleClass().add("SoundBoardButtons");
		
		Button SoundBoard2Button = new Button("Scary Sounds");
		SoundBoard2Button.setOnAction(e -> startSoundBoard2(window));
		SoundBoard2Button.getStyleClass().add("SoundBoardButtons");
		
		Button SoundBoard3Button = new Button("Animal Sounds");
		SoundBoard3Button.setOnAction(e -> startSoundBoard3(window));
		SoundBoard3Button.getStyleClass().add("SoundBoardButtons");
		
		Button SoundBoard4Button = new Button("Farts");
		SoundBoard4Button.setOnAction(e -> startSoundBoard4(window));
		SoundBoard4Button.getStyleClass().add("SoundBoardButtons");
		
		Button SoundBoard5Button = new Button("Blast Waves");
		SoundBoard5Button.setOnAction(e -> startSoundBoard5(window));
		SoundBoard5Button.getStyleClass().add("SoundBoardButtons");
		
		Button SoundBoard6Button = new Button("Go to Sound Board 6");
		SoundBoard6Button.setOnAction(e -> startSoundBoard1(window));
		SoundBoard6Button.getStyleClass().add("SoundBoardButtons");
		
		Button SoundBoard7Button = new Button("Go to Sound Board 7");
		SoundBoard7Button.setOnAction(e -> startSoundBoard1(window));
		SoundBoard7Button.getStyleClass().add("SoundBoardButtons");
		
		// Creating background for main splash text to clash with.
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.AQUA);
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.BLUE);
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		logoView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> SoundTest.randomSound(25));
		
		// Create Button Elements for Main Scene
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #547AE0");
		
		Random randomSound = new Random();
		
		closeButton.setOnAction(e -> closeProgram());
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(randomSound.nextInt(25)));
		
		// Position elements in the scene and add them to the scene.
		layoutMain.getChildren().addAll(mainSplashBackground, logoView, stopButton ,closeButton, randomSoundButton, mainSplash, SoundBoard1Button, SoundBoard2Button, SoundBoard3Button, SoundBoard4Button, SoundBoard5Button, SoundBoard6Button, SoundBoard7Button);
		closeButton.relocate(640, 350);
		stopButton.relocate(320, 350);
		randomSoundButton.relocate(10, 350);
		mainSplash.relocate(200, -410);
		mainSplashBackground.relocate(0, 0);
		SoundBoard1Button.relocate(100, 150);
		SoundBoard2Button.relocate(280, 150);
		SoundBoard3Button.relocate(460, 150);
		SoundBoard4Button.relocate(540, 250);
		SoundBoard5Button.relocate(370, 250);
		SoundBoard6Button.relocate(200, 250);
		SoundBoard7Button.relocate(30, 250);
		logoView.relocate(50, -10);
		
		// Main window layout
		Scene mainScene = new Scene(layoutMain, 700, 400);
		primaryStage.setScene(mainScene);
		primaryStage.show();
		mainScene.getStylesheets().add("styles.css");
		primaryStage.getIcons().add(new Image("logo.png"));
	
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
		Pane soundBoard1Layout = new Pane();
		soundBoard1Layout.setPadding(new Insets(10, 10, 10, 10));
		Scene soundBoard1Scene = new Scene(soundBoard1Layout, 700, 400);
		soundBoard1Layout.setStyle("-fx-background-color: #FFF;");
		
		soundBoard1Stage.setScene(soundBoard1Scene);
		soundBoard1Stage.show();
		
		// Adding Seaslugs logo
		final Image logo = new Image("logo.png", 100, 100, true, true);
		ImageView logoView = new ImageView(logo);
		
		// Adding Back Button
		Button backButton = new Button();
		backButton.setText("BACK");
		backButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		
		
		// Creating background for main splash text to clash with.
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.AQUA);
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.BLUE);
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		// Create Button Elements for Main Scene
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #547AE0");
		
		Random randomSound = new Random();
		
		backButton.setOnAction(e -> {
			try {
				start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(randomSound.nextInt(4)));
		
		Button sound1 = new Button();
		sound1.setText("Hi 1");
		sound1.setOnAction(e -> SoundTest.randomSound(0));
		sound1.getStyleClass().add("SoundBoardButtons");
		
		Button sound2 = new Button();
		sound2.setText("Hi 2");
		sound2.setOnAction(e -> SoundTest.randomSound(1));
		sound2.getStyleClass().add("SoundBoardButtons");
		
		Button sound3 = new Button();
		sound3.setText("Hi 3");
		sound3.setOnAction(e -> SoundTest.randomSound(2));
		sound3.getStyleClass().add("SoundBoardButtons");
		
		Button sound4 = new Button();
		sound4.setText("Hi 4");
		sound4.setOnAction(e -> SoundTest.randomSound(3));
		sound4.getStyleClass().add("SoundBoardButtons");
		
		Button sound5 = new Button();
		sound5.setText("Hi 5");
		sound5.setOnAction(e -> SoundTest.randomSound(4));
		sound5.getStyleClass().add("SoundBoardButtons");
		
		sound1.relocate(200, 150);
		sound2.relocate(400, 150);
		sound3.relocate(100, 250);
		sound4.relocate(300, 250);
		sound5.relocate(500, 250);
		backButton.relocate(600, 350);
		randomSoundButton.relocate(10, 350);
		mainSplash.relocate(200, -410);
		mainSplashBackground.relocate(0, 0);
		logoView.relocate(50, -10);
		
		
		// Adding all Children to the Scene.
		soundBoard1Layout.getChildren().addAll(sound1, sound2, sound3, sound4, sound5, randomSoundButton, mainSplashBackground, mainSplash, backButton, logoView);
		soundBoard1Scene.getStylesheets().add("styles.css");
	}
	
	private void startSoundBoard2(Stage soundBoard2Stage) {
		window = soundBoard2Stage;
		window.setTitle("SeaSlugs Sound Board");
		
		// Setting layout for SoundBoard1 and creating new scene
		Pane soundBoard2Layout = new Pane();
		soundBoard2Layout.setPadding(new Insets(10, 10, 10, 10));
		Scene soundBoard2Scene = new Scene(soundBoard2Layout, 700, 400);
		soundBoard2Layout.setStyle("-fx-background-color: #FFF;");
		
		soundBoard2Stage.setScene(soundBoard2Scene);
		soundBoard2Stage.show();
		
		// Adding Seaslugs logo
		final Image logo = new Image("logo.png", 100, 100, true, true);
		ImageView logoView = new ImageView(logo);
		
		// Adding Back Button
		Button backButton = new Button();
		backButton.setText("BACK");
		backButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		
		
		// Creating background for main splash text to clash with.
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.AQUA);
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.BLUE);
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		// Create Button Elements for Main Scene
		
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #547AE0");
		
		Random randomSound = new Random();
		
		int randomNum = randomSound.nextInt((9 - 5) + 1) + 5;
		
		backButton.setOnAction(e -> {
			try {
				start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(randomSound.nextInt(randomNum)));
		
		Button sound1 = new Button();
		sound1.setText("Scary Sound 1");
		sound1.setOnAction(e -> SoundTest.randomSound(5));
		sound1.getStyleClass().add("SoundBoardButtons");
		
		Button sound2 = new Button();
		sound2.setText("Scary Sound 2");
		sound2.setOnAction(e -> SoundTest.randomSound(6));
		sound2.getStyleClass().add("SoundBoardButtons");
		
		Button sound3 = new Button();
		sound3.setText("Scary Sound 3");
		sound3.setOnAction(e -> SoundTest.randomSound(7));
		sound3.getStyleClass().add("SoundBoardButtons");
		
		Button sound4 = new Button();
		sound4.setText("Scary Sound 4");
		sound4.setOnAction(e -> SoundTest.randomSound(8));
		sound4.getStyleClass().add("SoundBoardButtons");
		
		Button sound5 = new Button();
		sound5.setText("Scary Sound 5");
		sound5.setOnAction(e -> SoundTest.randomSound(9));
		sound5.getStyleClass().add("SoundBoardButtons");
		
		sound1.relocate(200, 150);
		sound2.relocate(400, 150);
		sound3.relocate(100, 250);
		sound4.relocate(300, 250);
		sound5.relocate(500, 250);
		backButton.relocate(600, 350);
		randomSoundButton.relocate(10, 350);
		mainSplash.relocate(200, -410);
		mainSplashBackground.relocate(0, 0);
		logoView.relocate(50, -10);
		
		
		// Adding all Children to the Scene.
		soundBoard2Layout.getChildren().addAll(sound1, sound2, sound3, sound4, sound5, randomSoundButton, mainSplashBackground, mainSplash, backButton, logoView);
		soundBoard2Scene.getStylesheets().add("styles.css");
	}
	
	private void startSoundBoard3(Stage soundBoard3Stage) {
		window = soundBoard3Stage;
		window.setTitle("SeaSlugs Sound Board");
		
		// Setting layout for SoundBoard1 and creating new scene
		Pane soundBoard3Layout = new Pane();
		soundBoard3Layout.setPadding(new Insets(10, 10, 10, 10));
		Scene soundBoard3Scene = new Scene(soundBoard3Layout, 700, 400);
		soundBoard3Layout.setStyle("-fx-background-color: #FFF;");
		
		soundBoard3Stage.setScene(soundBoard3Scene);
		soundBoard3Stage.show();
		
		// Adding Seaslugs logo
		final Image logo = new Image("logo.png", 100, 100, true, true);
		ImageView logoView = new ImageView(logo);
		
		// Adding Back Button
		Button backButton = new Button();
		backButton.setText("BACK");
		backButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		
		
		// Creating background for main splash text to clash with.
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.AQUA);
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.BLUE);
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		// Create Button Elements for Main Scene
		
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #547AE0");
		
		Random randomSound = new Random();
		
		backButton.setOnAction(e -> {
			try {
				start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(randomSound.nextInt((14 - 10) + 1) + 10));
		
		Button sound1 = new Button();
		sound1.setText("Animal Sound 1");
		sound1.setOnAction(e -> SoundTest.randomSound(10));
		sound1.getStyleClass().add("SoundBoardButtons");
		
		Button sound2 = new Button();
		sound2.setText("Animal Sound 2");
		sound2.setOnAction(e -> SoundTest.randomSound(11));
		sound2.getStyleClass().add("SoundBoardButtons");
		
		Button sound3 = new Button();
		sound3.setText("Animal Sound 3");
		sound3.setOnAction(e -> SoundTest.randomSound(12));
		sound3.getStyleClass().add("SoundBoardButtons");
		
		Button sound4 = new Button();
		sound4.setText("Animal Sound 4");
		sound4.setOnAction(e -> SoundTest.randomSound(13));
		sound4.getStyleClass().add("SoundBoardButtons");
		
		Button sound5 = new Button();
		sound5.setText("Animal Sound 5");
		sound5.setOnAction(e -> SoundTest.randomSound(14));
		sound5.getStyleClass().add("SoundBoardButtons");
		
		sound1.relocate(200, 150);
		sound2.relocate(400, 150);
		sound3.relocate(100, 250);
		sound4.relocate(300, 250);
		sound5.relocate(500, 250);
		backButton.relocate(600, 350);
		randomSoundButton.relocate(10, 350);
		mainSplash.relocate(200, -410);
		mainSplashBackground.relocate(0, 0);
		logoView.relocate(50, -10);
		
		
		// Adding all Children to the Scene.
		soundBoard3Layout.getChildren().addAll(sound1, sound2, sound3, sound4, sound5, randomSoundButton, mainSplashBackground, mainSplash, backButton, logoView);
		soundBoard3Scene.getStylesheets().add("styles.css");
	}
	
	private void startSoundBoard4(Stage soundBoard4Stage) {
		window = soundBoard4Stage;
		window.setTitle("SeaSlugs Sound Board");
		
		// Setting layout for SoundBoard1 and creating new scene
		Pane soundBoard4Layout = new Pane();
		soundBoard4Layout.setPadding(new Insets(10, 10, 10, 10));
		Scene soundBoard4Scene = new Scene(soundBoard4Layout, 700, 400);
		soundBoard4Layout.setStyle("-fx-background-color: #FFF;");
		
		soundBoard4Stage.setScene(soundBoard4Scene);
		soundBoard4Stage.show();
		
		// Adding Seaslugs logo
		final Image logo = new Image("logo.png", 100, 100, true, true);
		ImageView logoView = new ImageView(logo);
		
		// Adding Back Button
		Button backButton = new Button();
		backButton.setText("BACK");
		backButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		
		
		// Creating background for main splash text to clash with.
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.AQUA);
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.BLUE);
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		// Create Button Elements for Main Scene
		
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #547AE0");
		
		Random randomSound = new Random();
		
		backButton.setOnAction(e -> {
			try {
				start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(randomSound.nextInt((19 - 15) + 1) + 15));
		
		Button sound1 = new Button();
		sound1.setText("Fart 1");
		sound1.setOnAction(e -> SoundTest.randomSound(15));
		sound1.getStyleClass().add("SoundBoardButtons");
		
		Button sound2 = new Button();
		sound2.setText("Fart 2");
		sound2.setOnAction(e -> SoundTest.randomSound(16));
		sound2.getStyleClass().add("SoundBoardButtons");
		
		Button sound3 = new Button();
		sound3.setText("Fart 3");
		sound3.setOnAction(e -> SoundTest.randomSound(17));
		sound3.getStyleClass().add("SoundBoardButtons");
		
		Button sound4 = new Button();
		sound4.setText("Fart 4");
		sound4.setOnAction(e -> SoundTest.randomSound(18));
		sound4.getStyleClass().add("SoundBoardButtons");
		
		Button sound5 = new Button();
		sound5.setText("Fart 5");
		sound5.setOnAction(e -> SoundTest.randomSound(19));
		sound5.getStyleClass().add("SoundBoardButtons");
		
		sound1.relocate(200, 150);
		sound2.relocate(400, 150);
		sound3.relocate(100, 250);
		sound4.relocate(300, 250);
		sound5.relocate(500, 250);
		backButton.relocate(600, 350);
		randomSoundButton.relocate(10, 350);
		mainSplash.relocate(200, -410);
		mainSplashBackground.relocate(0, 0);
		logoView.relocate(50, -10);
		
		
		// Adding all Children to the Scene.
		soundBoard4Layout.getChildren().addAll(sound1, sound2, sound3, sound4, sound5, randomSoundButton, mainSplashBackground, mainSplash, backButton, logoView);
		soundBoard4Scene.getStylesheets().add("styles.css");
	}
	
	
	private void startSoundBoard5(Stage soundBoard5Stage) {
		window = soundBoard5Stage;
		window.setTitle("SeaSlugs Sound Board");
		
		// Setting layout for SoundBoard1 and creating new scene
		Pane soundBoard5Layout = new Pane();
		soundBoard5Layout.setPadding(new Insets(10, 10, 10, 10));
		Scene soundBoard5Scene = new Scene(soundBoard5Layout, 700, 400);
		soundBoard5Layout.setStyle("-fx-background-color: #FFF;");
		
		soundBoard5Stage.setScene(soundBoard5Scene);
		soundBoard5Stage.show();
		
		// Adding Seaslugs logo
		final Image logo = new Image("logo.png", 100, 100, true, true);
		ImageView logoView = new ImageView(logo);
		
		// Adding Back Button
		Button backButton = new Button();
		backButton.setText("BACK");
		backButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		
		
		// Creating background for main splash text to clash with.
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.AQUA);
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.BLUE);
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		// Create Button Elements for Main Scene
		
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #547AE0");
		
		Random randomSound = new Random();
		
		backButton.setOnAction(e -> {
			try {
				start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(randomSound.nextInt((24 - 20) + 1) + 20));
		
		Button sound1 = new Button();
		sound1.setText("Blastwave 1");
		sound1.setOnAction(e -> SoundTest.randomSound(20));
		sound1.getStyleClass().add("SoundBoardButtons");
		
		Button sound2 = new Button();
		sound2.setText("Blastwave 2");
		sound2.setOnAction(e -> SoundTest.randomSound(21));
		sound2.getStyleClass().add("SoundBoardButtons");
		
		Button sound3 = new Button();
		sound3.setText("Blastwave 3");
		sound3.setOnAction(e -> SoundTest.randomSound(22));
		sound3.getStyleClass().add("SoundBoardButtons");
		
		Button sound4 = new Button();
		sound4.setText("Blastwave 4");
		sound4.setOnAction(e -> SoundTest.randomSound(23));
		sound4.getStyleClass().add("SoundBoardButtons");
		
		Button sound5 = new Button();
		sound5.setText("Blastwave 5");
		sound5.setOnAction(e -> SoundTest.randomSound(24));
		sound5.getStyleClass().add("SoundBoardButtons");
		
		sound1.relocate(200, 150);
		sound2.relocate(400, 150);
		sound3.relocate(100, 250);
		sound4.relocate(300, 250);
		sound5.relocate(500, 250);
		backButton.relocate(600, 350);
		randomSoundButton.relocate(10, 350);
		mainSplash.relocate(200, -410);
		mainSplashBackground.relocate(0, 0);
		logoView.relocate(50, -10);
		
		
		// Adding all Children to the Scene.
		soundBoard5Layout.getChildren().addAll(sound1, sound2, sound3, sound4, sound5, randomSoundButton, mainSplashBackground, mainSplash, backButton, logoView);
		soundBoard5Scene.getStylesheets().add("styles.css");
	}
	
}

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
		
		// Adding soundboard icons
		final Image greetingLogo = new Image("greeting.png", 100, 100, true, true);
		ImageView greetingView = new ImageView(greetingLogo);
				
		final Image scaryLogo = new Image("skull.png", 100, 100, true, true);
		ImageView scaryView = new ImageView(scaryLogo);
			
		final Image animalLogo = new Image("alpaca.png", 100, 100, true, true);
		ImageView alapacaView = new ImageView(animalLogo);
				
		final Image dogLogo = new Image("doge.png", 120, 120, true, true);
		ImageView dogView = new ImageView(dogLogo);
				
		final Image hornLogo = new Image("horn.png", 100, 100, true, true);
		ImageView hornView = new ImageView(hornLogo);
				
		final Image blastwaveLogo = new Image("explosion.png", 100, 100, true, true);
		ImageView blastwaveView = new ImageView(blastwaveLogo);
				
		final Image fartLogo = new Image("fart.png", 90, 90, true, true);
		ImageView fartView = new ImageView(fartLogo);
		
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
		// Call stop method from SoundTest to stop current sound.
		stopButton.setOnAction(e -> SoundTest.stopSound());
		
		// Creating background for main splash text to clash with.
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.rgb(39, 100, 160, .99));
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.rgb(161,210,242,.99));
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		logoView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> SoundTest.randomSound(25));
		greetingView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> startSoundBoard1(window));
		scaryView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> startSoundBoard2(window));
		alapacaView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> startSoundBoard3(window));
		dogView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> startSoundBoard7(window));
		hornView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> startSoundBoard6(window));
		blastwaveView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> startSoundBoard5(window));
		fartView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> startSoundBoard4(window));
		
		// Create Button Elements for Main Scene
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #619DC8");
		
		Button aboutUsButton = new Button();
		aboutUsButton.setText("About Us");
		aboutUsButton.setStyle("-fx-font: 22 arial; -fx-base: #619DC8");
		aboutUsButton.setOnAction(e -> aboutUs(window));
		
		Random randomSound = new Random();
		
		closeButton.setOnAction(e -> closeProgram());
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(randomSound.nextInt(31)));
		
		// Position elements in the scene and add them to the scene.
		layoutMain.getChildren().addAll(hornView, dogView, scaryView, fartView, blastwaveView, greetingView, alapacaView, mainSplashBackground, logoView, stopButton ,closeButton, aboutUsButton, randomSoundButton, mainSplash);
		closeButton.relocate(650, 350);
		stopButton.relocate(450, 350);
		aboutUsButton.relocate(200, 350);
		randomSoundButton.relocate(25, 350);
		mainSplash.relocate(200, -410);
		mainSplashBackground.relocate(0, 0);
		greetingView.relocate(100, 120);
		scaryView.relocate(280, 120);
		alapacaView.relocate(460, 120);
		dogView.relocate(540, 230);
		hornView.relocate(370, 250);
		blastwaveView.relocate(200, 235);
		fartView.relocate(30, 250);
		logoView.relocate(50, -10);
		
		// Main window layout
		Scene mainScene = new Scene(layoutMain, 700, 400);
		primaryStage.setScene(mainScene);
		primaryStage.show();
		mainScene.getStylesheets().add("styles.css");
		primaryStage.getIcons().add(new Image("logo.png"));
		primaryStage.setResizable(false);
		
	}

	private void aboutUs(Stage aboutUsStage) {
		window = aboutUsStage;
		window.setTitle("SeaSlugs Sound Board - About Us");
		
		// Setting layout for SoundBoard1 and creating new scene
		Pane aboutUsLayout = new Pane();
		aboutUsLayout.setPadding(new Insets(10, 10, 10, 10));
		Scene aboutUsScene = new Scene(aboutUsLayout, 700, 1000);
		aboutUsLayout.setStyle("-fx-background-color: #FFF;");
		
		aboutUsStage.setScene(aboutUsScene);
		aboutUsStage.show();
		
		// Adding Seaslugs logo
		final Image logo = new Image("logo.png", 100, 100, true, true);
		ImageView logoView = new ImageView(logo);
		
		// Adding Back Button
		Button backButton = new Button();
		backButton.setText("BACK");
		backButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		
		
		// Creating background for main splash text to clash with.
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.rgb(39, 100, 160, .99));
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.rgb(161,210,242,.99));
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		// Creating About us Text / Images
		Text dieter = new Text();
		dieter.setText("Dieter Frank: In college for an IT degree with a \n" + 
		"double major in Software Development \n" +
		" and Mobile Development. Hobbies include \n" +
		"video games and Dungeons & Dragons Youtube \n" +
		"channel 'Downstairs N' Dragons'.  I \n" +
		"also collect funny hats and hourglasses.");
		dieter.setFill(Color.rgb(0,0,0));
		dieter.setFont(Font.font(null, FontWeight.BOLD, 12));
		
		final Image dieterLogo = new Image("dieter.jpg", 120, 120, true, true);
		ImageView dieterView = new ImageView(dieterLogo);
		
		Text connor = new Text();
		connor.setText("Connor Gharrity: Pending my final grade \n" +
		"in this class, there is only one \n" +  
		"class between me and graduation. I spend way \n" + 
		"too much time and probably money feeding my \n" +
		"gaming habits. Went to Blizzcon once, spent too \n" +
		"much, that was neat.");
		connor.setFill(Color.rgb(0,0,0));
		connor.setFont(Font.font(null, FontWeight.BOLD, 12));
		
		final Image connorLogo = new Image("connor.jpg", 120, 120, true, true);
		ImageView connorView = new ImageView(connorLogo);
		
		Text nick = new Text();
		nick.setText("Nicholas LaBelle: In pursuit of a IT associates \n" +
		"degree for Mobile and for Software Development. \n" +  
		"Hobbies include video games and Linux meddling. \n" + 
		"too much time and probably money feeding my \n" +
		"I also built my own PC and like the sound of \n" +
		"buckling springs.");
		nick.setFill(Color.rgb(0,0,0));
		nick.setFont(Font.font(null, FontWeight.BOLD, 12));
		
		final Image nickLogo = new Image("nick.png", 120, 120, true, true);
		ImageView nickView = new ImageView(nickLogo);
		
		Text kyle = new Text();
		kyle.setText("Kyle Piper: Kyle is in his final semester in \n" +
		"the IT - Software Developmen Program. He \n" +  
		"works tech support for an online software \n" + 
		"developer and is hoping to get a developer \n" +
		"position there after he finishes his degree. \n" +
		"In his spare time, he likes to play guitar, \n" +
		"read comics, and play video games.");
		kyle.setFill(Color.rgb(0,0,0));
		kyle.setFont(Font.font(null, FontWeight.BOLD, 12));
		
		final Image kyleLogo = new Image("kyle.jpg", 170, 170, true, true);
		ImageView kyleView = new ImageView(kyleLogo);
		
		Text tyler = new Text();
		tyler.setText("Tyler Herrmann: Fourth Semester software development \n" +
		"student at Chippewa Valley Technical College, starting \n" +  
		"in the Computer Science program at the University \n" + 
		"of Eau Claire starting in the Fall of 2017. Originally \n" +
		"from Philadelphia, PA a die hard fan of the Philadelphia  \n" +
		"Flyers and a lover of anything technology related.");
		tyler.setFill(Color.rgb(0,0,0));
		tyler.setFont(Font.font(null, FontWeight.BOLD, 12));
		
		final Image tylerLogo = new Image("tyler.jpg", 110, 110, true, true);
		ImageView tylerView = new ImageView(tylerLogo);
		
		Text tristin = new Text();
		tristin.setText("Tristin Nelson: I am going for Associate degrees \n" +
		"in both the IT Software and IT Mobile Develper \n" +  
		"programs. For hobbies I like playing most \n" + 
		"video games and playing DnD. I like making \n" +
		"jokes and finding new memes.");
		tristin.setFill(Color.rgb(0,0,0));
		tristin.setFont(Font.font(null, FontWeight.BOLD, 12));
		
		final Image tristinLogo = new Image("tristin.jpg", 110, 110, true, true);
		ImageView tristinView = new ImageView(tristinLogo);
		
		Text josh = new Text();
		josh.setText("Josh Prueher: Currently in final semester seeking a \n" +
		"software development degree. Hobbies include watching \n" +  
		"sports, playing video games with my kids, \n" + 
		"and trying any new beers I can find.");
		josh.setFill(Color.rgb(0,0,0));
		josh.setFont(Font.font(null, FontWeight.BOLD, 12));
		
		backButton.setOnAction(e -> {
			try {
				start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		connor.relocate(375, 250);
		connorView.relocate(440, 120);
		dieter.relocate(30, 250);
		dieterView.relocate(130, 120);
		nick.relocate(30, 500);
		nickView.relocate(130, 370);
		kyle.relocate(375, 490);
		kyleView.relocate(400, 370);
		tyler.relocate(30, 750);
		tylerView.relocate(130, 630);
		tristin.relocate(375, 750);
		tristinView.relocate(440, 635);
		josh.relocate(30, 880);
		backButton.relocate(600, 950);
		mainSplash.relocate(200, -410);
		mainSplashBackground.relocate(0, 0);
		logoView.relocate(50, -10);
		
		// Adding all Children to the Scene.
		aboutUsLayout.getChildren().addAll(josh, tristin, tristinView, tyler, tylerView, kyle, kyleView, nick, nickView, connor, connorView, dieterView, dieter, mainSplashBackground, mainSplash, backButton, logoView);
		aboutUsScene.getStylesheets().add("styles.css");
		aboutUsStage.setResizable(false);
		
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
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.rgb(39, 100, 160, .99));
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.rgb(161,210,242,.99));
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		// Create Button Elements for Main Scene
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #619DC8");
		
		Random randomSound = new Random();
		
		backButton.setOnAction(e -> {
			try {
				start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(randomSound.nextInt(4)));
		
		Button stopButton = new Button();
		stopButton.setText("STOP");
		stopButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		// Call stop method from SoundTest to stop current sound.
		stopButton.setOnAction(e -> SoundTest.stopSound());
		stopButton.relocate(300, 350);
		
		Button sound1 = new Button();
		sound1.setText("Hi (Female)");
		sound1.setOnAction(e -> SoundTest.randomSound(0));
		sound1.getStyleClass().add("SoundBoardButtons");
		
		Button sound2 = new Button();
		sound2.setText("Hey Sweetness");
		sound2.setOnAction(e -> SoundTest.randomSound(1));
		sound2.getStyleClass().add("SoundBoardButtons");
		
		Button sound3 = new Button();
		sound3.setText("Hello (Male)");
		sound3.setOnAction(e -> SoundTest.randomSound(2));
		sound3.getStyleClass().add("SoundBoardButtons");
		
		Button sound4 = new Button();
		sound4.setText("Hi Cutiepie");
		sound4.setOnAction(e -> SoundTest.randomSound(3));
		sound4.getStyleClass().add("SoundBoardButtons");
		
		Button sound5 = new Button();
		sound5.setText("Hello Echo");
		sound5.setOnAction(e -> SoundTest.randomSound(4));
		sound5.getStyleClass().add("SoundBoardButtons");
		
		sound1.relocate(200, 150);
		sound2.relocate(300, 250);
		sound3.relocate(100, 250);
		sound4.relocate(400, 150);
		sound5.relocate(500, 250);
		backButton.relocate(600, 350);
		randomSoundButton.relocate(10, 350);
		mainSplash.relocate(200, -410);
		mainSplashBackground.relocate(0, 0);
		logoView.relocate(50, -10);
		
		
		// Adding all Children to the Scene.
		soundBoard1Layout.getChildren().addAll(stopButton, sound1, sound2, sound3, sound4, sound5, randomSoundButton, mainSplashBackground, mainSplash, backButton, logoView);
		soundBoard1Scene.getStylesheets().add("styles.css");
		soundBoard1Stage.setResizable(false);
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
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.rgb(39, 100, 160, .99));
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.rgb(161,210,242,.99));
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		// Create Button Elements for Main Scene
		
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #619DC8");
		
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
		
		Button stopButton = new Button();
		stopButton.setText("STOP");
		stopButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		// Call stop method from SoundTest to stop current sound.
		stopButton.setOnAction(e -> SoundTest.stopSound());
		stopButton.relocate(300, 350);
		
		Button sound1 = new Button();
		sound1.setText("Spooky Music");
		sound1.setOnAction(e -> SoundTest.randomSound(5));
		sound1.getStyleClass().add("SoundBoardButtons");
		
		Button sound2 = new Button();
		sound2.setText("Scary Laugh");
		sound2.setOnAction(e -> SoundTest.randomSound(6));
		sound2.getStyleClass().add("SoundBoardButtons");
		
		Button sound3 = new Button();
		sound3.setText("Electricity");
		sound3.setOnAction(e -> SoundTest.randomSound(7));
		sound3.getStyleClass().add("SoundBoardButtons");
		
		Button sound4 = new Button();
		sound4.setText("Scary Roar");
		sound4.setOnAction(e -> SoundTest.randomSound(8));
		sound4.getStyleClass().add("SoundBoardButtons");
		
		Button sound5 = new Button();
		sound5.setText("Monster Chat");
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
		soundBoard2Layout.getChildren().addAll(stopButton, sound1, sound2, sound3, sound4, sound5, randomSoundButton, mainSplashBackground, mainSplash, backButton, logoView);
		soundBoard2Scene.getStylesheets().add("styles.css");
		soundBoard2Stage.setResizable(false);
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
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.rgb(39, 100, 160, .99));
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.rgb(161,210,242,.99));
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		// Create Button Elements for Main Scene
		
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #619DC8");
		
		Random randomSound = new Random();
		
		backButton.setOnAction(e -> {
			try {
				start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(randomSound.nextInt((14 - 10) + 1) + 10));
		
		Button stopButton = new Button();
		stopButton.setText("STOP");
		stopButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		// Call stop method from SoundTest to stop current sound.
		stopButton.setOnAction(e -> SoundTest.stopSound());
		stopButton.relocate(300, 350);
		
		Button sound1 = new Button();
		sound1.setText("Alpacas Making Noise");
		sound1.setOnAction(e -> SoundTest.randomSound(10));
		sound1.getStyleClass().add("SoundBoardButtons");
		
		Button sound2 = new Button();
		sound2.setText("Cat Meowing");
		sound2.setOnAction(e -> SoundTest.randomSound(11));
		sound2.getStyleClass().add("SoundBoardButtons");
		
		Button sound3 = new Button();
		sound3.setText("Crows");
		sound3.setOnAction(e -> SoundTest.randomSound(12));
		sound3.getStyleClass().add("SoundBoardButtons");
		
		Button sound4 = new Button();
		sound4.setText("Hawk Screeching");
		sound4.setOnAction(e -> SoundTest.randomSound(13));
		sound4.getStyleClass().add("SoundBoardButtons");
		
		Button sound5 = new Button();
		sound5.setText("Rooster");
		sound5.setOnAction(e -> SoundTest.randomSound(14));
		sound5.getStyleClass().add("SoundBoardButtons");
		
		sound1.relocate(300, 250);
		sound2.relocate(500, 250);
		sound3.relocate(400, 150);
		sound4.relocate(100, 250);
		sound5.relocate(200, 150);
		backButton.relocate(600, 350);
		randomSoundButton.relocate(10, 350);
		mainSplash.relocate(200, -410);
		mainSplashBackground.relocate(0, 0);
		logoView.relocate(50, -10);
		
		
		// Adding all Children to the Scene.
		soundBoard3Layout.getChildren().addAll(stopButton, sound1, sound2, sound3, sound4, sound5, randomSoundButton, mainSplashBackground, mainSplash, backButton, logoView);
		soundBoard3Scene.getStylesheets().add("styles.css");
		soundBoard3Stage.setResizable(false);
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
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.rgb(39, 100, 160, .99));
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.rgb(161,210,242,.99));
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		// Create Button Elements for Main Scene
		
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #619DC8");
		
		Random randomSound = new Random();
		
		backButton.setOnAction(e -> {
			try {
				start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(randomSound.nextInt((19 - 15) + 1) + 15));
		
		Button stopButton = new Button();
		stopButton.setText("STOP");
		stopButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		// Call stop method from SoundTest to stop current sound.
		stopButton.setOnAction(e -> SoundTest.stopSound());
		stopButton.relocate(300, 350);
		
		Button sound1 = new Button();
		sound1.setText("Dry Fart");
		sound1.setOnAction(e -> SoundTest.randomSound(15));
		sound1.getStyleClass().add("SoundBoardButtons");
		
		Button sound2 = new Button();
		sound2.setText("Quick Fart");
		sound2.setOnAction(e -> SoundTest.randomSound(16));
		sound2.getStyleClass().add("SoundBoardButtons");
		
		Button sound3 = new Button();
		sound3.setText("Squeeky Fart");
		sound3.setOnAction(e -> SoundTest.randomSound(17));
		sound3.getStyleClass().add("SoundBoardButtons");
		
		Button sound4 = new Button();
		sound4.setText("Wet Fart");
		sound4.setOnAction(e -> SoundTest.randomSound(18));
		sound4.getStyleClass().add("SoundBoardButtons");
		
		Button sound5 = new Button();
		sound5.setText("Duck Fart");
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
		soundBoard4Layout.getChildren().addAll(stopButton, sound1, sound2, sound3, sound4, sound5, randomSoundButton, mainSplashBackground, mainSplash, backButton, logoView);
		soundBoard4Scene.getStylesheets().add("styles.css");
		soundBoard4Stage.setResizable(false);
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
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.rgb(39, 100, 160, .99));
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.rgb(161,210,242,.99));
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		// Create Button Elements for Main Scene
		
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #619DC8");
		
		Random randomSound = new Random();
		
		backButton.setOnAction(e -> {
			try {
				start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(randomSound.nextInt((24 - 20) + 1) + 20));
		
		Button stopButton = new Button();
		stopButton.setText("STOP");
		stopButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		// Call stop method from SoundTest to stop current sound.
		stopButton.setOnAction(e -> SoundTest.stopSound());
		stopButton.relocate(300, 350);
		
		Button sound1 = new Button();
		sound1.setText("Gas Explosion");
		sound1.setOnAction(e -> SoundTest.randomSound(20));
		sound1.getStyleClass().add("SoundBoardButtons");
		
		Button sound2 = new Button();
		sound2.setText("Car Explosion");
		sound2.setOnAction(e -> SoundTest.randomSound(21));
		sound2.getStyleClass().add("SoundBoardButtons");
		
		Button sound3 = new Button();
		sound3.setText("Explosion w/ Debris");
		sound3.setOnAction(e -> SoundTest.randomSound(22));
		sound3.getStyleClass().add("SoundBoardButtons");
		
		Button sound4 = new Button();
		sound4.setText("Explosion w/ Metal");
		sound4.setOnAction(e -> SoundTest.randomSound(23));
		sound4.getStyleClass().add("SoundBoardButtons");
		
		Button sound5 = new Button();
		sound5.setText("Quick Explosion");
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
		soundBoard5Layout.getChildren().addAll(stopButton, sound1, sound2, sound3, sound4, sound5, randomSoundButton, mainSplashBackground, mainSplash, backButton, logoView);
		soundBoard5Scene.getStylesheets().add("styles.css");
		soundBoard5Stage.setResizable(false);
	}
	
	
	private void startSoundBoard6(Stage soundBoard6Stage) {
		window = soundBoard6Stage;
		window.setTitle("SeaSlugs Sound Board");
		
		// Setting layout for SoundBoard1 and creating new scene
		Pane soundBoard6Layout = new Pane();
		soundBoard6Layout.setPadding(new Insets(10, 10, 10, 10));
		Scene soundBoard6Scene = new Scene(soundBoard6Layout, 700, 400);
		soundBoard6Layout.setStyle("-fx-background-color: #FFF;");
		
		soundBoard6Stage.setScene(soundBoard6Scene);
		soundBoard6Stage.show();
		
		// Adding Seaslugs logo
		final Image logo = new Image("logo.png", 100, 100, true, true);
		ImageView logoView = new ImageView(logo);
		
		// Adding Back Button
		Button backButton = new Button();
		backButton.setText("BACK");
		backButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		
		
		// Creating background for main splash text to clash with.
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.rgb(39, 100, 160, .99));
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.rgb(161,210,242,.99));
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		// Create Button Elements for Main Scene
		
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #619DC8");
		
		Random randomSound = new Random();
		
		backButton.setOnAction(e -> {
			try {
				start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(randomSound.nextInt((30 - 26) + 1) + 26));
		
		Button stopButton = new Button();
		stopButton.setText("STOP");
		stopButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		// Call stop method from SoundTest to stop current sound.
		stopButton.setOnAction(e -> SoundTest.stopSound());
		stopButton.relocate(300, 350);
		
		Button sound1 = new Button();
		sound1.setText("Sports Horn");
		sound1.setOnAction(e -> SoundTest.randomSound(26));
		sound1.getStyleClass().add("SoundBoardButtons");
		
		Button sound2 = new Button();
		sound2.setText("Car Horn");
		sound2.setOnAction(e -> SoundTest.randomSound(27));
		sound2.getStyleClass().add("SoundBoardButtons");
		
		Button sound3 = new Button();
		sound3.setText("High Horn");
		sound3.setOnAction(e -> SoundTest.randomSound(28));
		sound3.getStyleClass().add("SoundBoardButtons");
		
		Button sound4 = new Button();
		sound4.setText("Air Horn");
		sound4.setOnAction(e -> SoundTest.randomSound(29));
		sound4.getStyleClass().add("SoundBoardButtons");
		
		Button sound5 = new Button();
		sound5.setText("Boat Horn");
		sound5.setOnAction(e -> SoundTest.randomSound(30));
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
		soundBoard6Layout.getChildren().addAll(stopButton, sound1, sound2, sound3, sound4, sound5, randomSoundButton, mainSplashBackground, mainSplash, backButton, logoView);
		soundBoard6Scene.getStylesheets().add("styles.css");
		soundBoard6Stage.setResizable(false);
	}
	
	private void startSoundBoard7(Stage soundBoard7Stage) {
		window = soundBoard7Stage;
		window.setTitle("SeaSlugs Sound Board");
		
		// Setting layout for SoundBoard1 and creating new scene
		Pane soundBoard7Layout = new Pane();
		soundBoard7Layout.setPadding(new Insets(10, 10, 10, 10));
		Scene soundBoard7Scene = new Scene(soundBoard7Layout, 700, 400);
		soundBoard7Layout.setStyle("-fx-background-color: #FFF;");
		
		soundBoard7Stage.setScene(soundBoard7Scene);
		soundBoard7Stage.show();
		
		// Adding Seaslugs logo
		final Image logo = new Image("logo.png", 100, 100, true, true);
		ImageView logoView = new ImageView(logo);
		
		// Adding Back Button
		Button backButton = new Button();
		backButton.setText("BACK");
		backButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		
		
		// Creating background for main splash text to clash with.
		Rectangle mainSplashBackground = new Rectangle(700,95, Color.rgb(39, 100, 160, .99));
		mainSplashBackground.toBack();
		
		// Creating the main splash text.
		Text mainSplash = new Text();
		
		mainSplash.setCache(true);
		mainSplash.setText("SeaSlugs SoundBoard");
		mainSplash.setFill(Color.rgb(161,210,242,.99));
		mainSplash.setFont(Font.font(null, FontWeight.BOLD, 44));
		
		Reflection r = new Reflection();
		r.setFraction(0.7f);
		 
		mainSplash.setEffect(r);
		 
		mainSplash.setTranslateY(400);
		
		// Create Button Elements for Main Scene
		
		randomSoundButton = new Button();
		randomSoundButton.setText("?");
		randomSoundButton.setStyle("-fx-font: 22 arial; -fx-base: #619DC8");
		
		Random randomSound = new Random();
		
		backButton.setOnAction(e -> {
			try {
				start(window);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		
		randomSoundButton.setOnAction(e -> SoundTest.randomSound(randomSound.nextInt((35 - 31) + 1) + 31));
		
		Button stopButton = new Button();
		stopButton.setText("STOP");
		stopButton.setStyle("-fx-font: 22 arial; -fx-base: #ff0000");
		// Call stop method from SoundTest to stop current sound.
		stopButton.setOnAction(e -> SoundTest.stopSound());
		stopButton.relocate(300, 350);
		
		Button sound1 = new Button();
		sound1.setText("Angry");
		sound1.setOnAction(e -> SoundTest.randomSound(31));
		sound1.getStyleClass().add("SoundBoardButtons");
		
		Button sound2 = new Button();
		sound2.setText("Bark");
		sound2.setOnAction(e -> SoundTest.randomSound(32));
		sound2.getStyleClass().add("SoundBoardButtons");
		
		Button sound3 = new Button();
		sound3.setText("Howl");
		sound3.setOnAction(e -> SoundTest.randomSound(33));
		sound3.getStyleClass().add("SoundBoardButtons");
		
		Button sound4 = new Button();
		sound4.setText("Whine");
		sound4.setOnAction(e -> SoundTest.randomSound(34));
		sound4.getStyleClass().add("SoundBoardButtons");
		
		Button sound5 = new Button();
		sound5.setText("Woof");
		sound5.setOnAction(e -> SoundTest.randomSound(35));
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
		soundBoard7Layout.getChildren().addAll(stopButton, sound1, sound2, sound3, sound4, sound5, randomSoundButton, mainSplashBackground, mainSplash, backButton, logoView);
		soundBoard7Scene.getStylesheets().add("styles.css");
		soundBoard7Stage.setResizable(false);
	}
	
}

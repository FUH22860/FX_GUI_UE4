package application;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class RootBorderPane extends BorderPane {
	
	private MenuBar menuBar;
	private Menu mDatei, mBearbeiten;
	private MenuItem miBeenden, miReset;
	
	private GridPane gpZentrum;
	
	private RadioButton rbDirekt, rbLeerzeichen, rbLeerzeile;
	
	private TextField tfText1, tfText2;
	private TextArea taErgebnis;
	
	private Button btVerbinden;
	
	public RootBorderPane() {
		initComponents();
		addComponents();
		addHandler();
	}

	private void initComponents() {
		String promptText = "Bitte einen Text eingeben...";
		
		menuBar = new MenuBar();
		mDatei = new Menu("Datei");
		mBearbeiten = new Menu("Bearbeiten");
		miBeenden = new MenuItem("Beenden");
		miReset = new MenuItem("Reset");
		
		gpZentrum = new GridPane();
			gpZentrum.setAlignment(Pos.CENTER);
		
		tfText1 = new TextField();
			tfText1.setPromptText(promptText);
		
		tfText2 = new TextField();
			tfText2.setPromptText(promptText);
		
		taErgebnis = new TextArea();
			taErgebnis.setDisable(true);
			taErgebnis.setEditable(false);
	}
	
	private void addComponents() {
		mDatei.getItems().addAll(miBeenden);
		mBearbeiten.getItems().addAll(miReset);
		menuBar.getMenus().addAll(mDatei, mBearbeiten);
		
		gpZentrum.add(new Label("Verbinden"), 0, 0);
		gpZentrum.add(new Label("Text 1"), 0, 3);
		gpZentrum.add(new Label("Text 2"), 0, 4);
		gpZentrum.add(new Label("Ergebnis:"), 0, 5);
		
		gpZentrum.add(tfText1, 1, 3);
		gpZentrum.add(tfText2, 1, 4);
		gpZentrum.add(taErgebnis, 1, 5);
		
		// TODO Button
		
		setTop(menuBar);
		setCenter(gpZentrum);
	}
	
	private void addHandler() {
		miBeenden.setOnAction(event -> { Platform.exit(); } );
	}
	
}

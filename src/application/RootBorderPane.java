package application;

import javafx.scene.control.Button;
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
	}

	private void initComponents() {
		menuBar = new MenuBar();
		mDatei = new Menu("Datei");
		mBearbeiten = new Menu("Bearbeiten");
		miBeenden = new MenuItem("Beenden");
		miReset = new MenuItem("Reset");
	}
	
	private void addComponents() {
		mDatei.getItems().addAll(miBeenden);
		mBearbeiten.getItems().addAll(miReset);
		menuBar.getMenus().addAll(mDatei, mBearbeiten);
		
		setTop(menuBar);
	}
	
}

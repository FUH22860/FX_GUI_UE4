package application;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;

public class RootFlowPane extends FlowPane {
	private CheckBox cb;
	private RadioButton rb1, rb2, rb3;
	private Button btOk, btBeenden;
	private ToggleGroup tgRadios;

	public RootFlowPane() {
		initComponents();
		addComponents();
		addHandlers();
	}

	private void initComponents() {
		cb = new CheckBox("Waehle mich");

		rb1 = new RadioButton("RB1");
		rb2 = new RadioButton("RB2");
		rb3 = new RadioButton("RB3");

		tgRadios = new ToggleGroup();

		btOk = new Button("OK");
		btOk.setPrefWidth(100);
		btBeenden = new Button("Beenden");
		btBeenden.setPrefWidth(100);

		setAlignment(Pos.CENTER);
		setHgap(20);
		setVgap(20);
	}

	private void addComponents() {
		tgRadios.getToggles().addAll(rb1, rb2, rb3);
		tgRadios.selectToggle(rb1);

		getChildren().addAll(cb, rb1, rb2, rb3, btOk, btBeenden);
	}

	private void addHandlers() {

		btOk.setOnAction(event -> okClicked());
		btBeenden.setOnAction(event -> beenden());

		setOnMouseClicked(event -> flowPaneClicked()); // this = RootFlowPane -> das sind wir
	}

	// ------------------------ handlers ---------------------

	private void okClicked() {

		StringBuilder sb = new StringBuilder();
		sb.append("Auswertung zu den Buttons:\n");
		sb.append("Checkbox ist ");
		if (!cb.isSelected())
			sb.append("nicht ");
		sb.append("selected;\n");

		sb.append("Ausgewaehlter RadioButton: ");
		RadioButton rbSelected = (RadioButton) tgRadios.getSelectedToggle();
		sb.append(rbSelected.getText());

		Main.showAlert(AlertType.INFORMATION, sb.toString());
	}

	private void beenden() {
		Platform.exit();
	}

	private void flowPaneClicked() {
		Main.showAlert(AlertType.WARNING, "Es wurde irgendwo ins Fenster mit der Maus geklickt");
	}
}

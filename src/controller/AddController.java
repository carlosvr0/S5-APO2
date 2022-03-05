package controller;


import java.time.LocalDate;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddController {
	private Main main;
	
	@FXML
	DatePicker datePicker;
	
	@FXML
	RadioButton radioBtnIngreso, radioBtnGasto;
	
	@FXML
	TextField textMonto;
	
	@FXML
	TextField textDescription;
	
	@FXML
	Button btnAdd;
		
	@FXML
	public void add(ActionEvent e) {
		LocalDate fecha = datePicker.getValue();
		String tipo = "";
		
		if(radioBtnIngreso.isSelected()) {
			tipo = "Ingreso";
		}else if(radioBtnGasto.isSelected()) {
			tipo = "Gasto";
		}	
		
		double monto = Double.parseDouble(textMonto.getText());
		String descripcion = textDescription.getText();
				
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmación para agregar");
		alert.setHeaderText("¿La información está correcta?");
		alert.setContentText("Recuerda que posteriormente no podrás cambiar la información");
				
		if(alert.showAndWait().get() == ButtonType.OK) {
			main.addToTable(fecha, tipo, monto, descripcion);			
		}
			
		main.actualizarLabels();
		
		Stage stage = (Stage) textDescription.getScene().getWindow();
		stage.close();

	}
	
	public void setMain(Main main) {
		this.main = main;
	}
}

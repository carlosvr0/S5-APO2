package controller;

import java.io.IOException;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Finanzas;
import model.FinanzasData;

public class PrincipalController {
	
	private Main main;
	
	@FXML
	TableView<Finanzas> table;
	@FXML
	TableColumn<Finanzas, Double> moneyColumn;
	@FXML
	TableColumn<Finanzas, String> descreptionColumn;
	@FXML
	TableColumn<Finanzas, DatePicker> dateColumn;
	@FXML
	TableColumn<Finanzas, RadioButton> typeColumn; 
	
	@FXML
	Label labelToShowBalance;
	@FXML
	Label labelToShowIngresos;
	@FXML
	Label labelToShowGastos;
	
	
	public void initialize() {
		dateColumn.setCellValueFactory(new PropertyValueFactory<Finanzas, DatePicker>("date"));
		typeColumn.setCellValueFactory(new PropertyValueFactory<Finanzas, RadioButton>("tipo"));
		moneyColumn.setCellValueFactory(new PropertyValueFactory<Finanzas, Double>("monto"));
		descreptionColumn.setCellValueFactory(new PropertyValueFactory<Finanzas, String>("description"));
		
		table.setItems(FinanzasData.dataFinanzas);
		setSumasToLabels();
	}
	
	
	public void setSumasToLabels() {
		String income = "" + FinanzasData.getSumasFinanzas()[0];
		String expenses = "" + FinanzasData.getSumasFinanzas()[1];
		String balance = "" + FinanzasData.getSumasFinanzas()[2];
		labelToShowBalance.setText(balance);
		labelToShowIngresos.setText(income);
		labelToShowGastos.setText(expenses);
	}
	
	@FXML
	public void openAddForm(ActionEvent event)throws IOException  {
		main.showAddForm();
	}
	
	@FXML
	public void openDateRangeForm() {
		if(FinanzasData.dataFinanzas.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Tabla de finanzas vacia");
			alert.setHeaderText("Error");
			alert.setContentText("No hay contenido en la tabla de finanzas");
			alert.show();
		}else {
			main.showDateRangeForm();
		}
	}
	
	
	@FXML
	public void remove(ActionEvent event) {
		int selectedFinance = table.getSelectionModel().getSelectedIndex();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Eliminar informarción de la tabla");
		alert.setHeaderText("Mensaje");
		alert.setContentText("¿Estas seguro que quieres eliminar esta información?");
		
		if(alert.showAndWait().get() == ButtonType.OK) {
			table.getItems().remove(selectedFinance);
			main.removeItem(selectedFinance);
		}
	}
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	@FXML
	void exit(ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}

}

package controller;

import java.time.LocalDate;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Finanzas;
import model.FinanzasData;

public class FinanceWithDateRangeController {
	
	private Main main;
	
	@FXML
	Label firstDateToShow;
	@FXML
	Label secondDateToShow;
	
	@FXML
	Label balanceWithDateRange;
	@FXML
	Label ingresosWithDateRange;
	@FXML
	Label gastosWithDateRange;
	
	@FXML
	TableView<Finanzas> tableWithDateRange;
	@FXML
	TableColumn<Finanzas, Double> moneyColumnDateR;
	@FXML
	TableColumn<Finanzas, String> descreptionColumnDateR;
	@FXML
	TableColumn<Finanzas, DatePicker> dateColumnDateR;
	@FXML
	TableColumn<Finanzas, RadioButton> typeColumnDateR; 
	
	
	public void initialize() {
		dateColumnDateR.setCellValueFactory(new PropertyValueFactory<Finanzas, DatePicker>("date"));
		typeColumnDateR.setCellValueFactory(new PropertyValueFactory<Finanzas, RadioButton>("tipo"));
		moneyColumnDateR.setCellValueFactory(new PropertyValueFactory<Finanzas, Double>("monto"));
		descreptionColumnDateR.setCellValueFactory(new PropertyValueFactory<Finanzas, String>("description"));
		
		tableWithDateRange.setItems(FinanzasData.dataFinanzasWithDateRange);
		setSumasToLabelsWithDR();
	}
	
	public void setSumasToLabelsWithDR() {
		String income = "" + FinanzasData.getSumasFinanzasWithDateRange()[0];
		String expenses = "" + FinanzasData.getSumasFinanzasWithDateRange()[1];
		String balance = "" + FinanzasData.getSumasFinanzasWithDateRange()[2];
		balanceWithDateRange.setText(balance);
		ingresosWithDateRange.setText(income);
		gastosWithDateRange.setText(expenses);
	}
	
	public  void setDatesToShow(LocalDate firstD, LocalDate secondD) {	
		firstDateToShow.setText(firstD.toString());
		secondDateToShow.setText(secondD.toString());
	}
	
	
	
	
	public void setMain(Main main) {
		this.main = main;
	}
	
}

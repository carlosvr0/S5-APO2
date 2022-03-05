package controller;


import java.io.IOException;
import java.time.LocalDate;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class DateRangeController {
	
	private Main main;
	
	@FXML
	DatePicker firstDateSelected;
	
	@FXML
	DatePicker secondDateSelected;

	@FXML
	Button btnAceptTwoDates;

	
	@FXML
	public void makeRange() throws IOException {
		LocalDate firstD = firstDateSelected.getValue();
		LocalDate secondD = secondDateSelected.getValue();
		
		main.showFinancesWithDateRange(firstD, secondD);
		Stage stage = (Stage) btnAceptTwoDates.getScene().getWindow(); 
		//main.cleanObservableList();
		stage.close();
	}
	
	
	public void setMain(Main main) {
		this.main = main;
	}
}

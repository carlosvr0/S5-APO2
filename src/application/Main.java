package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.FinanzasData;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.time.LocalDate;

import controller.AddController;
import controller.DateRangeController;
import controller.FinanceWithDateRangeController;
import controller.PrincipalController;

public class Main extends Application {
	
	private PrincipalController principalController;
	private AddController addController;
	private DateRangeController dateRangeController;
	private FinanceWithDateRangeController financeController;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage){
		
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Sample.fxml"));
			BorderPane root = loader.load();
			
			principalController = loader.getController();
			principalController.setMain(this);
			
			stage.setTitle("Seguimiento 5 - Finanzas");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showAddForm() {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/Add.fxml"));
			BorderPane root = loader.load();
			
			addController = loader.getController();
			addController.setMain(this);
			
			stage.setTitle("Añadir item a la lista");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addToTable(LocalDate fecha, String tipo, double monto, String descripcion) {
		FinanzasData.addItem(fecha, tipo, monto, descripcion);
	}
	
	public void actualizarLabels() {
		principalController.setSumasToLabels();
	}

	public void removeItem(int selectedFinance) {
		FinanzasData.removeItemFromList(selectedFinance);
		principalController.setSumasToLabels();
	}
	
	
	public void showDateRangeForm() {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/SelectDates.fxml"));
			BorderPane root = loader.load();
			
			dateRangeController = loader.getController();
			dateRangeController.setMain(this);
			
			stage.setTitle("Escoger rango de fechas");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showFinancesWithDateRange(LocalDate firstD, LocalDate secondD) {
		try {
			Stage stage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/DateRangeItems.fxml"));//tabla con el rango de fechas
			BorderPane root = loader.load();
			
			financeController = loader.getController();
			financeController.setMain(this);
			financeController.setDatesToShow(firstD, secondD);
			FinanzasData.fillNewFinanzasItemWithDateRange(firstD, secondD);
			FinanzasData.getSumasFinanzasWithDateRange();
			financeController.setSumasToLabelsWithDR();
			
			
			stage.setTitle("Finanzas en un rango de fechas");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cleanObservableList() {
		FinanzasData.dataFinanzasWithDateRange.clear();
	}
}
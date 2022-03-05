package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FinanzasData {
	public static List<Finanzas> listFinanzas = new ArrayList<Finanzas>();
			
	public static ObservableList<Finanzas> dataFinanzas = FXCollections.observableArrayList();
	public static ObservableList<Finanzas> dataFinanzasWithDateRange = FXCollections.observableArrayList();
	
	public static void addItem(LocalDate fecha, String tipo, double monto, String descripcion) {
		Finanzas newItem = new Finanzas(fecha, tipo, monto, descripcion);
		dataFinanzas.add(newItem);
		listFinanzas.add(newItem);
	}
	
	
	public static double[] getSumasFinanzas(){
		
		double[] sumas = new double[3]; //0: ingresos - 1: gastos - 2: balance		
		
		for(int m = 0; m < listFinanzas.size(); m++) {
			if(listFinanzas.get(m).getTipo().equals("Ingreso")) {
				sumas[0] += listFinanzas.get(m).getMonto();
			}else if(listFinanzas.get(m).getTipo().equals("Gasto")) {
				sumas[1] += listFinanzas.get(m).getMonto();
			}
		}
		
		sumas[2] = sumas[0] - sumas[1];
		
		return sumas;
	}
	
	
	public static void fillNewFinanzasItemWithDateRange(LocalDate firstD, LocalDate secondD) {
		
		for(int m = 0; m < dataFinanzas.size(); m++) {
			if((dataFinanzas.get(m).getDate().isEqual(firstD) || dataFinanzas.get(m).getDate().isAfter(firstD)) && (dataFinanzas.get(m).getDate().isEqual(secondD) || dataFinanzas.get(m).getDate().isBefore(secondD))) {
				dataFinanzasWithDateRange.add(dataFinanzas.get(m));
			}
		}
	}
	
	public static double[] getSumasFinanzasWithDateRange(){
		
		double[] sumasDR = new double[3]; //0: ingresos - 1: gastos - 2: balance		
		
		for(int m = 0; m < dataFinanzasWithDateRange.size(); m++) {
			if(dataFinanzasWithDateRange.get(m).getTipo().equals("Ingreso")) {
				sumasDR[0] += dataFinanzasWithDateRange.get(m).getMonto();
			}else if(dataFinanzasWithDateRange.get(m).getTipo().equals("Gasto")) {
				sumasDR[1] += dataFinanzasWithDateRange.get(m).getMonto();
			}
		}
		
		sumasDR[2] = sumasDR[0] - sumasDR[1];
		
		return sumasDR;
	}
	
	
	public static void removeItemFromList(int posicion) {
		listFinanzas.remove(posicion);
	}
}

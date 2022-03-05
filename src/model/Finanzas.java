package model;

import java.time.LocalDate;

public class Finanzas {
	private double monto;
	private String description;
	private LocalDate date;
	private String tipo;
	
	public Finanzas(LocalDate date, String tipo, double monto, String description) {
		this.date = date;
		this.tipo = tipo;
		this.monto = monto;
		this.description = description;
	}

	
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}

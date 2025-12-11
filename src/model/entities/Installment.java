package model.entities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Installment {
	
	private LocalDate dueDate; 
	private Double amount;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Installment(LocalDate dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return sdf.format(dueDate) +" - "+ String.format("%.2f%n", amount);
	} 
	
	
	
}
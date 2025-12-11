package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

	private Integer number; 
	private LocalDate date;
	private Double valueContract;
	
	private List<Installment> installment = new ArrayList<>(); 
	
	public Contract(){}

	public Contract(Integer number, LocalDate date, Double valueContract) {
		this.number = number;
		this.date = date;
		this.valueContract = valueContract;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getValueContract() {
		return valueContract;
	}

	public void setValueContract(Double valueContract) {
		this.valueContract = valueContract;
	}

	public List<Installment> getInstallment() {
		return installment;
	}

}
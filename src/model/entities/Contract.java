package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	private Integer number; 
	private Date date;
	private Double valueContract;
	
	private List<Installment> installment = new ArrayList<>(); 
	
	public Contract(){}

	public Contract(Integer number, Date date, Double valueContract) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public void setInstallment(List<Installment> installment) {
		this.installment = installment;
	}


	
}
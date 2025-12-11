package model.services;

import java.time.LocalDate;
import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
				
		double valuePerMonth = contract.getValueContract() / months;
		
		for (int i = 1; i <= months; i++) {
			
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double interest = onlinePaymentService.interest(valuePerMonth, i);
			double paymentFee = onlinePaymentService.paymentFee(valuePerMonth+interest);
			
			contract.getInstallment().add(new Installment(dueDate, paymentFee));
		}
	}
}

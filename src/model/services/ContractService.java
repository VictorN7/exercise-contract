package model.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		
		List<Installment> installment = new ArrayList<>();
		
		double valuePerMonth = contract.getValueContract() / months;
		
		for (int i = 1; i <= months; i++) {
			
			double interest = onlinePaymentService.interest(valuePerMonth, i);
			double paymentFee = onlinePaymentService.paymentFee(interest);
			
			Calendar calendar = Calendar.getInstance();
			
			calendar.setTime(contract.getDate());
			calendar.add(calendar.MONTH, i);
			Date newDate = calendar.getTime();
			
			installment.add(new Installment(newDate, paymentFee));
		}
		contract.setInstallment(installment);
	}
}

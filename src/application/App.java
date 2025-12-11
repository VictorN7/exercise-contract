package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Contract contract = new Contract(); 
		
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Numero: ");
		int numberOfContract = scan.nextInt();
		
		try {
			System.out.print("Data (dd/MM/yyyy): ");
			scan.nextLine();
			LocalDate date = LocalDate.parse(scan.next(), fmt);
			System.out.print("Valor do contrato: ");
			double valueContract = scan.nextDouble();
			
			System.out.print("Entre com o numero de parcelas: ");
			int numberInstallment = scan.nextInt();
			
			contract = new Contract(numberOfContract, date, valueContract);
			ContractService service = new ContractService(new PaypalService());
			
			service.processContract(contract, numberInstallment);
			
		} catch (DateTimeParseException e) {

			System.out.println(e.getMessage());
		} 
	
		System.out.println("Parcelas: ");
		
		for (Installment installment: contract.getInstallment()) {
			
			System.out.println(installment);
		}
		scan.close();
	}
}
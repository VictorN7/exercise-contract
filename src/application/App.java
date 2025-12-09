package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Contract contract = new Contract(); 
		
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Numero: ");
		int numberOfContract = scan.nextInt();
		
		try {
			System.out.print("Data (dd/MM/yyyy): ");
			scan.nextLine();
			Date date = sdf.parse(scan.nextLine());
			System.out.print("Valor do contrato: ");
			double valueContract = scan.nextDouble();
			
			System.out.print("Entre com o numero de parcelas: ");
			int numberInstallment = scan.nextInt();
			
			contract = new Contract(numberOfContract, date, valueContract);
			ContractService service = new ContractService(new PaypalService());
			
			service.processContract(contract, numberInstallment);
			
		} catch (ParseException e) {

			System.out.println(e.getMessage());
		} 
	
		
		
		System.out.println("Parcelas: ");
		
		for (Installment installment: contract.getInstallment()) {
			
			System.out.print(sdf.format(installment.getDueDate())+" - " + String.format("%.2f%n", installment.getAmount()));
			
		}
		
		
	
		System.out.println();
		
		scan.close();
		
		
		
		
	}

}

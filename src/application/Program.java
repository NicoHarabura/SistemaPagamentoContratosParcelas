package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcela;
import model.services.ServicoContratos;
import model.services.ServicoPayPal;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Digite os dados do contrato --");
		System.out.println("Numero: ");
		int numero = sc.nextInt();
		System.out.println("Data (dd/MM/yyyy): ");
		sc.nextLine();
		Date data = sdf.parse(sc.nextLine());
		System.out.println("Valor do contrato: ");
		double valor = sc.nextDouble();
		System.out.println("Digite o numero de parcelas: ");
		int meses = sc.nextInt();
		
		Contrato contrato = new Contrato(numero, data, valor);
		
		ServicoContratos servicoContratos = new ServicoContratos(new ServicoPayPal());
			
		servicoContratos.processarContrato(contrato, meses);
		
		System.out.println("Parcelas: ");
		for (Parcela p : contrato.getParcelas()){
			System.out.println(p);
		}
		
		sc.close();
		
	}
}

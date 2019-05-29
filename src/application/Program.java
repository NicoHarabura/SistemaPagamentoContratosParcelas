package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcela;
import model.services.ServicoContratos;
import model.services.ServicoPagamentoOnline;
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
			System.out.println(sdf.format(p.getDataVencimento()) + " - " + p.getValor());
		}
		
		
		/*Enter contract data
		Number: 8028
		Date (dd/MM/yyyy): 25/06/2018
		Contract value: 600.00
		Enter number of installments: 3
		Installments:
		25/07/2018 - 206.04
		25/08/2018 - 208.08
		25/09/2018 - 210.12*/
		
		
		
		sc.close();
		
	}
}

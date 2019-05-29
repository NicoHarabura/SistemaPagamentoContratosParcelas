package model.services;

public class ServicoPayPal implements ServicoPagamentoOnline {

	private static final double TAXA = 0.02;
	private static final double JUROS_MENSAIS = 0.01;
	
	@Override
	public double taxaPagamento(double valor) {
		return valor * TAXA;
	}
	
	@Override
	public double juros(double valor, int mes) {
		return valor * JUROS_MENSAIS * mes;
	}

}

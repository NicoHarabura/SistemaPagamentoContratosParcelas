package model.services;

public interface ServicoPagamentoOnline {

	public double taxaPagamento(double valor);

	public double juros(double valor, int mes);

}

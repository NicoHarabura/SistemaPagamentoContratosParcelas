package model.services;

public interface ServicoPagamentoOnline {

	double taxaPagamento(double valor);

	double juros(double valor, int mes);

}

package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Parcela;

public class ServicoContratos {

	private ServicoPagamentoOnline servicoPagamentoOnline;

	public ServicoContratos(ServicoPagamentoOnline servicoPagamentoOnline) {
		this.servicoPagamentoOnline = servicoPagamentoOnline;
	}

	public void processarContrato(Contrato contrato, int meses) {
		double pagamentoMin = contrato.getValor() / meses;
		for (int i = 1; i <= meses; i++) {
			Date dataVencimento = addMeses(contrato.getData(), i);
			double valorComJuros = pagamentoMin + servicoPagamentoOnline.juros(pagamentoMin, i);
			double valorComTaxa = valorComJuros + servicoPagamentoOnline.taxaPagamento(valorComJuros);
			contrato.addParcela(new Parcela(dataVencimento, valorComTaxa));
		}

	}

	// METODO PARA ADICIONAR MESES A UMA DATA USANDO CALENDAR
	private Date addMeses(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}

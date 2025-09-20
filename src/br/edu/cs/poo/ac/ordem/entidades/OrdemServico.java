package br.edu.cs.poo.ac.ordem.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class OrdemServico implements Serializable {

	private Cliente cliente;
	private PrecoBase precoBase;
	private Notebook notebook;
	private Desktop desktop;
	private LocalDateTime dataHoraAbertura;
	private int prazoEmDias;
	private double valor;

	public LocalDate getDataEstimadaEntrega() {

		LocalDate dataAbertura = dataHoraAbertura.toLocalDate();

		return dataAbertura.plusDays(prazoEmDias);
	}

	public String getNumero() {

		String concatenacao = "";
		if (notebook != null) {
			concatenacao = notebook.getIdTipo();
		} else if (desktop != null) {
			concatenacao = desktop.getIdTipo();
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String formatado = dataHoraAbertura.format(formatter);
		concatenacao += formatado;

		if (cliente.getCpfCnpj().length() == 11)
			concatenacao += "000" + cliente.getCpfCnpj();
		else
			concatenacao += cliente.getCpfCnpj();

		return concatenacao;
	}

}

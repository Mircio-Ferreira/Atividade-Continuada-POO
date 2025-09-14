package br.edu.cs.poo.ac.ordem.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class OrdemServico {
	
	private Cliente cliente;
	private PrecoBase precoBase;
	private Notebook notebook;
	private Desktop desktop;
	private LocalDateTime dataHoraAbertura;
	private int prazoEmDias;
	private double valor;
	//private Cliente cliente;
	/*
	 Método público LocalDate getDataEstimadaEntrega(), que calcula a data estimada de entrega, que é
	 a soma da data e hora de abertura (sem considerar as horas) com o prazoEmDias.
	 */
	
	public LocalDate getDataEstimadaEntrega() {
		
		LocalDate dataAbertura=dataHoraAbertura.toLocalDate();

		return dataAbertura.plusDays(prazoEmDias);
	}
	
	/*
	 * Método público String getNumero(): retorna a concatenação do mês, ano, dia, hora e minuto com o
	   cpf ou cnpj do cliente, se o cpf ou cnpj do cliente for um cnpj; ou retorna a concatenação do mês,
       ano, dia, hora e minuto com “000” e com o cpf ou cnpj do cliente, se o cpf ou cnpj do cliente for um
       cnpj.
       ????
	 */
	
	
	
}

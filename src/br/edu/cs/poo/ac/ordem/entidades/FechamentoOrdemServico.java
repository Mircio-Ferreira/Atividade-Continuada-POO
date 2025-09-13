package br.edu.cs.poo.ac.ordem.entidades;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//

public class FechamentoOrdemServico {
	private String numeroOrdemServico;
	private LocalDate dataFechamento;
	private boolean pago;
	private String relatorioFinal;
}

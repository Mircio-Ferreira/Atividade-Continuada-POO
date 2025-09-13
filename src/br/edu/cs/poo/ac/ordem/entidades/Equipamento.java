package br.edu.cs.poo.ac.ordem.entidades;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Equipamento {

	private String descricao;
	//private TipoEquipamento tipo;
	private boolean ehNovo;
	private double valorEstimado;
	
}

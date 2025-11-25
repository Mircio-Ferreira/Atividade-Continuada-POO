package br.edu.cs.poo.ac.ordem.daos;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.edu.cs.poo.ac.ordem.mediators.DadosOrdemServico;
import br.edu.cs.poo.ac.utils.Registro;

public class DAORegistro<T extends Registro>{
	private final CadastroObjetos cadastro;
	private final String nomeClasse;
	
	public DAORegistro(Class<T> classe){
		this.cadastro = new CadastroObjetos(classe);
		this.nomeClasse = classe.getSimpleName();
	}

	public String getNomeClasse() {
		return nomeClasse;
	}
	
	public T buscar(String id) {
		return (T) cadastro.buscar(id);
	}
	
	public void incluir(String id) {
		return (T) cadastro.buscar(id);
	}
}

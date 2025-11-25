package br.edu.cs.poo.ac.ordem.daos;

import br.edu.cs.poo.ac.ordem.entidades.Cliente;

//O identificador único, por objeto, de Cliente é o cpfCnpj.
public class ClienteDAO extends DAOGenerico{
	
	public Class<Cliente> getClasseEntidade() {
	    return Cliente.class;
	}

	public Cliente buscar(String cpfCnpj) {
		return (Cliente) super.buscar(cpfCnpj);
	}

	public boolean incluir(Cliente cliente) {
		return super.incluir(cliente);
	}

	public boolean alterar(Cliente cliente) {
		return super.alterar(cliente);
	}

	public boolean excluir(String cpfCnpj) {
		return super.excluir(cpfCnpj);
	}

	public Cliente[] buscarTodos() {
		return (Cliente[]) super.buscarTodos();
	}
}
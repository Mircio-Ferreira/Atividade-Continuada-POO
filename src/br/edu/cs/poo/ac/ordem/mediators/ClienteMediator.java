package br.edu.cs.poo.ac.ordem.mediators;

import br.edu.cs.poo.ac.ordem.daos.ClienteDAO;
import br.edu.cs.poo.ac.ordem.entidades.Cliente;
import br.edu.cs.poo.ac.ordem.entidades.Contato;
import br.edu.cs.poo.ac.utils.ListaString;
import br.edu.cs.poo.ac.utils.StringUtils;
import br.edu.cs.poo.ac.utils.ValidadorCPFCNPJ;
import br.edu.cs.poo.ac.utils.ResultadoValidacaoCPFCNPJ;
import br.edu.cs.poo.ac.utils.ErroValidacaoCPFCNPJ;

import java.time.LocalDate;

public class ClienteMediator {

	private static ClienteMediator instancia;

	private ClienteDAO clienteDAO;
	
	

	private ClienteMediator() {
		clienteDAO = new ClienteDAO();
	}

	public static ClienteMediator getInstancia() {
		if (instancia == null) {
			instancia = new ClienteMediator();
		}
		return instancia;
	}
	
	
	
	
	
	

	public ResultadoMediator incluir(Cliente cliente) {
		ResultadoMediator res= validar(cliente);
		return null;
	}

	public ResultadoMediator alterar(Cliente cliente) {

		return null;
	}

	public ResultadoMediator excluir(String cpfCnpj) {
		return null;
	}

	public Cliente buscar(String cpfCnpj) {
		return null;
	}

	public ResultadoMediator validar(Cliente cliente) {
		ListaString mensagens = new ListaString();
		
		if(cliente == null) {
			mensagens.adicionar("Cliente não informado");
			return new ResultadoMediator(false,false,mensagens);
		}
		

        String cpfCnpj = cliente.getCpfCnpj();
        String nome = cliente.getNome();
        Contato contato = cliente.getContato();
        LocalDate dataCadastro = cliente.getDataCadastro();

        if (StringUtils.estaVazia(cpfCnpj)) {
            mensagens.adicionar("CPF/CNPJ não informado");
        } else {
            ResultadoValidacaoCPFCNPJ res = ValidadorCPFCNPJ.validarCPFCNPJ(cpfCnpj);
            if (res.getErroValidacao() != null) {
                if (res.getErroValidacao() == ErroValidacaoCPFCNPJ.CPF_CNPJ_NAO_E_CPF_NEM_CNPJ) {
                    mensagens.adicionar("Não é CPF nem CNJP");
                } else if (res. getErroValidacao() == ErroValidacaoCPFCNPJ.CPF_CNPJ_COM_DV_INVALIDO) {
                    mensagens.adicionar("CPF ou CNPJ com dígito verificador inválido");
                }
            }
        }
        
	}

}
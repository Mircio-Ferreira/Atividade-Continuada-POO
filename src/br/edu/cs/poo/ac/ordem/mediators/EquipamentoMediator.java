package br.edu.cs.poo.ac.ordem.mediators;

import br.edu.cs.poo.ac.ordem.daos.DesktopDAO;
import br.edu.cs.poo.ac.ordem.daos.NotebookDAO;
import br.edu.cs.poo.ac.ordem.entidades.Desktop;
import br.edu.cs.poo.ac.ordem.entidades.Notebook;
import br.edu.cs.poo.ac.utils.ListaString;
import br.edu.cs.poo.ac.utils.StringUtils;

public class EquipamentoMediator {

	private static EquipamentoMediator instancia;

	private NotebookDAO notebookDao;
	private DesktopDAO desktopDao;

	public EquipamentoMediator() {
		notebookDao = new NotebookDAO();
		desktopDao = new DesktopDAO();
	}

	public static EquipamentoMediator getInstancia() {
		if (instancia == null)
			instancia = new EquipamentoMediator();
		return instancia;
	}

	public ResultadoMediator incluirDesktop(Desktop desk) {
		return null;
	}

	public ResultadoMediator alterarDesktop(Desktop desk) {
		return null;
	}

	public ResultadoMediator incluirNotebook(Notebook note) {
		return null;
	}

	public ResultadoMediator alterarNotebook(Notebook note) {
		return null;
	}

	public ResultadoMediator excluirNotebook(String idTipoSerial) {
		return null;
	}

	public ResultadoMediator excluirDesktop(String idTipoSerial) {
		return null;
	}

	public Notebook buscarNotebook(String idTipoSerial) {
		if (StringUtils.estaVazia(idTipoSerial))
			return null;

		return notebookDao.buscar(idTipoSerial);
	}

	public Desktop buscarDesktop(String idTipoSerial) {
		if (StringUtils.estaVazia(idTipoSerial))
			return null;

		return desktopDao.buscar(idTipoSerial);

	}

	public ResultadoMediator validarDesktop(Desktop desk) {
		ListaString list = new ListaString();
		ResultadoMediator res = new ResultadoMediator(false, false, list);
		if (desk == null) {
			list.adicionar("Desktop não informado");
			return res;
		}
		if (StringUtils.estaVazia(desk.getDescricao())) {
			list.adicionar("Descrição não informada");
		} else {
			if (StringUtils.tamanhoExcedido(desk.getDescricao(), 150)) {
				list.adicionar("Descrição tem mais de 150 caracteres");
			}
			if (StringUtils.tamanhoMenor(desk.getDescricao(), 9)) {
				list.adicionar("Descrição tem menos de 10 caracteres");
			}
		}
		
		if (StringUtils.estaVazia(desk.getSerial())) {
			list.adicionar("Serial não informado");
		}
		
		if (desk.getValorEstimado() <= 0) {
			list.adicionar("Valor estimado menor ou igual a zero");
		}

		return res;
	}

	public ResultadoMediator validarNotebook(Notebook note) {
		ListaString list = new ListaString();
		ResultadoMediator res = new ResultadoMediator(false, false, list);
		if (note == null) {
			list.adicionar("Notebook não informado");
			return res;
		}
		if (StringUtils.estaVazia(note.getDescricao())) {
			list.adicionar("Descrição não informada");
		} else {
			if (StringUtils.tamanhoExcedido(note.getDescricao(), 150)) {
				list.adicionar("Descrição tem mais de 150 caracteres");
			}
			if (StringUtils.tamanhoMenor(note.getDescricao(), 9)) {
				list.adicionar("Descrição tem menos de 10 caracteres");
			}
		}
		
		if (StringUtils.estaVazia(note.getSerial())) {
			list.adicionar("Serial não informado");
		}
		
		if (note.getValorEstimado() <= 0) {
			list.adicionar("Valor estimado menor ou igual a zero");
		}

		return res;
	}

	public ResultadoMediator validar(DadosEquipamento equip) {
		ListaString list = new ListaString();
		ResultadoMediator res = new ResultadoMediator(false, false, list);
		if (equip == null) {
			list.adicionar("Dados básicos do equipamento não informados");
			return res;
		}
		if (StringUtils.estaVazia(equip.getDescricao())) {
			list.adicionar("Descrição não informada");
		} else {
			if (StringUtils.tamanhoExcedido(equip.getDescricao(), 150)) {
				list.adicionar("Descrição tem mais de 150 caracteres");
			}
			if (StringUtils.tamanhoMenor(equip.getDescricao(), 9)) {
				list.adicionar("Descrição tem menos de 10 caracteres");
			}
		}
		
		if (StringUtils.estaVazia(equip.getSerial())) {
			list.adicionar("Serial não informado");
		}
		
		if (equip.getValorEstimado() <= 0) {
			list.adicionar("Valor estimado menor ou igual a zero");
		}

		return res;
	}
}
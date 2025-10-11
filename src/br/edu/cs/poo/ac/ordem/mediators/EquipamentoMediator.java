package br.edu.cs.poo.ac.ordem.mediators;

import br.edu.cs.poo.ac.ordem.daos.DesktopDAO;
import br.edu.cs.poo.ac.ordem.daos.NotebookDAO;
import br.edu.cs.poo.ac.ordem.entidades.Desktop;
import br.edu.cs.poo.ac.ordem.entidades.Notebook;
import br.edu.cs.poo.ac.utils.StringUtils;

public class EquipamentoMediator {
    
    private static EquipamentoMediator instancia;
    
    private NotebookDAO notebookDao;
    private DesktopDAO desktopDao;
    
    public EquipamentoMediator() {
        notebookDao=new NotebookDAO();
        desktopDao = new DesktopDAO();
    }
    
    public static EquipamentoMediator getInstancia() {
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
    	if(StringUtils.estaVazia(idTipoSerial)) return null;
    	
    	return notebookDao.buscar(idTipoSerial);
    }

    public Desktop buscarDesktop(String idTipoSerial) {
    	if(StringUtils.estaVazia(idTipoSerial)) return null;
    	
    	return desktopDao.buscar(idTipoSerial);
    	
    }

    public ResultadoMediator validarDesktop(Desktop desk) {
    	return null;
    }
    
    public ResultadoMediator validarNotebook(Notebook note) {
    	return null;
    }

    public ResultadoMediator validar(DadosEquipamento equip) {
    	return null;
    }
}
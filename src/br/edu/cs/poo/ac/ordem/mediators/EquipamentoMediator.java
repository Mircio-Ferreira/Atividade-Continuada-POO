package br.edu.cs.poo.ac.ordem.mediators;

import br.edu.cs.poo.ac.ordem.entidades.Desktop;
import br.edu.cs.poo.ac.ordem.entidades.Notebook;
import br.edu.cs.poo.ac.ordem.daos.NotebookDAO;
import br.edu.cs.poo.ac.ordem.daos.DesktopDAO;

public class EquipamentoMediator {
    
    private static EquipamentoMediator instancia;
    
    private NotebookDAO notebookDao;
    private DesktopDAO desktopDAO;
    
    public EquipamentoMediator() {
        notebookDao=new NotebookDAO();
        desktopDAO = new DesktopDAO();
    }
    
    public ResultadoMediator incluirDesktop(Desktop desk) {
    }

    public ResultadoMediator alterarDesktop(Desktop desk) {
    }

    public ResultadoMediator incluirNotebook(Notebook note) {
    }

    public ResultadoMediator alterarNotebook(Notebook note) {
    }

    public ResultadoMediator excluirNotebook(String idTipoSerial) {
    }

    public ResultadoMediator excluirDesktop(String idTipoSerial) {
    }

    public Notebook buscarNotebook(String idTipoSerial) {
    }

    public Desktop buscarDesktop(String idTipoSerial) {
    }

    public ResultadoMediator validarDesktop(Desktot desk) {
    }

    public ResultadoMediator validarDesktop(Desktot desk) {
    }

    public ResultadoMediator validar(DadosEquipamento equip) {
    }
}
package br.edu.cs.poo.ac.gui;

import javax.swing.*;
import java.awt.*;
import br.edu.cs.poo.ac.ordem.entidades.Notebook;
import br.edu.cs.poo.ac.ordem.entidades.Desktop;
import br.edu.cs.poo.ac.ordem.mediators.EquipamentoMediator;

public class TelaEquipamento extends JFrame {
    private JComboBox<String> comboTipo;
    private JTextField txtSerial, txtValor;
    private JTextArea txtDescricao;
    private JRadioButton rbNovoSim, rbNovoNao, rbExtraSim, rbExtraNao;
    private JPanel painelExtra;
    private EquipamentoMediator mediator = EquipamentoMediator.getInstancia();

    public TelaEquipamento() {
        setTitle("CRUD Equipamento");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Painel principal
        JPanel painelCampos = new JPanel(new GridLayout(0, 2, 10, 10));

        // Tipo
        painelCampos.add(new JLabel("Tipo:", SwingConstants.RIGHT));
        comboTipo = new JComboBox<>(new String[]{"Notebook", "Desktop"});
        painelCampos.add(comboTipo);

        // Serial
        painelCampos.add(new JLabel("Serial:", SwingConstants.RIGHT));
        txtSerial = new JTextField();
        painelCampos.add(txtSerial);

        // Descrição
        painelCampos.add(new JLabel("Descrição:", SwingConstants.RIGHT));
        txtDescricao = new JTextArea(3, 20);
        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);
        JScrollPane scrollDescricao = new JScrollPane(txtDescricao);
        painelCampos.add(scrollDescricao);

        // É novo
        painelCampos.add(new JLabel("É novo:", SwingConstants.RIGHT));
        JPanel painelNovo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ButtonGroup grupoNovo = new ButtonGroup();
        rbNovoNao = new JRadioButton("Não", true);
        rbNovoSim = new JRadioButton("Sim");
        grupoNovo.add(rbNovoNao);
        grupoNovo.add(rbNovoSim);
        painelNovo.add(rbNovoNao);
        painelNovo.add(rbNovoSim);
        painelCampos.add(painelNovo);

        // Valor estimado
        painelCampos.add(new JLabel("Valor estimado (R$):", SwingConstants.RIGHT));
        txtValor = new JTextField();
        painelCampos.add(txtValor);

        // Campo extra dinâmico
        painelCampos.add(new JLabel("Opção adicional:", SwingConstants.RIGHT));
        painelExtra = new JPanel(new FlowLayout(FlowLayout.LEFT));
        atualizarExtra();
        painelCampos.add(painelExtra);

        // Atualiza painel ao mudar tipo
        comboTipo.addActionListener(e -> atualizarExtra());

        // Painel de botões
        JPanel painelBotoes = new JPanel(new FlowLayout());
        JButton btnIncluir = new JButton("Incluir");
        JButton btnAlterar = new JButton("Alterar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnCancelar = new JButton("Cancelar");

        btnIncluir.addActionListener(e -> incluir());
        btnAlterar.addActionListener(e -> alterar());
        btnExcluir.addActionListener(e -> excluir());
        btnCancelar.addActionListener(e -> dispose());

        painelBotoes.add(btnIncluir);
        painelBotoes.add(btnAlterar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnCancelar);

        // Adiciona tudo na janela
        add(painelCampos, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void atualizarExtra() {
        painelExtra.removeAll();
        ButtonGroup grupoExtra = new ButtonGroup();

        if (comboTipo.getSelectedItem().equals("Notebook")) {
            rbExtraNao = new JRadioButton("Carrega dados sensíveis: NÃO", true);
            rbExtraSim = new JRadioButton("SIM");
        } else {
            rbExtraNao = new JRadioButton("É Servidor: NÃO", true);
            rbExtraSim = new JRadioButton("SIM");
        }

        grupoExtra.add(rbExtraNao);
        grupoExtra.add(rbExtraSim);
        painelExtra.add(rbExtraNao);
        painelExtra.add(rbExtraSim);
        painelExtra.revalidate();
        painelExtra.repaint();
    }
    
    private void incluir() {
        String tipo = (String) comboTipo.getSelectedItem();
        String serial = txtSerial.getText().trim();
        String descricao = txtDescricao.getText().trim();
        boolean novo = rbNovoSim.isSelected();
        boolean extra = rbExtraSim.isSelected();

        double valor;
        try {
            valor = Double.parseDouble(txtValor.getText().replace(",", "."));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido! Use apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (serial.isEmpty() || descricao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tipo.equals("Notebook")) {
            Notebook n = new Notebook(serial, descricao, novo, valor, extra);
            mediator.incluirNotebook(n);
        } else {
            Desktop d = new Desktop(serial, descricao, novo, valor, extra);
            mediator.incluirDesktop(d);
        }

        JOptionPane.showMessageDialog(this, "Inclusão realizada com sucesso!");
        limparCampos();
    }

    private void alterar() {
        String tipo = (String) comboTipo.getSelectedItem();
        String serial = txtSerial.getText().trim();
        String descricao = txtDescricao.getText().trim();
        boolean novo = rbNovoSim.isSelected();
        boolean extra = rbExtraSim.isSelected();

        double valor;
        try {
            valor = Double.parseDouble(txtValor.getText().replace(",", "."));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido! Use apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (serial.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o serial do equipamento a alterar!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tipo.equals("Notebook")) {
            Notebook n = new Notebook(serial, descricao, novo, valor, extra);
            if (mediator.alterarNotebook(n) != null) {
                JOptionPane.showMessageDialog(this, "Notebook alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Notebook não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            Desktop d = new Desktop(serial, descricao, novo, valor, extra);
            if (mediator.alterarDesktop(d) != null) {
                JOptionPane.showMessageDialog(this, "Desktop alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Desktop não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        limparCampos();
    }

    private void excluir() {
        String tipo = (String) comboTipo.getSelectedItem();
        String serial = txtSerial.getText().trim();

        if (serial.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o serial do equipamento a excluir!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o equipamento de serial " + serial + "?", 
                                                  "Confirmação", JOptionPane.YES_NO_OPTION);
        if (opcao != JOptionPane.YES_OPTION) return;

        if (tipo.equals("Notebook")) {
            if (mediator.excluirNotebook(serial) != null) {
                JOptionPane.showMessageDialog(this, "Notebook excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Notebook não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (mediator.excluirDesktop(serial) != null) {
                JOptionPane.showMessageDialog(this, "Desktop excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Desktop não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        limparCampos();
    }


    private void limparCampos() {
        txtSerial.setText("");
        txtDescricao.setText("");
        txtValor.setText("");
        rbNovoNao.setSelected(true);
        rbExtraNao.setSelected(true);
    }
}

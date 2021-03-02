/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.gmr.agenda.view;

import br.ufjf.dcc.gmr.agenda.control.LimparFormulario;
import br.ufjf.dcc.gmr.agenda.control.RemoverContato;
import br.ufjf.dcc.gmr.agenda.control.SalvarContato;
import br.ufjf.dcc.gmr.agenda.control.TratarLista;
import br.ufjf.dcc.gmr.agenda.model.Contato;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author gleiph
 */
public class Tela extends JFrame {

    JPanel principal;
    private JList<Contato> lista;
    private JTextField tfNome;
    private JTextField tfTelefone;
    private JTextField tfDescricao;

    public JList<Contato> getLista() {
        return lista;
    }

    public void setLista(JList<Contato> lista) {
        this.lista = lista;
    }

    public JTextField getTfNome() {
        return tfNome;
    }

    public void setTfNome(JTextField tfNome) {
        this.tfNome = tfNome;
    }

    public JTextField getTfTelefone() {
        return tfTelefone;
    }

    public void setTfTelefone(JTextField tfTelefone) {
        this.tfTelefone = tfTelefone;
    }

    public JTextField getTfDescricao() {
        return tfDescricao;
    }

    public void setTfDescricao(JTextField tfDescricao) {
        this.tfDescricao = tfDescricao;
    }

    

    private void configuraJanela() {
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        principal = new JPanel();
        principal.setLayout(new BorderLayout());

    }

    private void configuraContatos() {
        JPanel jpContatos = new JPanel();
        jpContatos.setBorder(BorderFactory.createTitledBorder("Contatos"));
        jpContatos.setLayout(new BorderLayout());
        jpContatos.setPreferredSize(new Dimension(200, 100));

        DefaultListModel<Contato> model = new DefaultListModel<>();
        model.addElement(new Contato("Gleiph", "3538", "Casa"));
        model.addElement(new Contato("Maria", "3539", "Casa"));

        lista = new JList<>(model);
        lista.setVisible(true);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(new TratarLista(this));
        jpContatos.add(new JScrollPane(lista), BorderLayout.CENTER);

        JPanel botaoPainel = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnRemover = new JButton("Remover");
        btnRemover.addActionListener(new RemoverContato(this));

        botaoPainel.setLayout(new GridLayout(1, 2));
        botaoPainel.add(btnAdicionar);
        botaoPainel.add(btnRemover);
        jpContatos.add(botaoPainel, BorderLayout.SOUTH);

        principal.add(jpContatos, BorderLayout.WEST);
    }

    private void configuraFormulario() {
        int size = 15;
        JPanel jpFormulario = new JPanel();
        jpFormulario.setBorder(BorderFactory.createTitledBorder("Formulário"));

        jpFormulario.add(new JLabel("Nome:"));
        tfNome = new JTextField(size);
        jpFormulario.add(tfNome);

        jpFormulario.add(new JLabel("Telefone:"));
        tfTelefone = new JTextField(size);
        jpFormulario.add(tfTelefone);

        jpFormulario.add(new JLabel("Descrição:"));
        tfDescricao = new JTextField(size);
        jpFormulario.add(tfDescricao);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new SalvarContato(this));
        jpFormulario.add(btnSalvar);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(new LimparFormulario(this));
        jpFormulario.add(btnLimpar);
        
        principal.add(jpFormulario, BorderLayout.CENTER);

    }

    public void mostraTela() {
        this.add(principal);
        this.setVisible(true);
    }

    public void montaTela() {
        configuraJanela();
        configuraContatos();
        configuraFormulario();
        mostraTela();
    }

    public static void main(String[] args) {
        Tela tela = new Tela();
        tela.montaTela();
    }

}

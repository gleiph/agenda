/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.gmr.agenda.view;

import br.ufjf.dcc.gmr.agenda.control.SalvarContato;
import br.ufjf.dcc.gmr.agenda.model.Contato;
import com.google.gson.Gson;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
    private JTextField jNome;
    private JTextField jTelefone;
    private JTextField jDescricao;

    public JList<Contato> getLista() {
        return lista;
    }

    public void setLista(JList<Contato> lista) {
        this.lista = lista;
    }

    public JTextField getjNome() {
        return jNome;
    }

    public void setjNome(JTextField jNome) {
        this.jNome = jNome;
    }

    public JTextField getjTelefone() {
        return jTelefone;
    }

    public void setjTelefone(JTextField jTelefone) {
        this.jTelefone = jTelefone;
    }

    public JTextField getjDescricao() {
        return jDescricao;
    }

    public void setjDescricao(JTextField jDescricao) {
        this.jDescricao = jDescricao;
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
        

        lista = new JList<>(model);
        lista.setVisible(true);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jpContatos.add(new JScrollPane(lista), BorderLayout.CENTER);

//        jpContatos.add(listaPanel, BorderLayout.CENTER);
        JPanel botaoPainel = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnRemover = new JButton("Remover");
        botaoPainel.setLayout(new GridLayout(1, 2));
        botaoPainel.add(btnAdicionar);
        botaoPainel.add(btnRemover);
        jpContatos.add(botaoPainel, BorderLayout.SOUTH);

        principal.add(jpContatos, BorderLayout.WEST);
    }

    private void configuraFormulario() {
        int size = 15;
        JPanel jpFormulario = new JPanel();
        jpFormulario.setBorder(BorderFactory.createTitledBorder("Formulario"));

        jpFormulario.add(new JLabel("Nome:"));
        jNome = new JTextField(size);
        jpFormulario.add(jNome);

        jpFormulario.add(new JLabel("Telefone:"));
        jTelefone = new JTextField(size);
        jpFormulario.add(jTelefone);

        jpFormulario.add(new JLabel("Descrição:"));
        jDescricao = new JTextField(size);
        jpFormulario.add(jDescricao);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new SalvarContato(this));

        jpFormulario.add(btnSalvar);

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

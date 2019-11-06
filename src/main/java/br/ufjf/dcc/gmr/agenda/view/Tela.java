/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.gmr.agenda.view;

import br.ufjf.dcc.gmr.agenda.model.Contato;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author gleiph
 */
public class Tela extends JFrame{
    
    JPanel principal;
    JList<Contato> lista;
    JTextField jNome;
    JTextField jTelefone;
    JTextField jDescricao;
    
    private void configuraJanela(){
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        principal = new JPanel();
        principal.setLayout(new BorderLayout());
        
    }
    
    private void configuraContatos(){
        JPanel jpContatos = new JPanel();
        jpContatos.setBorder(BorderFactory.createTitledBorder("Contatos"));
        jpContatos.setLayout(new BorderLayout());
        jpContatos.setPreferredSize(new Dimension(200, 100));
        
        JScrollPane listaPanel = new JScrollPane();
        
        lista = new JList<>();
        listaPanel.add(lista);
        
        jpContatos.add(listaPanel, BorderLayout.CENTER);
        
        JPanel botaoPainel = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnRemover = new JButton("Remover");
        botaoPainel.setLayout(new GridLayout(1, 2));
        botaoPainel.add(btnAdicionar);
        botaoPainel.add(btnRemover);
        jpContatos.add(botaoPainel, BorderLayout.SOUTH);
        
        principal.add(jpContatos, BorderLayout.WEST);
    }
    
    private void configuraFormulario(){
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
        jpFormulario.add(btnSalvar);
        
        
        principal.add(jpFormulario, BorderLayout.CENTER);
        
    }
    
    public void mostraTela(){
        this.add(principal);
        this.setVisible(true);
    }
    
    public   void montaTela(){
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

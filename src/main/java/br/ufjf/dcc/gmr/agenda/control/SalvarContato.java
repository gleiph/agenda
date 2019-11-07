/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.gmr.agenda.control;

import br.ufjf.dcc.gmr.agenda.model.Contato;
import br.ufjf.dcc.gmr.agenda.view.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

/**
 *
 * @author gleiph
 */
public class SalvarContato implements ActionListener{

    Tela tela;

    public SalvarContato(Tela tela) {
        this.tela = tela;
    }

    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultListModel<Contato> model = (DefaultListModel<Contato>) tela.getLista().getModel();
        
        model.addElement(
                new Contato(
                        tela.getjNome().getText(), 
                tela.getjTelefone().getText(), 
                tela.getjDescricao().getText()));
        
        tela.getLista().setModel(model);
        tela.repaint();
       
    }
    
}

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
import javax.swing.ListModel;

/**
 *
 * @author gleiph
 */
public class EditarContato implements ActionListener{

    private Tela tela;

    public EditarContato(Tela tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ListModel<Contato> model = this.tela.getLista().getModel();
        Contato contato = model.getElementAt(tela.getLastIndex());
        contato.setNome(tela.getTfNome().getText());
        contato.setTelefone(tela.getTfTelefone().getText());
        contato.setDetalhe(tela.getTfDescricao().getText());
        
        
        tela.repaint();
//        tela.getLista().setModel(model);
        
    }
    
}

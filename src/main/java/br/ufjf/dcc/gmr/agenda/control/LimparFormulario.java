/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.gmr.agenda.control;

import br.ufjf.dcc.gmr.agenda.view.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gleiph
 */
public class LimparFormulario implements ActionListener{

    Tela tela;

    public LimparFormulario(Tela tela) {
        this.tela = tela;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        tela.getjDescricao().setText("");
        tela.getjNome().setText("");
        tela.getjTelefone().setText("");
    }
    
}

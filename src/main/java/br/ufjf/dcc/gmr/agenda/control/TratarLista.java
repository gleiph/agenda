/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.gmr.agenda.control;

import br.ufjf.dcc.gmr.agenda.model.Contato;
import br.ufjf.dcc.gmr.agenda.view.Tela;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author gleiph
 */
public class TratarLista implements ListSelectionListener {

    Tela tela;

    public TratarLista(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int firstIndex = tela.getLista().getSelectedIndex();

        if (firstIndex != -1) {

            
            Contato elementAt = tela.getLista().getModel().getElementAt(firstIndex);
            tela.getTfNome().setText(elementAt.getNome());
            tela.getTfTelefone().setText(elementAt.getTelefone());
            tela.getTfDescricao().setText(elementAt.getDetalhe());
            
            tela.setLastIndex(firstIndex);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.gmr.agenda.control;

import br.ufjf.dcc.gmr.agenda.model.Contato;
import br.ufjf.dcc.gmr.agenda.util.Arquivo;
import br.ufjf.dcc.gmr.agenda.util.JSON;
import br.ufjf.dcc.gmr.agenda.view.Tela;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

/**
 *
 * @author gleiph
 */
public class EventoJanela implements WindowListener {

    Tela tela;

    public EventoJanela(Tela tela) {
        this.tela = tela;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        
        
        
        try {
            String lerArquivo = Arquivo.lerArquivo("dados");
            List<Contato> contatos = JSON.toContatos(lerArquivo);
            
            DefaultListModel<Contato> modelo = new DefaultListModel<>();
            
            for (Contato contato : contatos) {
                modelo.addElement(contato);
            }
            
            tela.getLista().setModel(modelo);
            tela.repaint();
            
        } catch (FileNotFoundException ex) {
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
        ListModel<Contato> model = tela.getLista().getModel();
        List<Contato> contatos = new ArrayList<>();
        
        
        for (int i = 0; i < model.getSize(); i++) {
            contatos.add(model.getElementAt(i));
        }
        
        String toJSON = JSON.toJSON(contatos);
        
        System.out.println(toJSON);
        
        Arquivo.escreverArquivo("dados", toJSON);
        
        System.out.println("windowClosing");
        
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

}

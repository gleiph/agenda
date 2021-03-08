/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.gmr.agenda.model;

/**
 *
 * @author gleiph
 */
public class Contato {

    private static int idAtual = 0;
    private int id;
    private String nome;
    private String telefone;
    private String detalhe;

    public Contato(String nome, String telefone, String detalhe) {
        this.nome = nome;
        this.telefone = telefone;
        this.detalhe = detalhe;
        this.id = idAtual++;
    }

    public Contato() {
        this.nome = "";
        this.telefone = "";
        this.detalhe = "";
        this.id = idAtual++;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    @Override
    public String toString() {
        return this.nome;
    }

}

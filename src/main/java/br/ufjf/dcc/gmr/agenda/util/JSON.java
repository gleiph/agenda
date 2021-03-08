/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc.gmr.agenda.util;

import br.ufjf.dcc.gmr.agenda.model.Contato;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gleiph
 */
public class JSON {

    public static String toJSON(Contato contato) {
        Gson gson = new Gson();
        String json = gson.toJson(contato);
        return json;
    }

    public static String toJSON(List<Contato> contatos) {
        Gson gson = new Gson();
        String json = gson.toJson(contatos);
        return json;
    }

    public static Contato toContato(String conteudo) {
        Gson gson = new Gson();
        Contato contato = gson.fromJson(conteudo, Contato.class);

        return contato;
    }

    public static List<Contato> toContatos(String conteudo) {
        Gson gson = new Gson();
        Type pessoasTipo = new TypeToken<ArrayList<Contato>>() {
        }.getType();
        List<Contato> contatos = gson.fromJson(conteudo, pessoasTipo);

        return contatos;
    }

}

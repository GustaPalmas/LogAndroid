package com.br.edu.ifsc.palmas.logveiculo.ui.motorista;

import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Motorista {
    //atributos
    private boolean aceito;
    private String id;
    private String nome;
    private String email;
    private String senha;
    private String data;
    private int categoria;
    private String cpf;
    private String cnh;



    //metodos
    public boolean isAceito() {
        return aceito;
    }

    public void setAceito(boolean aceito){
        this.aceito=aceito;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getData() {return data;}
    public void setData(String data) {
        SimpleDateFormat formato =
                new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = (Date) formato.parse(data);
//se chegar até aqui não deu erro no parser
            this.data = data;
        } catch (ParseException e) {
            this.data = "";
        }
    }

    public String getCnh() {
        return cnh;
    }
    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public void setCnh(String cnh){
        this.cnh=cnh;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf=cpf;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria){
        this.categoria=categoria;
    }

    //construtores
    public Motorista(JSONObject jp){
        try{

            this.setCpf((String) jp.get("cpf"));
            this.setId((String) jp.get("id"));
            this.setNome((String) jp.get("nome"));
            this.setSenha((String) jp.get("senha"));
            this.setEmail((String) jp.get("email"));
            boolean bool = Boolean.getBoolean(jp.get("aceito").toString());
            this.setAceito(bool);
            this.setData((String) jp.get("data"));
            this.setCnh((String) jp.get("cnh"));
            int codigo = (int) jp.get("categoria");
            this.setCategoria(codigo);
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }
    //CONSTRUTOR - Inicializa os atributos para gerar Objeto Json
    public Motorista() {
        this.setCategoria((byte)0);
        this.setAceito(false);
        this.setCpf("");
        this.setId("");
        this.setCnh("");
        this.setData("");
        this.setNome("");
        this.setSenha("");
        this.setEmail("");
    }
    //Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject () {
        JSONObject json = new JSONObject();
        try {
            json.put("id", this.id);
            json.put("cpf", this.cpf);
            json.put("cnh", this.cnh);
            json.put("nome", this.nome);
            json.put("senha", this.senha);
            json.put("email", this.email);
            json.put("data", this.data);
            json.put("categoria", this.categoria);
            json.put("aceito", this.aceito);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    }


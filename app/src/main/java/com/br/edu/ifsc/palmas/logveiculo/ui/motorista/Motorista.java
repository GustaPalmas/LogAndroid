package com.br.edu.ifsc.palmas.logveiculo.ui.motorista;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Motorista {
    //atributos
    private boolean aceito;
    private String nome;
    private String email;
    private String senha;
    private String data;
    private byte categoria;
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

    public void setCnh(String cnh){
        this.cnh=cnh;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf=cpf;
    }

    public byte getCategoria() {
        return categoria;
    }

    public void setCategoria(byte categoria){
        this.categoria=categoria;
    }

    //construtores
    public Motorista(JSONObject jp){
        try{

            this.setCpf((String) jp.get("cpf"));
            this.setNome((String) jp.get("nome"));
            this.setSenha((String) jp.get("senha"));
            this.setEmail((String) jp.get("email"));
            boolean bool = Boolean.getBoolean(jp.get("aceito").toString());
            this.setAceito(bool);
            this.setData((String) jp.get("data"));
            this.setCnh((String) jp.get("cnh"));
            Byte codigo = (byte) jp.get("categoria");
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
            json.put("Cpf", this.cpf);
            json.put("Cnh", this.cnh);
            json.put("Nome", this.nome);
            json.put("Senha", this.senha);
            json.put("Email", this.email);
            json.put("Data", this.data);
            json.put("categoria", this.categoria);
            json.put("Aceito", this.aceito);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    }


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calcados.classes;

import java.util.Date;

/**
 *
 * @author kayla
 */
public class Clientes {
    private int id;
    private String cpf;
    private String nome;
    private String email;
    private String genero;
    private String est_civil;
    private String cep;
    private String rua;
    private int num_casa;
    private Date data;
    
    public Clientes(){
        
    }
    
     public Clientes(String cpf, String nome, String email, String genero, String est_civil, String cep, String rua, int num_casa, Date data) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.genero = genero;
        this.est_civil = est_civil;
        this.cep = cep;
        this.rua = rua;
        this.num_casa = num_casa;
        this.data = data;
     }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEst_civil() {
        return est_civil;
    }

    public void setEst_civil(String est_civil) {
        this.est_civil = est_civil;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNum_casa() {
        return num_casa;
    }

    public void setNum_casa(int num_casa) {
        this.num_casa = num_casa;
    }

     public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

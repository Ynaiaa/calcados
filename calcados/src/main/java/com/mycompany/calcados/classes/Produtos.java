/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calcados.classes;

/*import java.sql.Date;*/
import java.util.Date;

/**
 *
 * @author kayla
 */
public class Produtos {
    
    private int cod_prod;
    private double preco;
    private int tamanho;
    private String modelo;
    private String marca;
    private String cor;
    private String genero;
    private Date data;
    private int qtd;
    
    public Produtos(){
        
    }
    
    public Produtos(int cod_prod, double preco, int tamanho, String modelo, String marca, String cor, String genero, Date data, int qtd) {
        this.cod_prod = cod_prod;
        this.preco = preco;
        this.tamanho = tamanho;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.genero = genero;
        this.data = data;
        this.qtd = qtd;
    }
    
    public int getQtd(){
       return qtd;
    }
    
    public void setQtd(int qtd){
        this.qtd = qtd;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public int getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(int cod_prod) {
        this.cod_prod = cod_prod;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}

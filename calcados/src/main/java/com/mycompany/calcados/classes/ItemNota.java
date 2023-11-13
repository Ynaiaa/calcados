/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calcados.classes;

/**
 *
 * @author kayla
 */
public class ItemNota {
    private int idItemNota; //auto_increment
    private int idNota; // vem de vendas
    private int idProduto; // foreign key
    private String marca;
    private double vlrProduto;
    private int qtdProduto;
    
    public ItemNota(){
        
    }
    
    public ItemNota(int idNota, int idProduto, String marca, double vlrProduto, int qtdProduto){
        this.idNota = idNota;
        this.idProduto = idProduto;
        this.marca = marca;
        this.vlrProduto = vlrProduto;
        this.qtdProduto = qtdProduto;
    }
    
    public int getIdItemNota() {
        return idItemNota;
    }

    public void setIdItemNota(int idItemNota) {
        this.idItemNota = idItemNota;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getVlrProduto() {
        return vlrProduto;
    }

    public void setVlrProduto(double vlrProduto) {
        this.vlrProduto = vlrProduto;
    }
    
}

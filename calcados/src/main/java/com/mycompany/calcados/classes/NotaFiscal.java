/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calcados.classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kayla
 */
public class NotaFiscal {
    private int idVenda;
    private double total;
    private int qtdprod;
    private Date data;
    private int id;
    String marca;
    
    private ArrayList<ItemNota> listaItens = null;
    
    public NotaFiscal(){
        
    }
    
    public NotaFiscal(double total, int qtdprod, Date data, int id){
        this.total    = total;
        this.qtdprod  = qtdprod;
        this.data     = data;
        this.id       = id;
    }
    
    public NotaFiscal(int idVenda, double total, int qtdprod, Date data, String marca){
        this.idVenda = idVenda;
        this.total    = total;
        this.qtdprod = qtdprod;
        this.data     = data;
        this.marca    = marca;
    }
    
   public int getIdvenda() {
        return idVenda;
    }

    public void setIdvenda(int idVenda) {
        this.idVenda = idVenda;
    }
    
       public double getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
       public int getQtdprod() {
        return qtdprod;
    }

    public void setQtdprod(int qtdprod) {
        this.qtdprod = qtdprod;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    public ArrayList<ItemNota> getListaItens() {
        return listaItens;
    }

    public void setListaItens(ArrayList<ItemNota> listaItens) {
        this.listaItens = listaItens;
    }

   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
}

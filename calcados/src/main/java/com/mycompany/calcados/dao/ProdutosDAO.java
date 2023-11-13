/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calcados.dao;

import com.mycompany.calcados.classes.Produtos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *Metodos para inserir, alterar, cadastrar e buscar produtos no banco de dados.
 * @author kayla
 */
public class ProdutosDAO {
    public static boolean cadastrarP(Produtos obj){
        boolean RetornoP = false;
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lojacalcados";
            
            // Passo 2 - Abrir a conexão
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO produtos " 
                    + "(cod_prod, preco, tamanho, modelo, marca, cor, genero, data, qtd) VALUES(?,?,?,?,?,?,?,?,?)");
           
           comandoSQL.setInt(1,obj.getCod_prod());
           comandoSQL.setDouble(2,obj.getPreco());
           comandoSQL.setInt(3,obj.getTamanho());
           comandoSQL.setString(4,obj.getModelo());
           comandoSQL.setString(5,obj.getMarca());
           comandoSQL.setString(6,obj.getCor());
           comandoSQL.setString(7,obj.getGenero());
           comandoSQL.setDate(8, (Date) obj.getData());
           comandoSQL.setInt(9, obj.getQtd());
           
           // Passo 4 - Executar comando SQL
          int linhasAfetadas = comandoSQL.executeUpdate();
          
          if(linhasAfetadas>0){
              RetornoP = true;
          }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return RetornoP;
    } // Fim do metódo insert do prod
    
     public static ArrayList<Produtos> listarP(){
        ArrayList<Produtos> buscaProd = new ArrayList(); 
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/lojacalcados";
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produtos");
           
           // Passo 4 - Executar comando SQL
          ResultSet Rs_select = comandoSQL.executeQuery();
          
          if(Rs_select != null){
              // Percorrendo o result e passando os valores a um obj
              while(Rs_select.next()){
                  
                  Produtos select = new Produtos();
                  select.setQtd(Rs_select.getInt("qtd"));
                  select.setCod_prod(Rs_select.getInt("cod_prod"));
                  select.setModelo(Rs_select.getString("modelo"));
                  select.setMarca(Rs_select.getString("marca"));
                  select.setCor(Rs_select.getString("cor"));
                  select.setGenero(Rs_select.getString("genero"));
                  select.setTamanho(Rs_select.getInt("tamanho"));
                  select.setPreco(Rs_select.getDouble("preco"));
                  
                  buscaProd.add(select);
              }
          }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return buscaProd;
    } // Fim do metodo de select do prod
    
     public static ArrayList<Produtos> listarID(int Cod){
        ArrayList<Produtos> buscaID = new ArrayList(); 
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/lojacalcados";
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produtos WHERE cod_prod = ?");
           comandoSQL.setInt(1,Cod);
           
           // Passo 4 - Executar comando SQL
          ResultSet Rs_select = comandoSQL.executeQuery();
          
          if(Rs_select != null){
              // Percorrendo o result e passando os valores a um obj
              while(Rs_select.next()){
                  Produtos select = new Produtos();
                  select.setQtd(Rs_select.getInt("qtd"));
                  select.setCod_prod(Rs_select.getInt("cod_prod"));
                  select.setModelo(Rs_select.getString("modelo"));
                  select.setMarca(Rs_select.getString("marca"));
                  select.setCor(Rs_select.getString("cor"));
                  select.setGenero(Rs_select.getString("genero"));
                  select.setTamanho(Rs_select.getInt("tamanho"));
                  select.setPreco(Rs_select.getDouble("preco"));
                  
                  buscaID.add(select);
              }
          }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return buscaID;
    } // Fim do metodo de select com parametro
    
          public static ArrayList<Produtos> listarMarca(String Marca){
        ArrayList<Produtos> buscaM = new ArrayList(); 
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/lojacalcados";
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM produtos WHERE marca = ?");
           comandoSQL.setString(1,Marca);
           
           // Passo 4 - Executar comando SQL
          ResultSet Rs_select = comandoSQL.executeQuery();
          
          if(Rs_select != null){
              // Percorrendo o result e passando os valores a um obj
              while(Rs_select.next()){
                  Produtos select = new Produtos();
                  select.setQtd(Rs_select.getInt("qtd"));
                  select.setCod_prod(Rs_select.getInt("cod_prod"));
                  select.setModelo(Rs_select.getString("modelo"));
                  select.setMarca(Rs_select.getString("marca"));
                  select.setCor(Rs_select.getString("cor"));
                  select.setGenero(Rs_select.getString("genero"));
                  select.setTamanho(Rs_select.getInt("tamanho"));
                  select.setPreco(Rs_select.getDouble("preco"));
                  
                  buscaM.add(select);
              }
          }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return buscaM;
    } // Fim do metodo de select com parametro
          
     public static boolean alterarP(Produtos alterar){
        boolean Retorno = false;
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lojacalcados";
            
            // Passo 2 - Abrir a conexão
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE produtos SET marca = ?, modelo = ?, "
                  + "cor = ?, genero = ?, tamanho = ?, preco = ?, data = ?, qtd = ? WHERE cod_prod = ?");
           
            // Criar nova instância usando construtor vazio
            Produtos produto = new Produtos();

            // Definir os valores usando os métodos setters
            produto.setMarca(alterar.getMarca());
            produto.setModelo(alterar.getModelo());
            produto.setCor(alterar.getCor());
            produto.setGenero(alterar.getGenero());
            produto.setTamanho(alterar.getTamanho());
            produto.setPreco(alterar.getPreco());
            produto.setData(alterar.getData());
            produto.setQtd(alterar.getQtd());
            produto.setCod_prod(alterar.getCod_prod());
            
            comandoSQL.setString(1, produto.getMarca());
            comandoSQL.setString(2, produto.getModelo()); 
            comandoSQL.setString(3, produto.getCor());
            comandoSQL.setString(4, produto.getGenero());
            comandoSQL.setInt(5, produto.getTamanho());
            comandoSQL.setDouble(6, produto.getPreco());
            comandoSQL.setDate(7, (Date) produto.getData());
            comandoSQL.setInt(8, produto.getQtd());
            comandoSQL.setInt(9, produto.getCod_prod());

            // Passo 4 - Executar comando SQL
           int linhasAfetadas = comandoSQL.executeUpdate();

           if(linhasAfetadas>0){
               Retorno = true;
           }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return Retorno;
    } // Fim do metódo update
     
    public static boolean excluirP(int cod){
        boolean RetornoP = false;
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lojacalcados";
            
            // Passo 2 - Abrir a conexão
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("DELETE FROM produtos WHERE cod_prod =? ");
           comandoSQL.setInt(1, cod);
           
           // Passo 4 - Executar comando SQL
          int linhasAfetadas = comandoSQL.executeUpdate();
          
          if(linhasAfetadas>0){
              RetornoP = true;
          }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return RetornoP;
    } // Fim do metódo delete
    
    static String URL = "jdbc:mysql://localhost:3306/lojacalcados";
    static String Login = "root";
    static String Senha = "";
    
    public static Produtos consultaridNota(int cod) {
        Produtos produtoRetorno = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(URL, Login, Senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM Produtos WHERE cod_prod = ?");
            comandoSQL.setInt(1, cod);
            
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                if (rs .next()) {
                    produtoRetorno = new Produtos();
                    produtoRetorno.setQtd(rs.getInt("qtd"));
                    produtoRetorno.setMarca(rs.getString("marca"));
                    produtoRetorno.setModelo(rs.getString("modelo"));
                    produtoRetorno.setPreco(rs.getDouble("preco"));
                }
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return produtoRetorno;
        
    }
    
    public static boolean alterarQTD(int qtd, int cod){
        boolean Retorno = false;
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/lojacalcados";
            
            // Passo 2 - Abrir a conexão
            conexao = DriverManager.getConnection(url, "root", "");
            
            //Passo 3 - Preparar o comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("UPDATE produtos SET qtd = ? WHERE cod_prod = ?");
           
            // Criar nova instância usando construtor vazio
            Produtos produto = new Produtos();

            // Definir os valores usando os métodos setters
            produto.setQtd(qtd);
            produto.setCod_prod(cod);
            
            comandoSQL.setInt(1, produto.getQtd());
            comandoSQL.setInt(2, produto.getCod_prod());
            
            // Passo 4 - Executar comando SQL
           int linhasAfetadas = comandoSQL.executeUpdate();

           if(linhasAfetadas>0){
               Retorno = true;
           }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return Retorno;
    }//UPDATE de qtd na tabela
}

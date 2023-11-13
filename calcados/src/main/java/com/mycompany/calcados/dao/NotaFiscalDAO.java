/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calcados.dao;

import com.mycompany.calcados.classes.ItemNota;
import com.mycompany.calcados.classes.NotaFiscal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * @see ItemNota.calcados.classes
 * @author kayla
 */
public class NotaFiscalDAO {

    static String URL = "jdbc:mysql://localhost:3306/lojacalcados";
    static String Login = "root";
    static String Senha = "";
    
    /**
     * Metódo que faz dois inserts no banco de dados em tabelas diferentes, com uma tabela dependendo da primary key da outra
     * @param obj tipo NotaFiscal
     * @return 
     */
    public static boolean salvar(NotaFiscal obj) {
        boolean retorno = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(URL, Login, Senha);
            
            PreparedStatement comandoSQL = conexao.prepareStatement("INSERT INTO vendas (total, qtd_prod, data, fk_id_cli) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            
            comandoSQL.setDouble(1, obj.getTotal());
            comandoSQL.setInt(2, obj.getQtdprod());
            comandoSQL.setDate(3, (Date) obj.getData());
            comandoSQL.setInt(4, obj.getId());
            
            int linhasAfetadas = comandoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = comandoSQL.getGeneratedKeys();
                if (rs .next()) {
                    int idNota = rs.getInt(1);
                    for (ItemNota item : obj.getListaItens()) {
                        PreparedStatement comandoSQLItem = conexao.prepareStatement("INSERT INTO Itemnota (idNota, fk_idProd, QTDProd, VLRProd, Marca) VALUES (?,?,?,?,?)");
                        comandoSQLItem.setInt(1, idNota);
                        comandoSQLItem.setInt(2, item.getIdProduto());
                        comandoSQLItem.setInt(3, item.getQtdProduto());
                        comandoSQLItem.setDouble(4,item.getVlrProduto());
                        comandoSQLItem.setString(5,item.getMarca());

                        int linhasAfetadasItem = comandoSQLItem.executeUpdate();
                        if(linhasAfetadasItem>0){
                            retorno = true;
                        }
                    }
                }
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return retorno;
        
    }
    public static ArrayList<NotaFiscal> listarNota(Date dataini, Date datafim){
        ArrayList<NotaFiscal> buscaN = new ArrayList(); 
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/lojacalcados";
            conexao = DriverManager.getConnection(url, "root", "");
            
           //Passo 3 - Preparar o comando SQL
           PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM vendas WHERE data BETWEEN ? AND ?");
           comandoSQL.setDate(1,dataini);
           comandoSQL.setDate(2,datafim);
           
           // Passo 4 - Executar comando SQL
           ResultSet Rs_select = comandoSQL.executeQuery();
          
          if(Rs_select != null){
              // Percorrendo o result e passando os valores a um obj
              while(Rs_select.next()){
                  
                  NotaFiscal select = new NotaFiscal();
                  select.setIdvenda(Rs_select.getInt("id_venda"));
                  select.setId(Rs_select.getInt("fk_id_cli"));
                  select.setQtdprod(Rs_select.getInt("qtd_prod"));
                  select.setData(Rs_select.getDate("data"));
                  select.setTotal((int) Rs_select.getDouble("total"));
                  
                  buscaN.add(select);
              }
          }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return buscaN;
    }
    
        public static ArrayList<ItemNota> listarItemNota(int idVenda){
        ArrayList<ItemNota> buscaItemN = new ArrayList(); 
        Connection conexao = null;
        
        try{
            // Passo 1 - Carregar o drive
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Passo 2 - Abrir a conexão
            String url = "jdbc:mysql://localhost:3306/lojacalcados";
            conexao = DriverManager.getConnection(url, "root", "");
            
           //Passo 3 - Preparar o comando SQL
               PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM itemnota WHERE idNota = ?");
           comandoSQL.setInt(1,idVenda);
           
           // Passo 4 - Executar comando SQL
           ResultSet Rs_select = comandoSQL.executeQuery();
          
          if(Rs_select != null){
              // Percorrendo o result e passando os valores a um obj
              while(Rs_select.next()){
                  
                  ItemNota select = new ItemNota();
                  select.setIdProduto(Rs_select.getInt("fk_idProd"));
                  select.setQtdProduto(Rs_select.getInt("QTDProd"));
                  select.setMarca(Rs_select.getString("Marca"));
                  select.setVlrProduto(Rs_select.getDouble("VLRProd"));
                  
                  buscaItemN.add(select);
              }
          }
            
        } catch (ClassNotFoundException ex) {
           System.out.println("Erro ao carregar o Driver"); 
        } catch (SQLException ex) {
           System.out.println("Erro ao abrir a conexão");
        }
        
        return buscaItemN;
    }
}

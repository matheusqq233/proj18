/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.ProdutoVO;
import persistencia.ConexaoBanco;

/**
 *
 * @author cralves
 */
public class ProdutoDAO {
    
    public void cadastrarProduto(ProdutoVO pVO)throws SQLException{
        //Buscar a conexão como banco de dados
        Connection con = ConexaoBanco.getConexao();
        
        //criar objeto capaz de executar as instruções sql no banco de dados
        Statement stat = con.createStatement();
        
        try{
            //String que recebe a instrução SQL
            String sql;
            
            //Montar a instrução INSERT
            sql = "insert into produto(idproduto, nomepro, valorcusto, quantidade)"
                    + "values(null, '"+ pVO.getNome() +"', "
                    + pVO.getValorCusto() + ", "
                    + pVO.getQuantidade() + ") ";
            //Executar o SQL
            stat.execute(sql);
            
        }catch (SQLException e){
            throw new SQLException("Erro ao inserir produto!");
        }finally{
            con.close();
            stat.close();
        }
        
    }//fecha o método
    
    public ArrayList<ProdutoVO> buscarProduto() throws SQLException{
        
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try{
            String sql;
            sql = "select * from produto";
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<ProdutoVO> pro = new ArrayList<>();
            while(rs.next()){
                ProdutoVO p = new ProdutoVO();
                p.setIdProduto(rs.getInt("idproduto"));
                p.setNome(rs.getString("nomepro"));
                p.setValorCusto(rs.getDouble("valorcusto"));
                p.setQuantidade(rs.getInt("quantidade"));
                
                pro.add(p);
            }//fecha o while
            return pro;
        }catch(SQLException e){
            throw new SQLException("Erro ao buscar produto! " + e.getMessage() );
        }finally{
            con.close();
            stat.close();
        }//fim finally
        
    }//fecha o método buscarProduto
    
    
    public void deletarProduto(int idproduto) throws SQLException{
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try{
            String sql;
            sql ="delete from produto where idproduto = " + idproduto;
            stat.execute(sql);
            
        }catch(SQLException se){
            throw new SQLException("Erro ao deletar produto! " + se.getMessage());
        }finally{
            con.close();
            stat.close();
        }//fim finally
        
    }//fecha o método deletarProduto
    
    public ArrayList<ProdutoVO> filtrarProduto(String query) throws SQLException{
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try{
            String sql;
            sql = "select * from produto " + query;
            ResultSet rs = stat.executeQuery(sql);
            ArrayList<ProdutoVO> pro = new ArrayList<>();
            while(rs.next() ){
                ProdutoVO p = new ProdutoVO();
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nomePro"));
                p.setValorCusto(rs.getDouble("valorCusto"));
                p.setQuantidade(rs.getInt("quantidade"));
                pro.add(p);
            }//fecha o laço while
            
            return pro;
        }catch(SQLException se){
            throw new SQLException("Erro ao filtrar produto! " + se.getMessage() );
        }finally{
            con.close();
            stat.close();
        }
        
    }//fecha o método filtrar
    
}//fecha a classe ProdutoDAO

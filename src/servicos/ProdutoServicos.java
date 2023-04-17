/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

import DAO.DAOFactory;
import DAO.ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ProdutoVO;

/**
 *
 * @author cralves
 */
public class ProdutoServicos {
    
    public void cadastrarProduto(ProdutoVO pVO) throws SQLException{
        ProdutoDAO pDAO = DAOFactory.getProdutoDAO();
        pDAO.cadastrarProduto(pVO);
    }//fim do método cadastrarProduto
    
    public ArrayList<ProdutoVO> buscarProduto() throws SQLException{
        ProdutoDAO pDAO = DAOFactory.getProdutoDAO();
        
        return pDAO.buscarProduto();
    }//fecha o método buscarProduto
    
    public void deletarProduto(int idproduto) throws SQLException{
        ProdutoDAO  pDAO= DAOFactory.getProdutoDAO();
        pDAO.deletarProduto(idproduto);
    }//fecha o método deletarProduto
    
    public ArrayList<ProdutoVO> filtrarProduto(String query) throws SQLException{
        ProdutoDAO pDAO = DAOFactory.getProdutoDAO();
        return pDAO.filtrarProduto(query);
    }//fecha o método
    
    
}//fecha a classe ProdutoServicos

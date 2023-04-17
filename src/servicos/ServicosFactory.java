/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicos;

/**
 *
 * @author cralves
 */
public class ServicosFactory {
    
    private static ProdutoServicos produtoServicos = new ProdutoServicos();
    
    public static ProdutoServicos getProdutoServicos(){
        return produtoServicos;
    }//fecha o método
    
}//fecha a classse ServicosFactory

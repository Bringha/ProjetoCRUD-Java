/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alfashop.controller;

import br.com.alfashop.model.Produto;
import br.com.alfashop.repository.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public class ProdutosExec extends HttpServlet {

    public void inserir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String maisinfo = request.getParameter("maisInfo");
        String svalor = request.getParameter("valor");
        Float valor = Float.parseFloat(svalor);
        String speso = request.getParameter("peso");
        Float peso = Float.parseFloat(speso);
        String destaque = request.getParameter("destaque");
        String ativo = request.getParameter("ativo");
        String sidCategoria = request.getParameter("categoria");
        Long idCategoria = Long.parseLong(sidCategoria);
        
        //criar o objeto Produto
        Produto objPro = new Produto();
        objPro.setNome(nome);
        objPro.setDescricao(descricao);
        objPro.setMaisInfo(maisinfo);
        objPro.setValor(valor);
        objPro.setPeso(peso);
        objPro.setDestaque(destaque);
        objPro.setAtivo(ativo);
        objPro.setIdCategoria(idCategoria);
        //criar o objeto DAO e gravar no banco
        ProdutoDAO objdao = new ProdutoDAO();
        objdao.inserir(objPro);
        //voltar para a lista
        response.sendRedirect("produtos.jsp");
    }

    public void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sidp = request.getParameter("idp");
        Long idp = Long.parseLong(sidp);
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String maisinfo = request.getParameter("maisInfo");
        String svalor = request.getParameter("valor");
        Float valor = Float.parseFloat(svalor);
        String speso = request.getParameter("peso");
        Float peso = Float.parseFloat(speso);
        String destaque = request.getParameter("destaque");
        String ativo = request.getParameter("ativo");
        String sidCategoria = request.getParameter("categoria");
        Long idCategoria = Long.parseLong(sidCategoria);
        
        //criar o objeto Produto
        Produto objPro = new Produto();
        objPro.setIdProduto(idp);
        objPro.setNome(nome);
        objPro.setDescricao(descricao);
        objPro.setMaisInfo(maisinfo);
        objPro.setValor(valor);
        objPro.setPeso(peso);
        objPro.setDestaque(destaque);
        objPro.setAtivo(ativo);
        objPro.setIdCategoria(idCategoria);
        //criar o objeto DAO e gravar no banco
        ProdutoDAO objdao = new ProdutoDAO();
        objdao.atualizar(objPro);
        //voltar para a lista
        response.sendRedirect("produtos.jsp");
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idp = request.getParameter("idPro");
        //criar o objeto Categoria
        Produto objPro = new Produto();
        objPro.setIdProduto(Long.parseLong(idp));
        //criar o objeto DAO e remove do banco
        ProdutoDAO objdao = new ProdutoDAO();
        objdao.excluir(objPro);
        //voltar para a lista
        response.sendRedirect("produtos.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("produtos.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //pegar os parametros enviados do form e verificar se é insert, update ou delete
        String act = request.getParameter("action");
        if (act.equals("insert")) {
            inserir(request, response);
        }

        if (act.equals("update")) {
            atualizar(request, response);
        }

        if (act.equals("delete")) {
          excluir(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alfashop.controller;

import br.com.alfashop.model.Categoria;
import br.com.alfashop.repository.CategoriaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fabio
 */
public class CategoriasExec extends HttpServlet {

    public void inserir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        //criar o objeto Categoria
        Categoria objCat = new Categoria();
        objCat.setNome(nome);
        objCat.setDescricao(descricao);
        objCat.setAtivo("s");
        //criar o objeto DAO e gravar no banco
        CategoriaDAO objdao = new CategoriaDAO();
        objdao.inserir(objCat);
        //voltar para a lista
        response.sendRedirect("categorias.jsp");
    }

    public void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idc = request.getParameter("idc");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String ativo = request.getParameter("ativo");
        //criar o objeto Categoria
        Categoria objCat = new Categoria();
        objCat.setIdCategoria(Long.parseLong(idc));
        objCat.setNome(nome);
        objCat.setNome(nome);
        objCat.setDescricao(descricao);
        objCat.setAtivo(ativo);
        //criar o objeto DAO e gravar no banco
        CategoriaDAO objdao = new CategoriaDAO();
        objdao.atualizar(objCat);
        //voltar para a lista
        response.sendRedirect("categorias.jsp");
    }

    public void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idc = request.getParameter("idCat");
        //criar o objeto Categoria
        Categoria objCat = new Categoria();
        objCat.setIdCategoria(Long.parseLong(idc));
        //criar o objeto DAO e remove do banco
        CategoriaDAO objdao = new CategoriaDAO();
        objdao.excluir(objCat);
        //voltar para a lista
        response.sendRedirect("categorias.jsp");
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
        //processRequest(request, response);
        response.sendRedirect("categorias.jsp");

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

package br.com.alfashop.controller;

import br.com.alfashop.model.Usuario;
import br.com.alfashop.repository.UsuarioDAO;
import br.com.alfashop.util.Util;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fabio
 */
@WebServlet(name = "loginExec", urlPatterns = {"/adm/login-exec"})
public class loginExec extends HttpServlet {

    protected void validarLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        //pegar dados do form
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        senha = Util.sha1(senha);
        
        //montar filtro
        //sql injection
        //senha_incorreta' or 'a' = 'a
        //String filtro = "email = '"+email+"' and senha = '"+senha+"'";
        
        //consultar dados usando uma classe DAO
        UsuarioDAO daoUsuario = new UsuarioDAO();
        List<Usuario> lstusu = daoUsuario.validar(email,senha);
        
        String destino = "";
        String msg = "";
        if(lstusu.size() > 0){
            //se deu certo, vai para a página de administraçao
            Usuario usu = lstusu.get(0); //pega o primeiro usuário da lista
            session.setAttribute("usu", usu); // cria uma variável de sessao com esse objeto usuario
            destino = "dashboard.jsp";
        }
        else{
            //se deu errado, vai para o login com aviso
            msg = "erro";
            destino = "./?msg="+msg;
        }
        response.sendRedirect(destino);
        
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
        HttpSession session = request.getSession();
        session.setAttribute("usu", null);
        session.invalidate();
        response.sendRedirect("index.jsp");
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
        validarLogin(request, response);
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

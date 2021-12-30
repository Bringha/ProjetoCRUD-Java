package br.com.alfashop.repository;

import br.com.alfashop.config.Conex;
import br.com.alfashop.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fabio
 */
public class UsuarioDAO {

    Connection conn;

    /**
     * Método Construtor sempre que criar um objeto, chama esse método
     */
    public UsuarioDAO() {
        //conectar com o banco de dados
        this.conn = Conex.getConnection();

    }

    /**
     * @Return List<Usuario>
     */
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<Usuario>();
        //cria o objeto de manipulaçao dos SQLs
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "select * from usuarios";
            ResultSet rset = stmt.executeQuery(sql);

            while (rset.next()) {
                Usuario obj = new Usuario();
                obj.setIdUsuario(rset.getLong("idusuarios"));
                obj.setNome(rset.getString("nome"));
                obj.setEmail(rset.getString("email"));
                obj.setSenha(rset.getString("senha"));
                //adiciona o obj em uma lista
                lista.add(obj);
            }
            rset.close();
            stmt.close();
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            lista = null;
        }

        return lista;
    }

    /**
     * método para ser usado como JavaBean getUsuario()
     */
    public List<Usuario> getUsuarios() {
        return listar();
    }

    /**
     * @Return Usuario
     */
    public List<Usuario> buscar(String filtro) {
        List<Usuario> lista = new ArrayList<Usuario>();
        //
        //cria o objeto de manipulaçao dos SQLs
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "select * from usuarios where " + filtro;
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                Usuario obj = new Usuario();
                obj.setIdUsuario(rset.getLong("idusuarios"));
                obj.setNome(rset.getString("nome"));
                obj.setEmail(rset.getString("email"));
                obj.setSenha(rset.getString("senha"));
                //adiciona o obj em uma lista
                lista.add(obj);
            }
            rset.close();
            stmt.close();
            this.conn.close();
        } catch (Exception e) {
            lista = null;
        }

        return lista;
    }

    public List<Usuario> validar(String email, String senha) {
        List<Usuario> lista = new ArrayList<Usuario>();
        //
        //cria o objeto de manipulaçao dos SQLs
        try {
            String sql = "select * from usuarios where email=? and senha=?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rset = stmt.executeQuery();
            while (rset.next()) {
                Usuario obj = new Usuario();
                obj.setIdUsuario(rset.getLong("idusuarios"));
                obj.setNome(rset.getString("nome"));
                obj.setEmail(rset.getString("email"));
                obj.setSenha(rset.getString("senha"));
                //adiciona o obj em uma lista
                lista.add(obj);
            }
            rset.close();
            stmt.close();
            this.conn.close();
        } catch (Exception e) {
            lista = null;
        }

        return lista;
    }
    
    /**
     * método para cadastrar um novo curso
     *
     * @param obj
     */
    public int inserir(Usuario obj) {
        int res = 0;
        String nom = obj.getNome();
        String ema = obj.getEmail();
        String sen = obj.getSenha();
        String sql = "insert into usuarios (nome, email, senha) values (?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, ema);
            stmt.setString(3, sen);
            res = stmt.executeUpdate();
            stmt.close();
            this.conn.close();
        } catch (Exception e) {
            res = 0;
        }
        return res;
    }

    /**
     * método para atualizar um novo específico
     *
     * @param obj
     */
    public int atualizar(Usuario obj) {
        int res = 0;
        Long id = obj.getIdUsuario();
        String nom = obj.getNome();
        String ema = obj.getEmail();
        String sen = obj.getSenha();
        String sql = "update usuarios set nome=?, email=?, senha=? where idusuarios=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, ema);
            stmt.setString(3, sen);
            stmt.setLong(4, id);
            res = stmt.executeUpdate();
            stmt.close();
            this.conn.close();
        } catch (Exception e) {
            res = 0;
        }
        return res;
    }

    /**
     * método para excluir um novo específico
     *
     * @param obj
     */
    public int excluir(Usuario obj) {
        int res = 0;
        Long id = obj.getIdUsuario();
        String sql = "delete from usuarios where idusuarios=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setLong(1, id);
            res = stmt.executeUpdate();
            stmt.close();
            this.conn.close();
        } catch (Exception e) {
            res = 0;
        }
        return res;
    }

}

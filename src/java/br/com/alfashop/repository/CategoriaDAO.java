package br.com.alfashop.repository;

import br.com.alfashop.config.Conex;
import br.com.alfashop.model.Categoria;
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
public class CategoriaDAO {
    
    Connection conn;

    /**
     * Método Construtor sempre que criar um objeto, chama esse método
     */
    public CategoriaDAO() {
        //conectar com o banco de dados
        this.conn = Conex.getConnection();
        
    }

    /**
     * @Return List<Categoria>
     */
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<Categoria>();
        //cria o objeto de manipulaçao dos SQLs
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "select * from categorias";
            ResultSet rset = stmt.executeQuery(sql);

            while (rset.next()) {
                Categoria obj = new Categoria();
                obj.setIdCategoria(rset.getLong("idcategorias"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setAtivo(rset.getString("ativo"));
                //adiciona o obj em uma lista
                lista.add(obj);
            }
            rset.close();
            stmt.close();
            this.conn.close();
        }catch(Exception e){
            e.printStackTrace();
            lista = null;
        }

        return lista;
    }
    
    /**
     * método para ser usado como JavaBean getCategoria()
     */
    public List<Categoria> getCategorias(){
        return listar();
    }
    
    /**
     * @Return Categoria
     */
    public List<Categoria> buscar(String filtro) {
        List<Categoria> lista = new ArrayList<Categoria>();
        //cria o objeto de manipulaçao dos SQLs
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "select * from categorias where "+filtro;
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                Categoria obj = new Categoria();
                obj.setIdCategoria(rset.getLong("idcategorias"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setAtivo(rset.getString("ativo"));
                //adiciona o obj em uma lista
                lista.add(obj);
            }
            rset.close();
            stmt.close();
            this.conn.close();
        }catch(Exception e){
            e.printStackTrace();
            lista = null;
        }

        return lista;
    }
    
    /**
     * @Return Categoria
     */
    public Categoria buscarPorId(Long id) {
        Categoria obj = new Categoria();
        //cria o objeto de manipulaçao dos SQLs
        try {
            
            String sql = "select * from categorias where idcategorias =?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setLong(1, id); 
            ResultSet rset = stmt.executeQuery();
            if (rset.next()) {
                obj.setIdCategoria(rset.getLong("idcategorias"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setAtivo(rset.getString("ativo"));
            }
            rset.close();
            stmt.close();
            this.conn.close();
        }catch(Exception e){
            e.printStackTrace();
            obj = null;
        }

        return obj;
    }

    /**
     * método para cadastrar um novo curso
     *
     * @param obj
     */
    public int inserir(Categoria obj) {
        int res = 0;
        String nom = obj.getNome();
        String des = obj.getDescricao();
        String ati = obj.getAtivo();
        String sql = "insert into categorias (nome, descricao, ativo) values (?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, des);
            stmt.setString(3, ati);
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
    public int atualizar(Categoria obj) {
        int res = 0;
        Long id = obj.getIdCategoria();
        String nom = obj.getNome();
        String des = obj.getDescricao();
        String ati = obj.getAtivo();
        String sql = "update categorias set nome=?, descricao=?, ativo=? where idcategorias=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, des);
            stmt.setString(3, ati);
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
    public int excluir(Categoria obj) {
        int res = 0;
        Long id = obj.getIdCategoria();
        String sql = "delete from categorias where idcategorias=?";
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

package br.com.alfashop.repository;

import br.com.alfashop.config.Conex;
import br.com.alfashop.model.Produto;
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
public class ProdutoDAO {

    Connection conn;

    /**
     * Método Construtor sempre que criar um objeto, chama esse método
     */
    public ProdutoDAO() {
        //conectar com o banco de dados
        this.conn = Conex.getConnection();

    }

    /**
     * @Return List<Produto>
     */
    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<Produto>();
        //cria o objeto de manipulaçao dos SQLs
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "select * from produtos";
            ResultSet rset = stmt.executeQuery(sql);

            while (rset.next()) {
                Produto obj = new Produto();
                obj.setIdProduto(rset.getLong("idprodutos"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setMaisInfo(rset.getString("maisinfo"));
                obj.setValor(rset.getFloat("valor"));
                obj.setPeso(rset.getFloat("peso"));
                obj.setDestaque(rset.getString("destaque"));
                obj.setAtivo(rset.getString("ativo"));
                obj.setIdCategoria(rset.getLong("categorias_idcategorias"));
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
     * método para ser usado como JavaBean getProduto()
     */
    public List<Produto> getProdutos() {
        return listar();
    }

    /**
     * @Return List<Produto>
     */
    public List<Produto> listarDestaques() {
        List<Produto> lista = new ArrayList<Produto>();
        //cria o objeto de manipulaçao dos SQLs
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "select * from produtos where destaque='s'";
            ResultSet rset = stmt.executeQuery(sql);

            while (rset.next()) {
                Produto obj = new Produto();
                obj.setIdProduto(rset.getLong("idprodutos"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setMaisInfo(rset.getString("maisinfo"));
                obj.setValor(rset.getFloat("valor"));
                obj.setPeso(rset.getFloat("peso"));
                obj.setDestaque(rset.getString("destaque"));
                obj.setAtivo(rset.getString("ativo"));
                obj.setIdCategoria(rset.getLong("categorias_idcategorias"));
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

    public List<Produto> getDestaques() {
        //return listarDestaques();
        return buscar("destaque='s'");
    }

    /**
     * @Return Produto
     */
    public List<Produto> buscar(String filtro) {
        List<Produto> lista = new ArrayList<Produto>();
        //
        //cria o objeto de manipulaçao dos SQLs
        try {
            Statement stmt = this.conn.createStatement();
            String sql = "select p.*, c.nome as nomecat from produtos p "
                    + "inner join categorias c on c.idcategorias = p.categorias_idcategorias "
                    + "where " + filtro;
            ResultSet rset = stmt.executeQuery(sql);
            while (rset.next()) {
                Produto obj = new Produto();
                obj.setIdProduto(rset.getLong("idprodutos"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setMaisInfo(rset.getString("maisinfo"));
                obj.setValor(rset.getFloat("valor"));
                obj.setPeso(rset.getFloat("peso"));
                obj.setDestaque(rset.getString("destaque"));
                obj.setAtivo(rset.getString("ativo"));
                obj.setIdCategoria(rset.getLong("categorias_idcategorias"));
                obj.setNomeCat(rset.getString("nomecat"));
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
     * @Return Produto
     */
    public Produto buscarPorId(Long id) {
        
        Produto obj = new Produto();
        //cria o objeto de manipulaçao dos SQLs
        try {
            
            String sql = "select * from produtos where idprodutos =?";
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setLong(1, id); 
            ResultSet rset = stmt.executeQuery();
            
            if (rset.next()) {
                obj.setIdProduto(rset.getLong("idprodutos"));
                obj.setNome(rset.getString("nome"));
                obj.setDescricao(rset.getString("descricao"));
                obj.setMaisInfo(rset.getString("maisinfo"));
                obj.setValor(rset.getFloat("valor"));
                obj.setPeso(rset.getFloat("peso"));
                obj.setDestaque(rset.getString("destaque"));
                obj.setAtivo(rset.getString("ativo"));
                obj.setIdCategoria(rset.getLong("categorias_idcategorias"));
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
    public int inserir(Produto obj) {
        int res = 0;
        String nom = obj.getNome();
        String des = obj.getDescricao();
        String maisinfo = obj.getMaisInfo();
        Float valor = obj.getValor();
        Float peso = obj.getPeso();
        String destaque = obj.getDestaque();
        String ati = obj.getAtivo();
        Long idcat = obj.getIdCategoria();
        String sql = "insert into produtos (nome, descricao, maisinfo, valor, peso, destaque, ativo, categorias_idcategorias) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, des);
            stmt.setString(3, maisinfo);
            stmt.setFloat(4, valor);
            stmt.setFloat(5, peso);
            stmt.setString(6, destaque);
            stmt.setString(7, ati);
            stmt.setLong(8, idcat);
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
    public int atualizar(Produto obj) {
        int res = 0;
        Long id = obj.getIdProduto();
        String nom = obj.getNome();
        String des = obj.getDescricao();
        String maisinfo = obj.getMaisInfo();
        Float valor = obj.getValor();
        Float peso = obj.getPeso();
        String destaque = obj.getDestaque();
        String ati = obj.getAtivo();
        Long idcat = obj.getIdCategoria();
        String sql = "update produtos set nome=?, descricao=?, maisinfo=?, valor=?, peso=?, destaque=?, ativo=?, categorias_idcategorias=? where idprodutos=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, nom);
            stmt.setString(2, des);
            stmt.setString(3, maisinfo);
            stmt.setFloat(4, valor);
            stmt.setFloat(5, peso);
            stmt.setString(6, destaque);
            stmt.setString(7, ati);
            stmt.setLong(8, idcat);
            stmt.setLong(9, id);
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
    public int excluir(Produto obj) {
        int res = 0;
        Long id = obj.getIdProduto();
        String sql = "delete from produtos where idprodutos=?";
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

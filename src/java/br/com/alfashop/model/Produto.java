package br.com.alfashop.model;

/**
 *
 * @author fabio
 */
public class Produto {

    private Long idProduto;
    private String nome;
    private String descricao;
    private String maisInfo;
    private Float valor;
    private Float peso;
    private String destaque;
    private String ativo;
    private Long idCategoria;
    private String nomeCat;

    /**
     * @return the idProduto
     */
    public Long getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the maisInfo
     */
    public String getMaisInfo() {
        return maisInfo;
    }

    /**
     * @param maisInfo the maisInfo to set
     */
    public void setMaisInfo(String maisInfo) {
        this.maisInfo = maisInfo;
    }

    /**
     * @return the valor
     */
    public Float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Float valor) {
        this.valor = valor;
    }

    /**
     * @return the peso
     */
    public Float getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Float peso) {
        this.peso = peso;
    }

    /**
     * @return the destaque
     */
    public String getDestaque() {
        return destaque;
    }

    /**
     * @param destaque the destaque to set
     */
    public void setDestaque(String destaque) {
        this.destaque = destaque;
    }

    /**
     * @return the ativo
     */
    public String getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    /**
     * @return the idCategoria
     */
    public Long getIdCategoria() {
        return idCategoria;
    }

    /**
     * @param idCategoria the idCategoria to set
     */
    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * @return the nomeCat
     */
    public String getNomeCat() {
        return nomeCat;
    }

    /**
     * @param nomeCat the nomeCat to set
     */
    public void setNomeCat(String nomeCat) {
        this.nomeCat = nomeCat;
    }

    
}

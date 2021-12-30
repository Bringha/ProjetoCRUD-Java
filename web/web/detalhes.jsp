<%@include file="./_inc/_header.jsp" %>
<%@include file="./_inc/_menu.jsp" %>

<%@page import="java.util.List"%>
<%@page import="br.com.alfashop.model.Categoria"%>
<%@page import="br.com.alfashop.repository.CategoriaDAO"%>
<%@page import="br.com.alfashop.model.Produto"%>
<%@page import="br.com.alfashop.repository.ProdutoDAO" %>
<%
    String filtro = "1 != 1";
    Long idp = 0L;
    /*
    Pegar o parametro "idc" que veio na URL (id da categoria)
    criar um objeto DAO para consultar por ID de categoria
    usar o retorno (lista) para exibir os dados (nesse caso, sem fazer uso do <jsp:useBean>
     */
    if (request.getParameter("idp") != null) {
        String sidp = request.getParameter("idp");

        try {
            idp = Long.parseLong(sidp);
            filtro = "idprodutos = " + idp;
        } catch (Exception e) {
        }
    }

    ProdutoDAO daopro = new ProdutoDAO();
    List<Produto> lstpro = daopro.buscar(filtro);
// adicionar o objeto a um atributo da página, para ser usado no EL (Expression Language)
    pageContext.setAttribute("lstpro", lstpro);
%>

<c:forEach items="${lstpro}" var="objProduto">


    <div class="container px-4 py-4" id="custom-cards">
        <h2 class="pb-2 border-bottom">Produtos da Categoria: ${objProduto.nome}</h2>
        <div class="row row-cols-1 row-cols-lg-3 align-items-stretch g-4 py-5">

            ${objProduto.descricao}
            <br><br>
            ${objProduto.maisInfo}
            <br><br>
            ${objProduto.valor}
            
        </div>
    </div>
</c:forEach>

<%@include file="./_inc/_footer.jsp" %>
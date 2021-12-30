<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="_inc/_verificasession.jsp" %>
<%@include file="_inc/_header.jsp" %>
<%@page import="br.com.alfashop.repository.ProdutoDAO" %>
<%@page import="br.com.alfashop.model.Produto" %>
<%@page import="br.com.alfashop.repository.CategoriaDAO" %>
<%@page import="br.com.alfashop.model.Categoria" %>
<%
    String sidPro = request.getParameter("idPro");
    Long idPro = Long.parseLong(sidPro);
    ProdutoDAO prodao = new ProdutoDAO();
    Produto objpro = prodao.buscarPorId(idPro);
    CategoriaDAO daocat = new CategoriaDAO();
    List<Categoria> lstcat = daocat.getCategorias();
    
    //teste para o checked do radio (ativo s ou n)
    String chksim = "";
    if(objpro.getAtivo().equals("s")){
        chksim = "checked='checked'";
    }
    String chknao = "";
    if(objpro.getAtivo().equals("n")){
        chknao = "checked='checked'";
    }
    
    String chksim2 = "";
    if(objpro.getDestaque().equals("s")){
        chksim2 = "checked='checked'";
    }
    String chknao2 = "";
    if(objpro.getDestaque().equals("n")){
        chknao2 = "checked='checked'";
    }
    
    pageContext.setAttribute("chksim", chksim);
    pageContext.setAttribute("chknao", chknao);
    pageContext.setAttribute("chksim2", chksim2);
    pageContext.setAttribute("chknao2", chknao2);
    pageContext.setAttribute("objpro", objpro);
    pageContext.setAttribute("cat", lstcat);
%>

<div class="container">
    <div class="row">
        <%@include file="_inc/_menu.jsp" %>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h2>Atualizar Produto</h2>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <a href="produtos.jsp" type="button" class="btn btn-info">
                        Voltar
                    </a>
                </div>
            </div>            
            
            <div class="table-responsive">
                <form action="produtos-exec" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="idp" value="${objpro.idProduto}">
                    <div class="mb-3">
                        <label for="InputNome" class="form-label">Nome</label>
                        <input type="text" name="nome" class="form-control" value="${objpro.nome}">
                    </div>

                    <div class="mb-3">
                        <label for="InputDescricao" class="form-label">Descricao</label>
                        <textarea name="descricao" class="form-control">${objpro.descricao}</textarea>
                    </div>
                    
                    <div class="mb-3">
                        <label for="InputMaisInfo" class="form-label">Mais Info</label>
                        <textarea name="maisInfo" class="form-control">${objpro.maisInfo}</textarea>
                    </div>
                    
                    <div class="mb-3">
                        <label for="InputValor" class="form-label">Valor</label>
                        <input type="text" name="valor" class="form-control" value="${objpro.valor}">
                    </div>
                    
                    <div class="mb-3">
                        <label for="InputPesor" class="form-label">Peso</label>
                        <input type="text" name="peso" class="form-control" value="${objpro.peso}">
                    </div>
                    
                    <div class="mb-3">
                        <label for="InputDestaque" class="form-label">Destaque: </label>
                        <input type="radio" name="destaque" value="s" ${chksim2} >Sim
                        <input type="radio" name="destaque" value="n" ${chknao2} >Nao
                    </div>
                    
                    <div class="mb-3">
                        <label for="InputAtivo" class="form-label">Ativo: </label>
                        <input type="radio" name="ativo" value="s" ${chksim} >Sim
                        <input type="radio" name="ativo" value="n" ${chknao} >Nao
                    </div>
                    
                    <div class="mb-3">
                        <label for="InputCategoria" class="form-label">Categoria:</label>
                        <select id="categoria" name="categoria" class="form-select">
                            <option value="${objpro.idCategoria}">${objpro.idCategoria} - 
                                <c:forEach items="${cat}" var="objCat">
                                    <c:if test="${objCat.idCategoria == objpro.idCategoria}">
                                        ${objCat.nome}
                                    </c:if>
                                </c:forEach>
                            </option>
                            <c:forEach items="${cat}" var="objCat">
                                <option value="${objCat.idCategoria}">${objCat.idCategoria} - ${objCat.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <button class="btn btn-success">Atualizar</button>                
                </form>
            </div>
        </main>
    </div>
</div>


<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
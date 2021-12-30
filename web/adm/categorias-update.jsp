<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="_inc/_verificasession.jsp" %>
<%@include file="_inc/_header.jsp" %>
<%@page import="br.com.alfashop.repository.CategoriaDAO" %>
<%@page import="br.com.alfashop.model.Categoria" %>
<%
    String sidCat = request.getParameter("idCat");
    Long idCat = Long.parseLong(sidCat);
    CategoriaDAO objdao = new CategoriaDAO();
    Categoria objcat = objdao.buscarPorId(idCat);
    
    //teste para o checked do radio (ativo s ou n)
    String chksim = "";
    if(objcat.getAtivo().equals("s")){
        chksim = "checked='checked'";
    }
    String chknao = "";
    if(objcat.getAtivo().equals("n")){
        chknao = "checked='checked'";
    }
    
    pageContext.setAttribute("objcat", objcat);
    pageContext.setAttribute("chksim", chksim);
    pageContext.setAttribute("chknao", chknao);
    
%>

<div class="container">
    <div class="row">
        <%@include file="_inc/_menu.jsp" %>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h2>Atualizar Categoria</h2>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <a href="categorias.jsp" type="button" class="btn btn-info">
                        Voltar
                    </a>
                </div>
            </div>
            
            <div class="table-responsive">
                <form action="categorias-exec" method="post">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="idc" value="${objcat.idCategoria}">
                    <div class="mb-3">
                        <label for="InputNome" class="form-label">Nome</label>
                        <input type="text" name="nome" class="form-control" value="${objcat.nome}">
                    </div>

                    <div class="mb-3">
                        <label for="InputDescricao" class="form-label">Descricao</label>
                        <textarea name="descricao" class="form-control">${objcat.descricao}</textarea>
                    </div>
                    
                    <div class="mb-3">
                        <label for="InputAtivo" class="form-label">Ativo: </label>
                        <input type="radio" name="ativo" value="s" ${chksim} >Sim
                        <input type="radio" name="ativo" value="n" ${chknao}>Nao
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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="_inc/_verificasession.jsp" %>
<%@include file="_inc/_header.jsp" %>

<div class="container">
    <div class="row">
        <%@include file="_inc/_menu.jsp" %>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h2>Cadastrar Categoria</h2>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <a href="categorias.jsp" type="button" class="btn btn-info">
                        Voltar
                    </a>
                </div>
            </div>

            <div class="table-responsive">
                <form action="categorias-exec" method="post">
                    <input type="hidden" name="action" value="insert">
                    <div class="mb-3">
                        <label for="InputNome" class="form-label">Nome</label>
                        <input type="text" name="nome" class="form-control">
                    </div>

                    <div class="mb-3">
                        <label for="InputDescricao" class="form-label">Descricao</label>
                        <textarea name="descricao" class="form-control"></textarea>
                    </div>

                    <button class="btn btn-success">Cadastrar</button>                
                </form>
            </div>
        </main>
    </div>
</div>


<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
</body>
</html>
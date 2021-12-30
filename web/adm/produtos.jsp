<%@include file="_inc/_verificasession.jsp" %>
<%@include file="_inc/_header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean class="br.com.alfashop.repository.ProdutoDAO" id="lstPro"/>
<div class="container">
    <div class="row">
        <%@include file="_inc/_menu.jsp" %>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h2>Lista de Produtos</h2>
                <div class="btn-toolbar mb-2 mb-md-0">
                    <a href="produtos-insert.jsp" type="button" class="btn btn-primary">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z"/>
                        </svg>Produto
                    </a>
                </div>
            </div>


            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th scope="col">Código</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Valor</th>
                            <th scope="col">Peso</th>
                            <th scope="col">Destaque</th>
                            <th scope="col">Ativo</th>
                            <th scope="col">Opçoes</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${lstPro.produtos}" var="objpro">

                            <tr>
                                <td>${objpro.idProduto}</td>
                                <td>${objpro.nome}</td>
                                <td>R$ ${objpro.valor}</td>
                                <td>${objpro.peso} kg</td>
                                <td>${objpro.destaque}</td>
                                <td>${objpro.ativo}</td>
                                <td>
                                    <a href="produtos-update.jsp?idPro=${objpro.idProduto}" class="btn btn-warning">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                        </svg>
                                    </a>

                                    <form action="produtos-exec" method="post" class="float-end" id="fdel${objpro.idProduto}">
                                        <input type="hidden" name="action" value="delete">
                                            <input type="hidden" name="idPro" value="${objpro.idProduto}">
                                                <button class="btn btn-danger" type="button" onclick="avisoDel('${objpro.nome}', '${objpro.idProduto}');">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                                        <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                                    </svg>
                                                </button>
                                                </form>
                                                </td>
                                                </tr>

                                            </c:forEach>

                                            </tbody>
                                            </table>
                                            </div>
                                            </main>
                                            </div>
                                            </div>


                                            <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>

                                            <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
                                            <script type="text/javascript">
                                                    function avisoDel(nome, idc) {
                                                        var ok = confirm("Tem certeza que deseja excluir o produto " + nome + "?");
                                                        if (ok) {
                                                            var div = document.getElementById("fdel" + idc).submit();
                                                        }
                                                    }
                                            </script>
                                            </body>
                                            </html>
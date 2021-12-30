<%-- 
    Document   : _menu
    Created on : 12/12/2021, 09:49:30
    Author     : fabio
--%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
                <div class="container">
                    <div class="collapse navbar-collapse">
                        <ul class="navbar-nav">
                            <jsp:useBean class="br.com.alfashop.repository.CategoriaDAO" id="listaCategorias" />
                            <c:forEach items="${listaCategorias.categorias}" var="objCategoria">

                                <li class="nav-item">
                                    <a class="nav-link" href="produtos.jsp?idc=${objCategoria.idCategoria}">${objCategoria.nome}</a>
                                </li>

                            </c:forEach>

                        </ul>
                    </div>
                </div>
            </nav>
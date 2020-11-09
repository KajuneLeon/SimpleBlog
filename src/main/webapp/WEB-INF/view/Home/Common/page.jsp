<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">

        <%-- 首页 --%>
        <c:if test="${pageInfo.pageNum==1}">
            <li class="page-item disabled">
                <a class="page-link disabled" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${pageInfo.pageNum!=1}">
            <li class="page-item">
                <a class="page-link disabled" href="${url}1" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>

        <%-- 当前页 --%>
        <c:forEach items="${pageInfo.navigatepageNums}" var="navPN">
            <c:if test="${navPN==pageInfo.pageNum}">
                <li class="page-item active">
                    <span class="page-link">
                        ${navPN}
                        <span class="sr-only">(current)</span>
                    </span>
                </li>
            </c:if>
            <c:if test="${navPN!=pageInfo.pageNum}">
                <li class="page-item"><a class="page-link" href="${url}${navPN}">${navPN}</a></li>
            </c:if>
        </c:forEach>



        <%--<li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>--%>

        <%-- 末页 --%>
        <c:if test="${pageInfo.pageNum==pageInfo.pages}">
            <li class="page-item disabled">
                <a class="page-link" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${pageInfo.pageNum!=pageInfo.pages}">
            <li class="page-item">
                <a class="page-link" href="${url}${pageInfo.pages}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>

    </ul>
</nav>

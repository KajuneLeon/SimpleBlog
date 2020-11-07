<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav aria-label="Page navigation">
    <ul class="pagination">

        <%--首页--%>
        <c:if test="${pageInfo.pageNum==1}">
            <li id="firstPageNav" class="disabled">
                <a aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${pageInfo.pageNum!=1}">
            <li id="firstPageNav">
                <a href="${url}1" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>

        <%-- 当前标签页--%>
        <c:forEach items="${pageInfo.navigatepageNums}" var="navPN">
            <c:if test="${navPN==pageInfo.pageNum}">
                <li class="active"><a>${navPN}</a></li>
            </c:if>
            <c:if test="${navPN!=pageInfo.pageNum}">
                <li><a href="${url}${navPN}">${navPN}</a></li>
            </c:if>
        </c:forEach>

        <%--末页--%>
        <c:if test="${pageInfo.pageNum==pageInfo.pages}">
            <li id="lastPageNav" class="disabled">
                <a aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>
        <c:if test="${pageInfo.pageNum!=pageInfo.pages}">
            <li id="lastPageNav">
                <a href="${url}${pageInfo.pages}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>

    </ul>
</nav>
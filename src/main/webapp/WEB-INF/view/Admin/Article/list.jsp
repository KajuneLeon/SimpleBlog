<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 重写siteContent--%>
<%-- 文章列表 --%>
<rapid:override name="siteContent">
    <div class="container">
        <div style="font-size: 50px; color: white; text-align: center">全部文章</div>
        <div class="container tableContainer">
            <div class="form-group"></div>
            <table class="table table-hover">
                <tr class="active">
                    <th>id</th>
                    <th>标题</th>
                    <th>分类</th>
                    <th>状态</th>
                    <th>更新</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${pageInfo.list}" var="article">
                    <tr>
                        <td>${article.articleId}</td>
                        <td>${article.articleTitle}</td>
                        <c:forEach items="${categories}" var="category">
                            <c:if test="${article.articleCategoryId==category.categoryId}">
                                <td>${category.categoryName}</td>
                            </c:if>
                        </c:forEach>
                        <c:if test="${article.articleStatus==0}">
                            <td>草稿</td>
                        </c:if>
                        <c:if test="${article.articleStatus!=0}">
                            <td>发布</td>
                        </c:if>
                        <td>${article.articleDate}</td>
                        <td>
                            <a class="btn btn-success" href="/admin/article/modify/${article.articleId}">编辑</a>
                            <a class="btn btn-danger delete-btn" href="/admin/article/delete/${article.articleId}/${pageInfo.pageNum}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="text-center">
                <%@include file="../Common/page.jsp"%>
            </div>
        </div>
        <br/><br/><br/>
    </div>

    <script type="text/javascript">
        $(".delete-btn").click(function () {
            return confirm("确定删除 [" + $(this).parent().parent().find(":first").next().text() + "]? ");
        })
    </script>

</rapid:override>

<%@ include file="../homepage.jsp" %>

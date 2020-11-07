<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 重写siteContent--%>
<%-- 分类列表 --%>
<rapid:override name="siteContent">
    <div class="container">
        <div style="font-size: 50px; color: white; text-align: center">全部分类</div>
        <div class="container tableContainer">
            <div class="col-sm-12 col-md-3">
                <form action="/admin/category/submitCategory" method="post">
                    <h3>添加一级分类</h3>
                    <div class="form-group">
                        <label for="firstCategory">一级分类</label>
                        <input id="firstCategory" class="form-control" value="${firstCategoryInfo.categoryName}" name="categoryName"/>
                    </div>
                    <input type="hidden" value="${firstCategoryInfo.categoryId}" name="categoryId"/>
                    <input type="hidden" value="${firstCategoryInfo.categoryPId}" name="categoryPId">
                    <c:if test="${empty firstCategoryInfo}">
                        <input type="hidden" name="_method" value="POST"/>
                    </c:if>
                    <c:if test="${not empty firstCategoryInfo}">
                        <input type="hidden" name="_method" value="PUT"/>
                        <input type="hidden" name="pn" value="${pageInfo.pageNum}">
                    </c:if>
                    <input type="submit" class="btn btn-success" value="保存"/>
                </form>
                <form action="/admin/category/submitCategory" method="post">
                    <h3>添加二级分类</h3>
                    <div class="form-group">
                        <label for="parentCategory">一级分类</label>
                        <select id="parentCategory" class="form-control" name="categoryPId">
                            <option>---请选择一级分类---</option>
                            <c:forEach items="${firstCategories}" var="category">
                                <c:if test="${category.categoryId==secondCategoryInfo.categoryPId}">
                                    <option value="${category.categoryId}" selected>${category.categoryName}</option>
                                </c:if>
                                <c:if test="${category.categoryId!=secondCategoryInfo.categoryPId}">
                                    <option value="${category.categoryId}">${category.categoryName}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="secondCategory">二级分类</label>
                        <input id="secondCategory" class="form-control" value="${secondCategoryInfo.categoryName}" name="categoryName"/>
                    </div>
                    <input type="hidden" value="${secondCategoryInfo.categoryId}" name="categoryId">
                    <c:if test="${empty secondCategoryInfo}">
                        <input type="hidden" name="_method" value="POST"/>
                    </c:if>
                    <c:if test="${not empty secondCategoryInfo}">
                        <input type="hidden" name="_method" value="PUT"/>
                        <input type="hidden" name="pn" value="${pageInfo.pageNum}">
                    </c:if>
                    <input type="submit" class="btn btn-success" value="保存"/>
                </form>
            </div>
            <div class="col-sm-12 col-md-1"></div>
            <div class="col-sm-12 col-md-8 catContainer">
                <div class="form-group"></div>
                <table class="table table-hover">
                    <tr class="active">
                        <th>id</th>
                        <th>pid</th>
                        <th>分类名</th>
                        <th>文章数</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${pageInfo.list}" var="category">
                        <tr>
                            <td>${category.categoryId}</td>
                            <td>${category.categoryPId}</td>
                            <td>${category.categoryName}</td>
                            <td>#count</td>
                            <td>
                                <a class="btn btn-success" href="/admin/category/edit/${category.categoryId}/${pageInfo.pageNum}">编辑</a>
                                <a class="btn btn-danger delete-btn" href="/admin/category/delete/${category.categoryId}/${pageInfo.pageNum}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="text-center">
                    <%@include file="../Common/page.jsp"%>
                </div>
            </div>
        </div>
        <br/><br/><br/>
    </div>

    <script type="text/javascript">
        $(".delete-btn").click(function () {
            return confirm("确定删除 [" + $(this).parent().parent().find(":first").next().next().text() + "] ? 若删除的是一级标签，所有二级标签均会被删除");
        })
    </script>

</rapid:override>

<%@ include file="../homepage.jsp" %>

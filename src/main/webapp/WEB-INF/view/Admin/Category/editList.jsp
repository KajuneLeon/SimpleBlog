<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 重写siteContent--%>
<%-- 分类列表 --%>
<rapid:override name="siteContent">
    <div class="container">
        <div style="font-size: 50px; color: white; text-align: center">全部分类</div>
        <div class="container tableContainer">
            <div class="col-sm-12 col-md-3">
                <form action="#" method="post">
                    <h3>添加一级分类</h3>
                    <div class="form-group">
                        <label for="firstCategory">一级分类</label>
                        <input id="firstCategory" class="form-control" value="" name="categoryName"/>
                    </div>
                    <input type="submit" class="btn btn-success" value="保存"/>
                </form>
                <form action="#" method="post">
                    <h3>添加二级分类</h3>
                    <div class="form-group">
                        <label for="parentCategory">一级分类</label>
                        <select id="parentCategory" class="form-control" name="parentCategory">
                            <option selected="selected">---请选择一级类---</option>
                            <option>Java</option>
                            <option>2</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="secondCategory">二级分类</label>
                        <input id="secondCategory" class="form-control" value="" name="categoryName"/>
                    </div>
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
                        <th>一级分类</th>
                        <th>二级分类</th>
                        <th>文章数</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach begin="1" end="10">
                        <tr>
                            <td>#id</td>
                            <td>#pid</td>
                            <td>#pCategory</td>
                            <td>#category</td>
                            <td>#count</td>
                            <td>
                                <a class="btn btn-success" href="#">编辑</a>
                                <a class="btn btn-danger" href="#">删除</a>
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
</rapid:override>

<%@ include file="../homepage.jsp" %>

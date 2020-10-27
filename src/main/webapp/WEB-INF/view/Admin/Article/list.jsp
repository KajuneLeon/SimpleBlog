<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

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
                <tr>
                    <td>#id</td>
                    <td>#theme</td>
                    <td>#class</td>
                    <td>#status</td>
                    <td>#date</td>
                    <td>
                        <a class="btn btn-success" href="#">编辑</a>
                        <a class="btn btn-danger" href="#">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>#id</td>
                    <td>#theme</td>
                    <td>#class</td>
                    <td>#status</td>
                    <td>#date</td>
                    <td>
                        <a class="btn btn-success" href="#">编辑</a>
                        <a class="btn btn-danger" href="#">删除</a>
                    </td>
                </tr>
                <tr>
                    <td>#id</td>
                    <td>#theme</td>
                    <td>#class</td>
                    <td>#status</td>
                    <td>#date</td>
                    <td>
                        <a class="btn btn-success" href="#">编辑</a>
                        <a class="btn btn-danger" href="#">删除</a>
                    </td>
                </tr>
            </table>
            <div class="text-center">
                <%@include file="../Common/page.jsp"%>
            </div>
        </div>
        <br/><br/><br/>
    </div>
</rapid:override>

<%@ include file="../homepage.jsp" %>

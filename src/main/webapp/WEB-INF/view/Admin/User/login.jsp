<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<%-- 重写siteContent --%>
<%-- 用户登录页 --%>
<rapid:override name="siteContent">
    <div class="container">
        <div style="font-size: 50px; color: white; text-align: center">登录</div>
        <div class="container userContainer">
            <form action="#" method="post" enctype="multipart/form-data">
                <div class="form-group"></div>
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input id="username" class="form-control" type="text" placeholder="请输入用户名" name="username"/>
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input id="password" class="form-control" type="password" placeholder="请输入密码" name="password"/>
                </div>
                <input type="submit" class="btn btn-success" value="保存"/>
            </form>
        </div>
    </div>
</rapid:override>
<%@ include file="../homepage.jsp" %>

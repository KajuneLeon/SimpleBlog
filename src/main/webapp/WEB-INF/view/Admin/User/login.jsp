<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<rapid:override name="altHead">
    <script type="text/javascript">
        $(function () {
            if (${not empty cookieRememberMe}) {
                    $("#rememberMe").attr("checked", true);
            } else {
                    $("#rememberMe").removeAttr("checked");
            }
        })
    </script>
</rapid:override>--%>

 <%--重写siteContent--%>
 <%--用户登录页--%>
<rapid:override name="siteContent">
    <div class="container">
        <div style="font-size: 50px; color: white; text-align: center">登录</div>
        <div class="container userContainer">
            <form action="/loginVerify" method="post">
                <div class="form-group"></div>
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input id="username" class="form-control"
                           type="text" placeholder="请输入用户名"
                           name="username" value="${empty username ? cookieUsername : username}"/>
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input id="password" class="form-control"
                           type="password" placeholder="请输入密码"
                           name="password" value="${empty password ? cookiePassword : password}"/>
                </div>
                <div class="checkbox">
                    <label>
                        <c:if test="${empty cookieRememberMe}">
                            <input id= "rememberMe" type="checkbox" name="rememberMe" value="yes">记住用户名和密码?
                        </c:if>
                        <c:if test="${not empty cookieRememberMe}">
                            <input id= "rememberMe" type="checkbox" name="rememberMe" value="yes" checked>记住用户名和密码?
                        </c:if>
                    </label>
                </div>
                <div class="form-group">
                    <span style="color: red">${empty errorMsg ? "请输入用户名和密码" : errorMsg}</span>
                </div>
                <input type="submit" class="btn btn-success" value="登录"/>
            </form>
        </div>
    </div>
</rapid:override>
<%@ include file="../homepage.jsp" %>

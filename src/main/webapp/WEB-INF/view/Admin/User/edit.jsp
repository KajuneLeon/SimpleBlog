<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<%-- 重写siteContent --%>
<%-- 用户信息表单 --%>
<rapid:override name="siteContent">
    <div class="container">
        <div style="font-size: 50px; color: white; text-align: center">用户信息</div>
        <div class="container userContainer">
            <div class="form-group">
                <h3 style="color: red">${empty msg ? "": msg}</h3>
            </div>
            <form action="/admin/user/updatePortrait" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="avatar">头像</label><br/>
                    <img id="avatarImg"class="img-rounded" src="${user.userPortrait}" style="width: 100px;height: 100px"/><br/><br/>
                    <input id="avatar" class="btn btn-success" type="file" accept="image/jpeg" name="portrait"/><br/>
                    <input type="submit" class="btn btn-success" type="text" value="上传"/>
                </div>
            </form>
            <form action="/admin/user/update/${user.userId}" method="post">
                <input type="hidden" name="_method" value="PUT"/>
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input id="username" class="form-control" type="text" value="${user.userName}" name="userName"/>
                    <h5 id="usernameMsg"style="color: red"></h5>
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input id="password" class="form-control" type="password" value="${user.userPassword}" name="userPassword"/>
                </div>
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input id="email" class="form-control" type="text" value="${user.userEmail}" name="userEmail"/>
                </div>
                <div class="form-group">
                    <label for="github">GitHub</label>
                    <input id="github" class="form-control" type="text" value="${user.userGithub}" name="userGithub"/>
                </div>
                <div class="form-group">
                    <label for="description">自我描述</label>
                    <textarea id="description" class="form-control" name="userDescript">${user.userDescript}</textarea>
                </div>
                <input type="submit" class="btn btn-success" type="text" value="保存"/>
            </form>
        </div>
        <br/><br/><br/>
    </div>
    <%-- 头像上传预览 --%>
    <script type="text/javascript">
        $("#avatar").change(function(){
            var objUrl = getObjectURL(this.files[0]) ;//获取文件信息
            console.log("objUrl = "+objUrl);
            if (objUrl) {
                $("#avatarImg").attr("src", objUrl);
            }
        });
        function getObjectURL(file) {
            var url = null;
            if(window.createObjectURL!=undefined) {
                url = window.createObjectURL(file) ;
            }else if (window.URL!=undefined) { // mozilla(firefox)
                url = window.URL.createObjectURL(file) ;
            }else if (window.webkitURL!=undefined) { // webkit or chrome
                url = window.webkitURL.createObjectURL(file) ;
            }
            return url ;
        }
    </script>
    <%-- 用户名检查 --%>
    <script type="text/javascript">
        <%
            String basePath = request.getScheme()+ "://" + request.getServerName()
            + ":" + request.getServerPort()
            + request.getContextPath();
            pageContext.setAttribute("basePath", basePath);
        %>
        $("#username").blur(function () {
            $.ajax({
                url:"${basePath}" + "/admin/user/checkUserName",
                data:"userId=${user.userId}&userName="+$("#username").val(),
                type:"GET",
                success: function (data) {
                    $("#usernameMsg").html(data);
                },
                dataType:"json"
            })
        })
    </script>

</rapid:override>
<%@ include file="../homepage.jsp" %>

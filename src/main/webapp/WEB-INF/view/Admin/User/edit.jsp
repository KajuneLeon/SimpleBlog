<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<%-- 重写siteContent --%>
<%-- 用户信息表单 --%>
<rapid:override name="siteContent">
    <div class="container">
        <div style="font-size: 50px; color: white; text-align: center">用户信息</div>
        <div class="container userContainer">
            <form action="#" method="post" enctype="multipart/form-data">
                <div class="form-group"></div>
                <div class="form-group">
                    <label for="avatar">头像</label><br/>
                    <img id="avatarImg"class="img-rounded" src="/uploads/github.jpg" style="width: 100px;height: 100px"/><br/><br/>
                    <input id="avatar" class="btn btn-success" type="file" name="avatar"/>
                </div>
                <div class="form-group">
                    <label for="username">用户名</label>
                    <input id="username" class="form-control" type="text" value="#Username" name="username"/>
                </div>
                <div class="form-group">
                    <label for="password">密码</label>
                    <input id="password" class="form-control" type="password" placeholder="请输入密码" name="password"/>
                </div>
                <div class="form-group">
                    <label for="email">邮箱</label>
                    <input id="email" class="form-control" type="text" value="#Email" name="email"/>
                </div>
                <div class="form-group">
                    <label for="github">GitHub</label>
                    <input id="github" class="form-control" type="text" value="#GitHub" name="github"/>
                </div>
                <div class="form-group">
                    <label for="description">自我描述</label>
                    <textarea id="description" class="form-control" name="description"></textarea>
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

</rapid:override>
<%@ include file="../homepage.jsp" %>

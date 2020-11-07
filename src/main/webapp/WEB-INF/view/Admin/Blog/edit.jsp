<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<%-- 重写siteContent --%>
<%-- 用户信息表单 --%>
<rapid:override name="siteContent">
    <div class="container">
        <div style="font-size: 50px; color: white; text-align: center">博客信息</div>
        <div class="container userContainer">
            <div class="form-group">
                <h3 style="color: red">${empty msg ? "": msg}</h3>
            </div>
            <form action="/admin/blog/updatePortrait" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="avatar">博客头像</label><br/>
                    <img id="avatarImg"class="img-rounded" src="${blogConfig.blogPortrait}" style="width: 100px;height: 100px"/><br/><br/>
                    <input id="avatar" class="btn btn-success" type="file" accept="image/jpeg" name="portrait"/><br/>
                    <input type="submit" class="btn btn-success" type="text" value="上传"/>
                </div>
            </form>
            <form action="/admin/blog/update" method="post">
                <input type="hidden" name="_method" value="PUT"/>
                <input type="hidden" name="blogId" value="${blogConfig.blogId}"/>
                <input type="hidden" name="blogPortrait" value="${blogConfig.blogPortrait}">
                <div class="form-group">
                    <label for="blogName">博客名</label>
                    <input id="blogName" class="form-control" type="text" value="${blogConfig.blogName}" name="blogName"/>
                </div>
                <div class="form-group">
                    <label for="blogSubtitle">副标题</label>
                    <input id="blogSubtitle" class="form-control" type="text" value="${blogConfig.blogSubtitle}" name="blogSubtitle"/>
                </div>
                <div class="form-group">
                    <label for="blogEmail">邮箱</label>
                    <input id="blogEmail" class="form-control" type="text" value="${blogConfig.blogEmail}" name="blogEmail"/>
                </div>
                <div class="form-group">
                    <label for="blogGithub">GitHub</label>
                    <input id="blogGithub" class="form-control" type="text" value="${blogConfig.blogGithub}" name="blogGithub"/>
                </div>
                <div class="form-group">
                    <label for="blogQQ">QQ</label>
                    <input id="blogQQ" class="form-control" type="text" value="${blogConfig.blogQQ}" name="blogQQ"/>
                </div>
                <div class="form-group">
                    <label for="blogDescript">博客描述</label>
                    <textarea id="blogDescript" class="form-control" name="blogDescript">${blogConfig.blogDescript}</textarea>
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

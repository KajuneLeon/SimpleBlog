<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<rapid:override name="altHead">
    <link rel="stylesheet" href="/backend/editor/css/editormd.css"/>
    <script src="/backend/editor/editormd.min.js"></script>
</rapid:override>

<%-- 重写siteContent--%>
<%-- 文章编辑器 --%>
<rapid:override name="siteContent">
    <div class="container">
        <div style="font-size: 50px; color: white; text-align: center">撰写文章</div>
        <div class="container mdContainer">
            <div class="form-group"></div>
            <form action="/admin/article/submitArticle" method="post">

                <c:if test="${not empty article}">
                    <input type="hidden" value="${article.articleId}" name="articleId"/>
                    <input type="hidden" value="PUT" name="_method"/>
                </c:if>

                <c:if test="${empty article}">
                    <input type="hidden" value="POST" name="_method"/>
                </c:if>

                <div class="form-group" style="text-align: center">
                    <label>标题&nbsp;&nbsp;<input name="articleTitle" type="text" value="${article.articleTitle}"></label>
                </div>
                <div id="layout" class="editor">
                    <div id="blog-editormd">
                        <textarea>${article.articleContentMD}</textarea>
                    </div>
                </div>
                <div class="radio form-group" style="text-align: center">
                    <input type="radio" name="articleStatus" id="publish" value="1">发布
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="articleStatus" id="draft" value="0" checked>草稿
                </div>
                <div style="text-align: center" class="form-group">
                    分类
                    <select id="parentCategory" name="articleCategoryId">
                        <c:forEach items="${categories}" var="category">
                            <c:if test="${category.categoryPId==0}">
                                <c:if test="${category.categoryId==article.articleCategoryId}">
                                    <option value="${category.categoryId}" selected>--- ${category.categoryName} ---</option>
                                </c:if>
                                <c:if test="${category.categoryId!=article.articleCategoryId}">
                                    <option value="${category.categoryId}">--- ${category.categoryName} ---</option>
                                </c:if>
                            </c:if>
                            <c:if test="${category.categoryPId!=0}">
                                <c:if test="${category.categoryId==article.articleCategoryId}">
                                    <option value="${category.categoryId}" selected>${category.categoryName}</option>
                                </c:if>
                                <c:if test="${category.categoryId!=article.articleCategoryId}">
                                    <option value="${category.categoryId}">${category.categoryName}</option>
                                </c:if>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div style="text-align: center" class="form-group">
                    <input type="submit" class="btn btn-success"/>
                </div>
            </form>
        </div>
        <br/><br/><br/>
    </div>

    <script type="text/javascript">
        var testEditor;
        testEditor = editormd("blog-editormd", {
            placeholder:'本编辑器支持Markdown编辑，左边编写，右边预览',  //默认显示的文字，这里就不解释了
            width: "90%",
            height: "70%",
            syncScrolling: "single",
            path: "/backend/editor/lib/",
            saveHTMLToTextarea: true,
            emoji: false,
            taskList: true,

            // 图片上传
            imageUpload : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "/admin/article/imageUpload",

            tocm: true,         // Using [TOCM]
            tex: true,                   // 开启科学公式TeX语言支持，默认关闭
            flowChart: true,             // 开启流程图支持，默认关闭
            sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
            toolbarIcons : function() {  //自定义工具栏，后面有详细介绍
                return editormd.toolbarModes['full']; // full, simple, mini
            },
        });
    </script>

</rapid:override>

<%@ include file="../homepage.jsp" %>

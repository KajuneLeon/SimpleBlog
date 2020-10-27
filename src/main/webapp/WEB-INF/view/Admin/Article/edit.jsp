<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

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
                <div id="layout" class="editor">
                    <div id="blog-editormd">
                        <textarea></textarea>
                    </div>
                </div>
                <div class="radio" style="text-align: center; font-size: 15px">
                    <label>
                        <input type="radio" name="isPublish" id="publish" value="1" checked>发布
                    </label>
                    &nbsp;&nbsp;
                    <label>
                        <input type="radio" name="isPublish" id="draft" value="0">草稿
                    </label>
                </div>
                <div style="text-align: center">
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
            tocm: true,         // Using [TOCM]
            tex: true,                   // 开启科学公式TeX语言支持，默认关闭
            flowChart: true,             // 开启流程图支持，默认关闭
            sequenceDiagram: true,       // 开启时序/序列图支持，默认关闭,
            toolbarIcons : function() {  //自定义工具栏，后面有详细介绍
                return editormd.toolbarModes['simple']; // full, simple, mini
            },
        });
    </script>

</rapid:override>

<%@ include file="../homepage.jsp" %>

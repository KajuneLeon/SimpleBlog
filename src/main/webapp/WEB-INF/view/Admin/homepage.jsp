<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<html lang="zh">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>后台管理</title>
        <link rel="shortcut icon" href="/uploads/github.jpg">
        <link rel="stylesheet" type="text/css" href="/backend/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="/backend/css/style.css">
        <script src="/backend/js/jquery-2.2.1.min.js"></script>
        <script src="/backend/js/bootstrap.min.js"></script>

        <%-- 可选择重写块，用于引入外部文件、JS编写--%>
        <rapid:block name="altHead">

        </rapid:block>
    </head>
    <body>
        <div id="wrapper">
            <div class="overlay"></div>
            <!-- 侧边栏 -->
            <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
                <ul class="nav sidebar-nav">
                    <li class="sidebar-brand"><a href="#">Kajune's Blog</a></li>
                    <li>
                        <img class="img-rounded" src="/uploads/github.jpg" alt="头像"/>
                    </li>
                    <li>
                        <a href="/admin/user"><i class="glyphicon glyphicon-user"></i>&nbsp;&nbsp;&nbsp;&nbsp;Hi, #username</a>
                    </li>
                    <li>
                        <a href="/"><i class="glyphicon glyphicon-home"></i>&nbsp;&nbsp;&nbsp;&nbsp;主页</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="glyphicon glyphicon-list"></i>&nbsp;&nbsp;&nbsp;&nbsp;文章 <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li class="dropdown-header">文章区</li>
                            <li><a href="/admin/article/edit"><i class="glyphicon glyphicon-italic"></i>&nbsp;&nbsp;撰写文章</a></li>
                            <li><a href="/admin/article/list"><i class="glyphicon glyphicon-book"></i>&nbsp;&nbsp;全部文章</a></li>
                            <li><a href="/admin/category"><i class="glyphicon glyphicon-tags"></i>&nbsp;&nbsp;全部分类</a></li>
                        </ul>
                    </li>
                    <li>
                        <!-- Button trigger modal -->
                        <a href="#" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-comment"></i>&nbsp;&nbsp;&nbsp;&nbsp;评论</a>
                    </li>
                    <li>
                        <a href="#"><i class="glyphicon glyphicon-ice-lolly"></i>&nbsp;&nbsp;&nbsp;&nbsp;退出</a>
                    </li>
                </ul>
            </nav>
            <!-- /#侧边栏 -->

            <!-- 主页内容 -->
            <div id="page-content-wrapper" class="container background">
                <%-- 侧边栏开关按钮 --%>
                <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
                    <span class="hamb-top"></span>
                    <span class="hamb-middle"></span>
                    <span class="hamb-bottom"></span>
                </button>

                <%-- 需要重写 --%>
                <rapid:block name="siteContent">
                    <div class="middle">
                        <h1 style="color:white; font-size: 56px">欢迎回来!</h1>
                        <h1 style="color:white; font-size: 56px">#username</h1>
                    </div>
                </rapid:block>

            </div>
            <!-- /#主页内容 -->

            <!-- 评论模态框 -->
            <div class="modal fade container" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">温馨提示</h4>
                        </div>
                        <div class="modal-body">
                            对不起，评论功能将于后续版本开放！
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-success" data-dismiss="modal">关闭</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                var trigger = $('.hamburger'),
                    overlay = $('.overlay'),
                    isClosed = false;

                trigger.click(function () {
                    hamburger_cross();
                });

                function hamburger_cross() {

                    if (isClosed == true) {
                        overlay.hide();
                        trigger.removeClass('is-open');
                        trigger.addClass('is-closed');
                        isClosed = false;
                    } else {
                        overlay.show();
                        trigger.removeClass('is-closed');
                        trigger.addClass('is-open');
                        isClosed = true;
                    }
                }

                $('[data-toggle="offcanvas"]').click(function () {
                    $('#wrapper').toggleClass('toggled');
                });
            });
        </script>
    </body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nicon
  Date: 2020/10/8
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>success</title>
    </head>
    <body>
        ${blogMd}
        ${test}
        <c:forEach begin="1" end="10" var="i">
            ${i}<br/>
        </c:forEach>
    </body>
</html>

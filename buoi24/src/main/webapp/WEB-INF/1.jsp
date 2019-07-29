<%--
  Created by IntelliJ IDEA.
  User: nopain2110
  Date: 27/07/2019
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hihi</title>
</head>
<body>
hihi
<%
    String hihi = (String) request.getAttribute("hihi");
%>
<script>
    alert("<%=hihi%>");
</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: nopain21
  Date: 03/08/2019
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <%@include file="components/navbar.jsp"%>
    <div class="container">
        <form action="insert" method="post">
            <div class="form-group">
                <label for="name">Họ và tên: </label>
                <input type="text" id="name" name="name" class="form-control" required />
            </div>
            <div class="form-group">
                <label for="major">Khoa: </label>
                <input type="text" id="major" name="major" class="form-control" required />
            </div>
            <div class="form-group">
                <label for="class">Lớp: </label>
                <input type="text" id="class" name="class" class="form-control" required />
            </div>
            <button type="submit" class="btn btn-primary">Thêm</button>
            <a href="index.jsp" class="btn btn-danger">Hủy</a>
        </form>
    </div>
</body>
</html>

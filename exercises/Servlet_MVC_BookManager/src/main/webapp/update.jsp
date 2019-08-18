<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nopain
  Date: 8/18/19
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<%@include file="components/nav_bar.jsp"%>
<c:set var="book" value="${requestScope.book}"/>

<div class="container">
    <form method="post" action="update">
        <div class="form-group" hidden>
            <label>
                <input type="number" name="id" value="${book.getId()}" />
            </label>
        </div>
        <div class="form-group">
            <label for="title">Tiêu đề: </label>
            <input type="text" class="form-control" id="title" name="title" placeholder="Nhập tiêu đề"
                   value="${book.getTitle()}" required />
        </div>
        <div class="form-group">
            <label for="author">Tác giả: </label>
            <input type="text" class="form-control" id="author" name="author" placeholder="Nhập tên tác giả"
                   value="${book.getAuthor()}" required />
        </div>
        <div class="form-group">
            <label for="price">Giá: </label>
            <input type="number" class="form-control" id="price" name="price" placeholder="Nhập giá bán"
                   value="${book.getPrice()}" required />
        </div>
        <div class="form-group">
            <label for="quantity">Số lượng: </label>
            <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Nhập số lượng"
                   value="${book.getQuantity()}" required />
        </div>
        <button type="submit" class="btn btn-primary">Sửa</button>
        <a class="btn btn-danger" href="home" role="button">Hủy</a>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

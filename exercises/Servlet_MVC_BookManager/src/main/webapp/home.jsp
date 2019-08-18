<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .table td, .table th {
            vertical-align: middle;
        }
    </style>
</head>
<body>
    <%@include file="components/nav_bar.jsp"%>

    <div class="container">
        <table class="table table-hover text-center">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Tiêu đề</th>
                    <th scope="col">Tác giả</th>
                    <th scope="col">Giá</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Chức năng</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${requestScope.bookList}" varStatus="loop">
                <c:set var="id" value="${book.getId()}" />
                <tr>
                    <th scope="row">${loop.index + 1}</th>
                    <td >${book.getTitle()}</td>
                    <td >${book.getAuthor()}</td>
                    <td >${book.getPrice()}</td>
                    <td >${book.getQuantity()}</td>
                    <td >
                        <a class="btn btn-primary" href="update?id=${id}" role="button">Sửa</a>
                        <button type="button" class="btn btn-danger" onclick="confirmDelete(${id}, '${book.getTitle()}', '${book.getAuthor()}')">
                            Xóa
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br/>
        <a class="btn btn-success" href="create" role="button">Thêm</a>
    </div>
    <br />

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script>
        function confirmDelete(id, title, author) {
            let r = confirm("Bạn chắc chắn muốn xóa sách " + title + " của tác giả " + author + "?");

            if (r) {
                window.open("delete?id=" + id, "_self");
            }
        }
    </script>
</body>
</html>

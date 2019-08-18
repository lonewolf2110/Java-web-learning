<%--
  Created by IntelliJ IDEA.
  User: nopain
  Date: 8/18/19
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
    <%@include file="components/nav_bar.jsp"%>

    <div class="container">
        <form method="post" action="create">
            <div class="form-group">
                <label for="full_name">Họ tên: </label>
                <input type="text" class="form-control" id="full_name" name="full_name" placeholder="Nhập họ tên" required />
            </div>
            <div class="form-group">
                <label for="class">Lớp: </label>
                <input type="text" class="form-control" id="class" name="class" placeholder="Nhập tên lớp" required />
            </div>
            <div class="form-group">
                <label for="address">Địa chỉ: </label>
                <input type="text" class="form-control" id="address" name="address" placeholder="Nhập địa chỉ" required />
            </div>
            <div class="form-group">
                <label for="score">Điểm trung bình: </label>
                <input type="number" class="form-control" id="score" name="score" step="0.01" placeholder="Nhập điểm trung bình" required />
            </div>
            <button type="submit" class="btn btn-primary">Thêm</button>
            <a class="btn btn-danger" href="home" role="button">Hủy</a>
        </form>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

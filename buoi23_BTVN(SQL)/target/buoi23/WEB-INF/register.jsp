<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Buoi 23</title>
</head>
<body>
<form action="register" method="post">
    <table>
        <tr>
            <td><label for="username">Username: </label></td>
            <td><input id="username" type="text" name="username" required /></td>
        </tr>
        <tr>
            <td><label for="password">Password: </label></td>
            <td><input id="password" type="password" name="password" required /></td>
        </tr>
        <tr>
            <td><label for="fullName">Fullname: </label></td>
            <td><input id="fullName" type="text" name="fullName" required /></td>
        </tr>
        <tr>
            <td><label for="email">Email: </label></td>
            <td><input id="email" type="email" name="email" required /></td>
        </tr>
        <tr>
            <td><label for="address">Address: </label></td>
            <td><textarea id="address" name="address" required ></textarea></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit" /></td>
            <td><input id="clear-btn" type="button" value="Clear"/> </td>
        </tr>
    </table>
</form>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        document.getElementById("clear-btn").addEventListener("click", () => clear());
    });

    function clear() {
        document.getElementById("address").value = "";
        const inputs = document.getElementsByTagName("input");

        for (let i = 0; i < 4; i++) {
            inputs[i].value = "";
        }
    }
</script>

<%
    String sttStr = request.getParameter("status");
    int status = sttStr == null ? 0 : Integer.parseInt(sttStr);

    if (status == 403) {
%>
<script>alert("Tên đăng nhập đã tồn tại");</script>
<%
    }

    if (status == 500) {
%>
<script>alert("Lỗi server");</script>
<%
    }
%>
</body>
</html>
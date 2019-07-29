<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h1>LOGIN FORM</h1>
<form action="login" method="post">
    <table>
        <tr>
            <td><label for="username">Username</label></td>
            <td><input id="username" type="text" name="username" required /> </td>
        </tr>
        <tr>
            <td><label for="password">Password</label></td>
            <td><input id="password" type="password" name="password" required /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Login"></td>
            <td><input type="button" value="Reset" /></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <a href="register">Create new user?</a>
            </td>
        </tr>
    </table>

    <%
        String sttStr = request.getParameter("status");
        int status = sttStr == null ? 0 : Integer.parseInt(sttStr);

        if (status == 401) {
    %>
    <script>alert("Sai tên đăng nhập hoặc mật khẩu");</script>
    <%
        }

        if (status == 500) {
    %>
    <script>alert("Lỗi server");</script>
    <%
        }
    %>
</form>
</body>
</html>
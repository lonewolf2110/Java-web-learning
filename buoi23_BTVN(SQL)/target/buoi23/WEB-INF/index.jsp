<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String username = (String) session.getAttribute("username");
    String password = (String) session.getAttribute("password");
    String email = (String) session.getAttribute("email");
    String fullName = (String) session.getAttribute("fullName");
    String address = (String) session.getAttribute("address");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
       div.container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
       }
       table {
           border-collapse: separate;
       }
       table, td, th {
           border: 1px solid black;
       }
    </style>
</head>
<body>
    <div class="container">
        <h1> Hello <%=username%></h1>
        <p>Your information</p>
        <table>
            <tr>
                <th>Name</th>
                <th>Value</th>
            </tr>
            <tr>
                <td>pwd</td>
                <td><%=password%></td>
            </tr>
            <tr>
                <td>uname</td>
                <td><%=username%></td>
            </tr>
            <tr>
                <td>em</td>
                <td><%=email%></td>
            </tr>
            <tr>
                <td>add</td>
                <td><%=address%></td>
            </tr>
            <tr>
                <td>fname</td>
                <td><%=fullName%></td>
            </tr>
        </table>
        <a href="logout">Dang xuat</a>
    </div>
</body>
</html>
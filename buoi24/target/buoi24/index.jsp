<%@ page import="db.MySQLConnector" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %><%--
  Created by IntelliJ IDEA.
  User: nopain2110
  Date: 27/07/2019
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hihi</title>
    <style>
        td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Ten</th>
            <th>Lop</th>
            <th>Dia chi</th>
            <th>Diem TB</th>
        </tr>
        <%
            try {
                Connection conn = MySQLConnector.connect("java_web_learning", "root", "");
                String query = "SELECT * FROM SinhVien";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String className = resultSet.getString("class");
                    String address = resultSet.getString("address");
                    float score = resultSet.getFloat("score");
                    %>
                    <tr>
                        <td><%=name%></td>
                        <td><%=className%></td>
                        <td><%=address%></td>
                        <td><%=score%></td>
                    </tr>
                    <%
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        %>
    </table>
</body>
</html>

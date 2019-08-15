<%@ page import="java.sql.Connection" %>
<%@ page import="db.MySQLConnector" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: nopain2110
  Date: 28/07/2019
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buoi 25</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .table  > tbody > tr > td, th {
            vertical-align: middle;
        }
    </style>
</head>
<body>
    <%@include file="components/navbar.jsp"%>

    <div class="container">
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Khoa</th>
                    <th scope="col">Lớp</th>
                    <th scope="col">Chức năng</th>
                </tr>
            </thead>
            <tbody>
            <%
                Connection conn = MySQLConnector.connect("java_web_learning", "root", "");
                String query = "SELECT * FROM SinhVien";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                for (int idx = 1; resultSet.next(); idx++) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String major = resultSet.getString("major");
                    String classname = resultSet.getString("class");
                    %>
                <tr id="tr<%=id%>">
                    <th scope="row" style="vertical-align: middle">
                        <span class="idx"><%=idx%></span>
                    </th>
                    <td>
                        <span id="nameSpan<%=id%>"><%=name%></span>
                        <input id="nameInp<%=id%>" type="text" class="form-control" value="<%=name%>" hidden>
                    </td>
                    <td>
                        <span id="majorSpan<%=id%>"><%=major%></span>
                        <input id="majorInp<%=id%>" type="text" class="form-control" value="<%=major%>" hidden>
                    </td>
                    <td>
                        <span id="classSpan<%=id%>"><%=classname%></span>
                        <input id="classInp<%=id%>" type="text" class="form-control" value="<%=classname%>" hidden>
                    </td>
                    <td>
                        <button type="button" class="btn btn-primary" onclick="enableUpdate(<%=id%>)">Sua</button>
                        <button type="button" class="btn btn-danger" onclick="deleteRow(<%=id%>)">Xoa</button>
                    </td>
                </tr>
                    <%
                }

                statement.close();
                conn.close();
            %>
            </tbody>
        </table>

        <a href="insert" class="btn btn-success">Thêm</a>
    </div>

    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>

    <script>
        const elemNames = ["name", "major", "class"];
        function deleteRow(id) {
            $.ajax({
               url: "delete",
                method: "post",
                data: {
                   id: id
                },
                success: function (result) {
                   alert("Xóa thành công");
                   location.reload();
                },
                error: function (error) {
                    alert("Lỗi!");
                }
            });
        }

        function enableUpdate(id) {
            
            elemNames.forEach(function (element) {
                const spanSelector = "#" + element + "Span" + id;
                const inpSelector = "#" + element + "Inp" + id;
                $(spanSelector).attr("hidden", true);
                $(inpSelector).attr("hidden", false);

                $(inpSelector).keypress(function ( event ) {
                    if (event.which === 13) {
                        update(id);
                    }
                })
            });
        }

        function update(id) {
            elemNames.forEach(function (element) {
                const spanSelector = "#" + element + "Span" + id;
                const inpSelector = "#" + element + "Inp" + id;

                $(spanSelector).attr("hidden", false);
                $(inpSelector).attr("hidden", true);

                const oldVal = $(spanSelector).text();
                const newVal = $(inpSelector).val();

                if (oldVal !== newVal) {
                    $(spanSelector).text(newVal);

                    $.ajax({
                        url: "update",
                        method: "post",
                        data: {
                            column: element,
                            id: id,
                            newValue: newVal
                        },
                        success: function (result) {
                            alert("Sửa thành công!");
                        },
                        error: function (error) {
                            alert("Lỗi!");
                        }
                    })
                }
            })
        }
    </script>
</body>
</html>

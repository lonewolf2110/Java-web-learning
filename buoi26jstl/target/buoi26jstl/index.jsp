<%--
  Created by IntelliJ IDEA.
  User: nopain
  Date: 8/10/19
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>JSTL</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <c:set var="page" value="${param.page}"/>
    <c:set var="search" value="${param.search}"/>

    <c:choose>
        <c:when test="${empty search}">
            <c:set var="where" value="WHERE 1"/>
            <c:set var="searchUri" value="" />
        </c:when>
        <c:otherwise>
            <c:set var="where" value="WHERE LOCATE('${search}', title) > 0 OR LOCATE('${search}', content)"/>
            <c:set var="searchUri" value="search=${search}" />
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${empty page}">
            <c:set var="limit" value="LIMIT 3"/>
        </c:when>
        <c:otherwise>
            <c:set var="limit" value="LIMIT ${(page - 1) * 3}, 3"/>
        </c:otherwise>
    </c:choose>

    <sql:setDataSource var="dataSource" driver="com.mysql.cj.jdbc.Driver"
                       url="jdbc:mysql://localhost/java_web_learning" user="root" password=""/>
    <sql:query var="result" dataSource="${dataSource}">
        SELECT * FROM TinTuc1 ${where} ${limit}
    </sql:query>
    <sql:query var="count" dataSource="${dataSource}">
        SELECT * FROM TinTuc1 WHERE 1
    </sql:query>

    <fmt:formatNumber var="pageNums" value="${count.rowCount / 3}"  maxFractionDigits="0" />

    <c:forEach items="${count.rows}" var="row">
        <c:out value="${row.count}"/>
    </c:forEach>

    <nav class="navbar navbar-dark bg-dark">
        <a class="navbar-brand" href="index.jsp">Tin nhanh</a>
    </nav>

    <div class="container">
        <br/>
        <form action="index.jsp" method="get">
            <div class="form-group">
                <label for="search">Search</label>
                <input type="text" class="form-control" id="search" name="search">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        <br/>

        <c:forEach items="${result.rows}" var="row">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <h5 class="col card-title">${row.title}</h5>
                        <h6 class="col card-subtitle text-muted" style="text-align: right">3 days ago</h6>
                    </div>
                    <p class="card-text">${row.content}</p>
                    <h6 class="card-subtitle text-muted">Dang boi ${row.author}</h6>
                </div>
            </div>
        </c:forEach>

        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach var="idx" begin="${1}" end="${pageNums}" step="1">
                    <c:choose>
                        <c:when test="${idx eq page}">
                            <c:set var="active" value="active"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="active" value=""/>
                        </c:otherwise>
                    </c:choose>
                    <li class="page-item ${active}" aria-current="page">
                        <a class="page-link" href="index.jsp?page=${idx}&${searchUri}">${idx}<span class="sr-only">(current)</span></a>
                    </li>
                </c:forEach>
            </ul>
        </nav>

    </div>



    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>

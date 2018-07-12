<%-- 
    Document   : newjsp
    Created on : Jul 9, 2018, 4:46:29 PM
    Author     : TAND.M
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.List" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page  import="com.test.model.Employees"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="/TestSpring/add"><button>Thêm mới</button></a>   
        <table border="1" cellpadding="5">
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Mail</th>
            <th>Hành động</th>
                <c:forEach var="element" items="${list}">
                <tr>
                <form method="GET" action="/TestSpring/edit">
                    <td><input type="text" name="id"  value="${element.id}"/></td>
                    <td><input type="text" name="name"  value="${element.name}"/></td>
                    <td><input type="text" name="address"  value="${element.address}"/></td>
                    <td><input type="text" name="phone"  value="${element.phone}"/></td>
                    <td><input type="text" name="mail"  value="${element.mail}"/></td>
                    <td>
                        <button type="submit" value="edit" name="edit">Sửa</button>
                        <button type="submit" value="delete" name="delete">Xóa</button>
                    </td>
                </form>
            </tr>
        </c:forEach> 
    </table>
        <form method="POST" action="/TestSpring/getJson">
            <button type="submit">Get Json</button>
        </form>
</body>
</html>
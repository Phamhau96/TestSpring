<%-- 
    Document   : editEmployees
    Created on : Jul 11, 2018, 5:21:38 PM
    Author     : TAND.M
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="GET" action="/TestSpring/update">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value="${employees.id}" required></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="${employees.name}" required></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" value="${employees.address}" required></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="text" name="phone" value="${employees.phone}" required></td>
                </tr>
                <tr>
                    <td>Mail</td>
                    <td><input type="text" name="mail" value="${employees.mail}" required></td>
                </tr>
                <tr>
                    <td>
                        <button type="submit">Submit</button>
                    </td>
                </tr>
            </table>
        </form>
        <div>
            <a href="/TestSpring/">
                <button>Back</button>
            </a>
        </div>
    </body>
</html>

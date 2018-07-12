<%-- 
    Document   : addEmployees
    Created on : Jul 11, 2018, 5:21:09 PM
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
        
        <form method="GET" action="/TestSpring/addEmployees">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" required></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" required></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="text" name="phone" required></td>
                </tr>
                <tr>
                    <td>Mail</td>
                    <td><input type="text" name="mail" required></td>
                </tr>
                <tr>
                    <td><button type="submit">Thêm mới</button></td>
                </tr>
            </table>
        </form>
        <a href="/TestSpring/">
            <button>Back</button>
        </a>
    </body>
</html>
